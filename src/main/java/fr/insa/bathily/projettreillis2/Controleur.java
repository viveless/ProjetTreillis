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
            // creation de segments étape 2
        }
        this.etat = nouvelEtat;
        } else if (nouvelEtat == 50) {
            // creation de noeuds
            this.vue.getRbPoints().setSelected(true);
            this.selection.clear();
            this.vue.getbGrouper().setDisable(true);
            this.vue.getbRbSegments().setDisable(true);
            this.vue.redrawAll();
    }
// permet d'avoir un noeud ( point )
public Noeud posInModel(double xVue, double yVue) {
        Transform modelVersVue = this.vue.getcDessin().getTransform();
        Noeud2D ptrans;
        try {
            ptrans = modelVersVue.inverseTransform(xVue, yVue);
        } catch (NonInvertibleTransformException ex) {
            throw new Error(ex);
        }
        Noeud pclic = new Noeud(ptrans.getX(), ptrans.getY());
        pclic.setCouleur(this.vue.getCpCouleur().getValue());
        return pclic;
    }
}
