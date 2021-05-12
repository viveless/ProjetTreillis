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
public class ChoiceBox extends MainDessin {

// initialisation de la choice box noeud
public void start(Stage primaryStage) throws Exception {

ChoiceBox Noeud= new ChoiceBoxNoeud();

choiceBox.getItems().add("Noeud Simple");
choiceBox.getItems().add("Noeud Appui Simple");
choiceBox.getItems().add("Noeud Appui Double");
}
}
