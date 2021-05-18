/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.bathily.projettreillis2;

/**
 *
 * @author mbathily01
 */
public class Controleur {

private MainPane vue;

    private int etat;

    private Noeud pos1;

    private List<Figure> selection;

    public Controleur(MainPane vue) {
        this.vue = vue;
        this.selection = new ArrayList<>();
    }

public void changeEtat(int nouvelEtat) {
        if (nouvelEtat == 1) {
            // etat de base, sélection par défaut
            this.vue.getRbSelect().setSelected(true);
            this.selection.clear();
            this.vue.redrawAll();
        } else if (nouvelEtat == 20) {
            // creation de barre étape 1
            this.vue.getRbSegments().setSelected(true);
            this.selection.clear();
            this.vue.getbGrouper().setDisable(true);
            this.vue.redrawAll();
        } else if (nouvelEtat == 21) {
            // creation de segments étape 2 todo
            this.vue.getRbSegments().setSelected(true);
            this.selection.clear();
            this.vue.getbGrouper().setDisable(true);
            this.vue.redrawAll();
        } else if (nouvelEtat == 30) {
            // creation de noeuds
            this.vue.getRbNoeudSimple().setSelected(true);
            this.selection.clear();
            this.vue.getbGrouper().setDisable(true);
            this.vue.getbRbBarre().setDisable(true);
            this.vue.getbRbAppuiSimple().setDiasable(true);
            this.vue.getRbAppuiDouble().setDisable(true);
            this.vue.redrawAll();
    }
}
// permet d'avoir un noeud ( point )
// todo faire les différentes catégories de noeuds
    public NoeudSimple posInModel(double xVue, double yVue) {
        Transform modelVersVue = this.vue.getcDessin().getTransform();
        Noeud2D ptrans;
        try {
            ptrans = modelVersVue.inverseTransform(xVue, yVue);
        } catch (NonInvertibleTransformException ex) {
            throw new Error(ex);
        }
        NoeudSimple pclic = new NoeudSimple(ptrans.getX(), ptrans.getY());
        return pclic;
    }
    public AppuiSimple posInModel( double xVue, double yVue){
        Transform modelVersVue = this.vue.getcDessin().getTrasnform();
        Noeud2d ptrans;
        try{
            ptrans= modelversVue.inverseTransform(xVue,yVue);
            }
        catch ( NonInvertibleTransformException ex){
            throw new Error(ex);
            }
        AppuiSimple pclic = new AppuiSimple(ptrans.getX(), ptrans.getY());
        return pclic;
        }

public AppuiDouble posInModel( double xVue, double yVue){
        Transform modelVersVue = this.vue.getcDessin().getTrasnform();
        Noeud2d ptrans;
        try{
            ptrans= modelversVue.inverseTransform(xVue,yVue);
            }
        catch ( NonInvertibleTransformException ex){
            throw new Error(ex);
            }
        AppuieDouble pclic = new AppuieDouble(ptrans.getX(), ptrans.getY());
        return pclic;
        }


public void clicDansZoneDessin(MouseEvent t) {
        if (this.etat == 10) {
            Point pclic = this.posInModel(t.getX(), t.getY());
            // pas de limite de distance entre le clic et l'objet selectionné
            Figure proche = this.vue.getModel().plusProche(pclic, Double.MAX_VALUE);
            // cas ou groupe est vide dc pas de plus proche
            if (proche != null) {
                if (t.isShiftDown()) {
                    this.selection.add(proche);
                } else if (t.isControlDown()) {
                    if (this.selection.contains(proche)) {
                        this.selection.remove(proche);
                    } else {
                        this.selection.add(proche);
                    }
                } else {
                    this.selection.clear();
                    this.selection.add(proche);
                }
                this.activeBoutonsSuivantSelection();
                this.vue.redrawAll();
            }
       
            this.vue.redrawAll();
        } else if (this.etat == 20) {
            this.pos1 = this.posInModel(t.getX(), t.getY());
            this.changeEtat(21);
        } else if (this.etat == 21) {
            Point pclic = this.posInModel(t.getX(), t.getY());
            Segment ns = new Segment(this.pos1, pclic, 
            this.vue.getCpCouleur().getValue());
            this.vue.getModel().add(ns);
            this.vue.redrawAll();
            this.changeEtat(20);

        // noeud simple
        } else if (this.etat == 30) {
            Noeud pclic = this.posInModel(t.getX(), t.getY());
            Groupe model = this.vue.getModel();
            model.add(pclic);
            this.changeEtat(30)
        // appui simple
        } else if (this.etat== 31){
            AppuiSimple pclic = this.posInModel(t.getX(), t.getY());
            Groupe model = this.vue.getModel();
            model.add(pclic);
            this.changeEtat(31);
        // appui double
        }else if (this.etat== 32){
            AppuiDouble pclic = this.posInModel(t.getX(), t.getY());
            Groupe model = this.vue.getModel();
            model.add(pclic);
            this.changeEtat(32);
        }
}
public void boutonSelect(ActionEvent t) {
        this.changeEtat(10);
    }
public void boutonBarre(ActionEvent t) {
        this.changeEtat(20);
    }
public void boutonNoeudSimple(ActionEvent t){
        this.changeEtat(30);
    }
public void boutonAppuiSimple(ActionEvent t){
        this.changeEtat(31);
    }
public void boutonAppuiDouble(ActionEvent t){
        this.changeEtat(32);
    }

// desactivation des boutons inutiles en cas d'utilisation
    private void activeBoutonsSuivantSelection() {
        if (this.selection.size() < 2) {
            this.vue.getbGrouper().setDisable(true);
        } else {
            this.vue.getbGrouper().setDisable(false);
        }
    }
public List<Figure> getSelection() {
        return selection;
    }
// modalités du menu 
private void realSave(File f) {
        try {
            this.vue.getModel().sauvegarde(f);
            this.vue.setCurFile(f);
            this.vue.getInStage().setTitle(f.getName());
        } catch (IOException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Problème durant la sauvegarde");
            alert.setContentText(ex.getLocalizedMessage());

            alert.showAndWait();
        } finally {
            this.changeEtat(10);
        }
    }

