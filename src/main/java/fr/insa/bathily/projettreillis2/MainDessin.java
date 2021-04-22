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

/**
 *
 * @author maxim
 */

public class MainDessin extends BorderPane{
    private ToggleButton tbSegment;
    private ToggleButton tbPoint;
    private VBox vbTypeObjet;
    private Button bCop;
    private Button bCol;
    private Button bSave;
    private HBox hbEntite;  
    private VBox bCopCol;
    
    
public MainDessin (){
        this.tbSegment=new ToggleButton("Segment");
        this.tbPoint=new ToggleButton("Point");
        this.vbTypeObjet=new VBox(this.tbSegment, this.tbPoint);
        this.setLeft(this.vbTypeObjet);
        this.bCop=new Button("Copier");
        this.bCol=new Button("Coller");
        this.bCopCol=new VBox(this.bCop, this.bCol);
        this.bSave=new Button("Enregistrer");
        this.hbEntite=new HBox(this.bSave, this.tbSegment, this.tbPoint, this.bCopCol);
        }

public class Numeroteur{
    private Map<Integer, Object> cleVersObjet;
    private Map<Object, Integer> objetVersCle;
    private int CleSuivante;
    
public Numeroteur (int CleSuivante){
    this.CleSuivante=CleSuivante;
    this.cleVersObjet=new HashMap();
    this.objetVersCle=new HashMap<>();
}

public Numeroteur (){
    this(0);
}

public boolean estPresent(Object obj){
    return(this.objetVersCle.get(obj)!=null);
}
public int getOrCreateCle(Object obj){
    Integer val=this.objetVersCle.get(obj);
    if(val!=null){
        return val;
    }
    else{
        this.objetVersCle.put(obj, this.CleSuivante);
        this.cleVersObjet.put(this.CleSuivante, obj);
        this.CleSuivante++;
        return this.CleSuivante-1;
    }
}

public void createCle(Object obj){
    this.objetVersCle.put(obj, this.CleSuivante);
    this.cleVersObjet.put(this.CleSuivante, obj);
    this.CleSuivante++;
}

}
}

