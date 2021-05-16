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
public class AppuiSimple extends Appui {


    public AppuiSimple(Numeroteur<Noeud> num, double x, double y) {
        super(num, x, y);
    }
   
    
    public AppuiSimple(Numeroteur<Noeud> num, double []p) {
        super(num, p, col);
    }
   
    // todo : rechercher le "super"
    public AppuiSimple(Numeroteur<Noeud> num) {
        super(num);
    }
    
    @Override
    public String toString() {
        return  "Appui Simple {\n" + "id : "+getId()+" ; ("+ this.getPx() +","+ this.getPy() +")\n}";
    }

/* todo : classe noeud appui double
public class AppuiDouble {

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
        return  "Appui Double {\n" + "id : "+getId()+" ; ("+ this.getPx() +","+ this.getPy() +")\n}";
    }
}
*/

}
