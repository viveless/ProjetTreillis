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
public class NoeudAppuiSimple extends Appui {

    public NoeudAppuiSimple(Numeroteur<Noeud> num, double x, double y) {
        super(num, x, y);
    }
   
    
    public NoeudAppuiSimple(Numeroteur<Noeud> num, double []p) {
        super(num, p, col);
    }
   
    // todo : rechercher le "super"
    public NoeudAppuiSimple(Numeroteur<Noeud> num) {
        super(num);
    }
    
    @Override
    public String toString() {
        return  "Noeud Simple {\n" + "id : "+getId()+" ; ("+ this.getPx() +","+ this.getPy() +")\n}";
    }


}
