/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package fr.insa.bathily.projettreillis2;

import java.io.IOException;
import java.io.Writer;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author maxim
 */

public class Barre {

    private Noeud debut;
    private Noeud fin;
    private TypeBarre type;
    public Numeroteur<Barre> num;
    
    private Treillis treillis;

    public Barre(Noeud debut, Noeud fin, TypeBarre type) {  
        this.debut = debut;
        this.fin = fin;
        this.type = type ; 
    }

    public Barre(Noeud debut, Noeud fin){
        this.debut = debut;
        this.fin = fin;
    }
    
    public Noeud getDebut() {
        return debut;
    }

    public Noeud getFin() {
        return fin;
    }
    
    public double maxX() {
        return Math.max(this.debut.maxX(), this.fin.maxX());
    }

    public double minX() {
        return Math.min(this.debut.maxX(), this.fin.maxX());
    }
    
    public double maxY() {
        return Math.max(this.debut.maxY(), this.fin.maxY());
    }
    
    public double minY() {
        return Math.min(this.debut.minY(), this.fin.minY());
    }
    
    @Override
    public String toString() {
        return "[" + this.debut + "," + this.fin + "]";
    }

    public static TypeBarre demandeTypeBarre(){
            System.out.println("Type 1: bois. \n Type 2: fer. \n Donnez le type de la barre : ");
            int numtype = Lire.i();
            TypeBarre res=null;
            if (numtype == 1){
                res = TypeBarre.typeBois();
            }
            else if (numtype == 2)
                res = TypeBarre.typeFer();
            return res;
        }
            
    
    public static Barre demandeBarre() {
        System.out.println("noeud debut : ");
        Noeud debut = Noeud.demandeNoeud();
        System.out.println("noeud fin : ");
        Noeud fin = Noeud.demandeNoeud();
        System.out.println("type de la barre : ");
        TypeBarre type = null;
        type = demandeTypeBarre();
        return new Barre(debut, fin, type);
    }


    public double distanceNoeud(Noeud p) {
        double x1 = this.debut.getPx();
        double y1 = this.debut.getPy();
        double x2 = this.fin.getPx();
        double y2 = this.fin.getPy();
        double x3 = p.getPx();
        double y3 = p.getPy();
        double up = ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1))
                / (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (up < 0) {
            return this.debut.distanceNoeud(p);
        } else if (up > 1) {
            return this.fin.distanceNoeud(p);
        } else {
            Noeud p4 = new Noeud(x1 + up * (x2 - x1), y1 + up * (y2 - y1)) {};
            return p4.distanceNoeud(p);
        }
    }

    public void dessine(GraphicsContext context) {
        context.strokeLine(this.debut.getPx(), this.debut.getPy(), this.fin.getPx(), this.fin.getPy());
    }

   
    public void dessineSelection(GraphicsContext context) {
        context.strokeLine(this.debut.getPx(), this.debut.getPy(), this.fin.getPx(), this.fin.getPy());
    }

 public void save(Writer w, Numeroteur<Barre> num) throws IOException {
        if (!num.objExist(this)) {
            int id = num.creeNum(this);
            this.debut.save(w, this.debut.getNum());
            this.fin.save(w, this.fin.getNum());
            w.append("Segment" + id +
                    this.debut.getNum() + ";" + this.fin.getNum());
        }
    }

    Treillis getTreillis() {
        return this.treillis;
    }

    void setTreillis(Treillis treillis) {
        this.treillis = treillis;
    }

}

    */
}
