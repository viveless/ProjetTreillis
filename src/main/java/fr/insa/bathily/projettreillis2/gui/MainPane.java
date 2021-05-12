/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.bathily.projettreillis2;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author mbathily01
 */
public class MainPane extends BorderPane {

private static double MULT_POUR_FIT_ALL = 1.1;

    private Groupe model;
    private Controleur controleur;

    private Stage inStage;
    private File curFile;

    private RadioButton rbSelect;
    private RadioButton rbNoeudSimple;
    private RadioButton rbNoeudAppuiSimple;
    private RadioButton rbNoeudAppuiDouble;
    private RadioButton rbBarre;

    private Button bGrouper;
    private Button bSupprimer;

    private BoutonIcone bZoomDouble;
    private BoutonIcone bZoomDemi;
    private BoutonIcone bZoomFitAll;
    
    private BoutonIcone bTranslateGauche;
    private BoutonIcone bTranslateDroite;
    private BoutonIcone bTranslateHaut;
    private BoutonIcone bTranslateBas;
 
    private DessinCanvas cDessin;
    private RectangleHV zoneModelVue;

    private MainMenu menu;

public MainPane(Stage inStage) {
        this(inStage, new Groupe());
    }

    public MainPane(Stage inStage, Groupe model) {
        this(inStage, null, model);
    }
public MainPane(Stage inStage, File fromFile, Groupe model) {
        this.inStage = inStage;
        this.curFile = fromFile;
        this.model = model;
        this.fitAll();
        this.controleur = new Controleur(this);
// bouton séelectionner
        this.rbSelect = new RadioButton("Select");
        this.rbSelect.setOnAction((t) -> {
            this.controleur.boutonSelect(t);
        });
        this.rbNoeudSimple = new RadioButton("Noeud Simple");
        this.rbNoeud.setOnAction((t) -> {
            this.controleur.boutonNoeudSimple(t);
        });
        this.rbNoeudAppuiSimple = new RadioButton("Noeud Appui Simple");
        this.rbPoints.setOnAction((t) -> {
            this.controleur.boutonNoeudAppuiSimple(t);
        });
        this.rbNoeudAppuiDouble = new RadioButton("Noeud");
        this.rbNoeudAppuiDouble.setOnAction((t) -> {
            this.controleur.boutonNoeudAppuiDouble(t);
        });
        this.rbBarre = new RadioButton("Barre");
        this.rbBarre.setOnAction((t) -> {
            this.controleur.boutonSegments(t);
        });
ToggleGroup bgEtat = new ToggleGroup();
        this.rbSelect.setToggleGroup(bgEtat);
        this.rbPoints.setToggleGroup(bgEtat);
        this.rbSegments.setToggleGroup(bgEtat);
        this.rbPoints.setSelected(true);
VBox vbGauche = new VBox(this.rbSelect, this.rbNoeudSimple, this.rbNoeudAppuiSimple, this.rbNoeudAppuiDouble, this.rbBarre);
        this.setLeft(vbGauche);
this.bGrouper = new Button("Grouper");
        this.bGrouper.setOnAction((t) -> {
            this.controleur.boutonGrouper(t);
        });
        this.bSupprimer = new Button("Supprimer");
        this.bSupprimer.setOnAction((t) -> {
            this.controleur.boutonSupprimer(t);
        });
this.bZoomDouble = new BoutonIcone("icones/zoom-in.png",32,32);
        this.bZoomDouble.setOnAction((t) -> {
            this.controleur.zoomDouble();
        });
        this.bZoomDemi = new BoutonIcone("icones/zoom-out.png",32,32);
        this.bZoomDemi.setOnAction((t) -> {
            this.controleur.zoomDemi();
        });
        this.bZoomFitAll = new BoutonIcone("icones/maximize.png",32,32);
        this.bZoomFitAll.setOnAction((t) -> {
            this.controleur.zoomFitAll();
        });
        
        this.bTranslateGauche = new BoutonIcone("icones/left-arrow.png",32,32);
        this.bTranslateGauche.setOnAction((t) -> {
            this.controleur.translateGauche();
        });
        this.bTranslateDroite = new BoutonIcone("icones/right-arrow.png",32,32);
       this.bTranslateDroite.setOnAction((t) -> {
            this.controleur.translateDroite();
        });
         this.bTranslateHaut = new BoutonIcone("icones/up-arrow.png",32,32);
        this.bTranslateHaut.setOnAction((t) -> {
            this.controleur.translateHaut();
        });
        this.bTranslateBas = new BoutonIcone("icones/down-arrow.png",32,32);
       this.bTranslateBas.setOnAction((t) -> {
            this.controleur.translateBas();
        });
         
        HBox hbZoom = new HBox(this.bZoomDouble, this.bZoomDemi, this.bZoomFitAll);
        GridPane gpTrans = new GridPane();
        // add(compo, column , row , columnSpan , rowSpan
        gpTrans.add(this.bTranslateGauche, 0, 1,1,1);
        gpTrans.add(this.bTranslateDroite, 2, 1,1,1);
        gpTrans.add(this.bTranslateHaut, 1, 0,1,1);
        gpTrans.add(this.bTranslateBas, 1, 2,1,1);
        
        VBox vbZoom = new VBox(hbZoom,gpTrans);
        vbZoom.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        VBox vbDroit = new VBox(this.bGrouper,this.bSupprimer, this.cpCouleur, vbZoom);
        this.setRight(vbDroit);

        this.cDessin = new DessinCanvas(this);
        this.setCenter(this.cDessin);

        this.menu = new MainMenu(this);
        this.setTop(this.menu);

        this.controleur.changeEtat(20);

    }

    public void fitAll() {
        this.zoneModelVue = new RectangleHV(this.model.minX(),
                this.model.maxX(), this.model.minY(), this.model.maxY());
        this.zoneModelVue = this.zoneModelVue.scale(MULT_POUR_FIT_ALL);
    }

    public void redrawAll() {
        this.cDessin.redrawAll();
    }
public Groupe getModel() {
        return model;
    }
public Controleur getControleur() {
        return controleur;
    }
 public RadioButton getRbSelect() {
        return rbSelect;
    }
 public RadioButton getRbNoeudSimple(){
        return rbNoeudSimple;
    }
public RadioButton getRbNoeudAppuiSimple(){
        return rbNoeudAppuiSimple;
}
public RadioButton getRbNoeudAppuiDouble(){
        return rbNoeudAppuiDouble;
}
public RadioButton getRbSegments() {
        return rbSegments;
    }
public Button getbGrouper() {
        return bGrouper;
    }
public DessinCanvas getcDessin() {
        return cDessin;
    }
public Stage getInStage() {
        return inStage;
    }
public File getCurFile() {
        return curFile;
    }
public void setCurFile(File curFile) {
        this.curFile = curFile;
    }
 public static double getMULT_POUR_FIT_ALL() {
        return MULT_POUR_FIT_ALL;
    }
public Button getbZoomDouble() {
        return bZoomDouble;
    }
public Button getbZoomDemi() {
        return bZoomDemi;
    }
public Button getbZoomFitAll(){
        return bZoomFitAll;
}
public RectangleHV getZoneModelVue() {
        return zoneModelVue;
    }
public MainMenu getMenu() {
        return menu;
    }
public void setZoneModelVue(RectangleHV zoneModelVue) {
        this.zoneModelVue = zoneModelVue;
    }
public Button getbSupprimer() {
        return bSupprimer;
    }

}
