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
public abstract class Noeud {
    private double px;
    private double py;
    private int id;

        

    public Noeud(Numeroteur<Noeud> num, double x, double y){
        this.px = x;
        this.py = y;
        this.id = num.getOrCreateId(this);
       
}
// get et set + void pour avoir les valeurs
    public double getPx() {
        return px;
    }

    public void setPx(double px) {
        this.px = px;
    }

    public double getPy() {
        return py;
    }

    public void setPy(double py) {
        this.py = py;
    }
    public int getId() {
        return id;
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

}

