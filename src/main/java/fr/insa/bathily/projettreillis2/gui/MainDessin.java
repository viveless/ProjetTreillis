/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.bathily.projettreillis2;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.application.Application;
import javafx.scene.Scene;

/**
 *
 * @author maxim
 */

public class MainDessin extends BorderPane{
    private ToggleButton tbBarre;
    private VBox vbTypeObjet;
    private Button bCop;
    private Button bCol;
    private Button bSave;
    private HBox hbEntite;  
    private VBox bCopCol;
    private ChoiceBox Noeud; 

public MainDessin (){
        this.tbSegment=new ToggleButton("Barre");
        this.tbNoeud=new ToggleButton("Noeud");
        this.vbTypeObjet=new VBox(this.tbBarre, this.tbNoeud);
        this.setLeft(this.vbTypeObjet);
        this.bCop=new Button("Copier");
        this.bCol=new Button("Coller");
        this.bCopCol=new VBox(this.bCop, this.bCol);
        this.bSave=new Button("Enregistrer");
        this.hbEntite=new HBox(this.bSave, this.tbBarre, this.tbNoeud, this.bCopCol);
}
}

