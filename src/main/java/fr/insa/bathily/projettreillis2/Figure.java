/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.bathily.projettreillis2;

/**
 *
 * @author maxim
 */
public abstract class Figure {
    private int id;
    private Groupe groupe;
    
    
    public Groupe getGroupe(){
        return groupe;
    }
    
    void setGroupe (Groupe groupe){
        this.groupe = groupe;
    }
    
    public abstract double maxX();
}
