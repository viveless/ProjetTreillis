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
public class Noeud extends FigureSimple{
    private double px;
    private double py;

        
/** constructeur de la classe noeud*/
public Noeud(int id){
        super(id);
       
}


public String toString(){
    return "[" + px + "," + py + "}";
}


public static Noeud demandeNoeud(){
    System.out.println("abscisse : ");
    double px = Lire.d();
    System.out.println("ordonnee : ");
    double py = Lire.d();
    return new Noeud(px, py);
}

public double maxX(){
    return this.px;
}
}

