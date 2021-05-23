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

public class AppuiSimple extends Appui {

    private Numeroteur<Noeud> num;
    private double px;
    private double py;
    private double alpha;

    public AppuiSimple(Numeroteur<Noeud> num, double x, double y) {
        this.num = new Numeroteur<>();
        this.px = x;
        this.py = y;
    }
   
    
    public AppuiSimple(double x, double y) {
        this.px = x;
        this.py = y;
    }

    @Override
    public Numeroteur<Noeud> getNum() {
        return num;
    }

    @Override
    public double getPx() {
        return px;
    }

    @Override
    public double getPy() {
        return py;
    }

    @Override
    public double getAlpha() {
        return alpha;
    }

    public void setNum(Numeroteur<Noeud> num) {
        this.num = num;
    }

    @Override
    public void setPx(double px) {
        this.px = px;
    }

    @Override
    public void setPy(double py) {
        this.py = py;
    }
   
    
    @Override
    public String toString() {
        return  "Appui Simple {\n" + "id : "+getNum()+" ; ("+ this.getPx() +
                ","+ this.getPy() +")\n}";
    }


}