    public void menuSave(ActionEvent t) {
        if (this.vue.getCurFile() == null) {
            this.menuSaveAs(t);
        } else {
            this.realSave(this.vue.getCurFile());
        }
    }

    public void menuSaveAs(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showSaveDialog(this.vue.getInStage());
        if (f != null) {
            this.realSave(f);
        }
    }
public void menuOpen(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(this.vue.getInStage());
        if (f != null) {
            try {
                Figure lue = Figure.lecture(f);
                Groupe glu = (Groupe) lue;
                Stage nouveau = new Stage();
                nouveau.setTitle(f.getName());
                Scene sc = new Scene(new MainPane(nouveau, f, glu), 800, 600);
                nouveau.setScene(sc);
                nouveau.show();
            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Problème durant la sauvegarde");
                alert.setContentText(ex.getLocalizedMessage());

                alert.showAndWait();
            } finally {
                this.changeEtat(10);
            }
        }
    }
    public void menuNouveau(ActionEvent t) {
        Stage nouveau = new Stage();
        nouveau.setTitle("Nouveau");
        Scene sc = new Scene(new MainPane(nouveau), 800, 600);
        nouveau.setScene(sc);
        nouveau.show();
    }
public void zoomDouble() {
        this.vue.setZoneModelVue(this.vue.getZoneModelVue().scale(0.5));
        this.vue.redrawAll();
    }

    public void zoomDemi() {
        this.vue.setZoneModelVue(this.vue.getZoneModelVue().scale(2));
        this.vue.redrawAll();
    }

    public void zoomFitAll() {
        this.vue.fitAll();
        this.vue.redrawAll();
    }

}
