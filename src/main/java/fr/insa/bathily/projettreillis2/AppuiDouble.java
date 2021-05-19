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
public class AppuiDouble extends Appui{

    public AppuiDouble(Numeroteur<Noeud> num, double x, double y) {
        super(num, x, y);
    }
   
    
    public AppuiDouble(Numeroteur<Noeud> num, double []p) {
        super(num, p, col);
    }
   
    public ApppuiDouble(Numeroteur<Noeud> num) {
        super(num);
    }
    
    @Override
    public String toString() {
        return  "Noeud Appui Double {\n" + "id : "+getId()+" ; ("+ this.getPx() +","+ this.getPy() +")\n}";
    }


}
