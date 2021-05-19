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

public abstract class Appuis extends Noeud {
    
    private int idTriangle;
    private int numeroPT;
    private double alpha;
    
    public Appui(Numeroteur<Noeud> num, TriangleTerrain TT, int numeroPT, double alpha) {
        super(num);
        idTriangle = TT.getId();
        this.numeroPT = numeroPT;
        this.alpha = alpha;
        this.setPx(alphaToPx(TT, numeroPT, alpha));
        this.setPy(alphaToPy(TT, numeroPT, alpha));
    }
        
    public Appui(Numeroteur<Noeud> num, TriangleTerrain TT, int numeroPT, double alpha) {
        this(num, TT, numeroPT, alpha);
    }
    
    public Appuis(Numeroteur<Noeud> num, TriangleTerrain TT, int numeroPT, double x, double y) {
        super(num);
        idTriangle = TT.getId();
        this.numeroPT = numeroPT;
        this.setPx(x);
        this.setPy(y);
        this.alpha= 0;
    }
    
    public Appuis(Numeroteur<Noeud> num, TriangleTerrain TT, int numeroPT, double x, double y) {
        this(num, TT, numeroPT, x, y);
    }
    
    public Appuis(Numeroteur<Noeud> num, TriangleTerrain TT, int numeroPT, double [] p) {
        this(num, TT, numeroPT, p[0], p[1]);
    }
    
    public Appuis(Numeroteur<Noeud> num, TriangleTerrain TT, int numeroPT, double [] p) {
        this(num, TT, numeroPT, p[0], p[1]);
    }

    public int getIdTriangle() {
        return idTriangle;
    }

    public int getNumeroPT() {
        return numeroPT;
    }

    public double getAlpha() {
        return alpha;
    }
    
    public double getPx() {
        return alpha;
    }
    
    public static double alphaToPx(TriangleTerrain TT, int numeroPT, double alpha){
        return alpha*TT.getPTx(numeroPT)+(1-alpha)*TT.getPTx((numeroPT+1)%3);
    }
    
    public static double alphaToPy(TriangleTerrain TT, int numeroPT, double alpha){
        return alpha*TT.getPTy(numeroPT)+(1-alpha)*TT.getPTy((numeroPT+1)%3);
        
    }

}
