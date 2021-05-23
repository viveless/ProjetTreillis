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

public abstract class Noeud{
    private double px;
    private double py;
    private Numeroteur<Noeud>  num;
    
    private Treillis treillis;


/** constructeur de la classe Noeud
     * @param abs
     * @param ord
     * @param id*/
    
public Noeud(double abs, double ord, Numeroteur<Noeud> id){
        this.px = abs;
        this.py = ord;
        this.num = id;
}

public Noeud(double abs, double ord){
    this.px = abs;
    this.py = ord;
}


public double getPx(){
    return this.px;
}


public void setPx(double px) {
        this.px = px;
    }


public double getPy(){
    return this.py;
}

public void setPy(double py) {
        this.py = py;
    }


@Override
public String toString(){
    return "[" + px + "," + py + "}";
}


public double distanceNoeud(Noeud p) {
        double dx = this.px - p.px;
        double dy = this.py - p.py;
        return Math.sqrt(dx*dx+dy*dy);
}

        
public static Noeud demandeNoeud(){
    System.out.println("abscisse : ");
    double abs = Lire.d();
    System.out.println("ordonnee : ");
    double ord = Lire.d();
    Numeroteur id;
        id = new Numeroteur<Noeud>();
    return new Noeud(abs, ord, id) {};
}


public double maxX(){
    return this.px;
}


public double minX(){
    return this.px;
}


public double maxY(){
    return this.py;
}


public double minY(){
    return this.py;
}

public Numeroteur<Noeud> getNum() {
    return num;
    }
    
public void save(Writer w, Numeroteur<Noeud> num) throws IOException {
        if(! num.objExist(this)) {
            int id;
            id = num.creeNum(this);
            w.append("Point;"+id+";"+this.px+";"+this.py+
                    ";" + /** FigureSimple.saveColor(this.getCouleur())**/  "\n");
        }
    }

    public Treillis getTreillis() {
        return treillis;
    }

    public void setTreillis(Treillis treillis) {
        this.treillis = treillis;
    }
    

}
        




