/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.bathily.projettreillis2;


import java.io.IOException;
import java.io.Writer;
import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;

/**
 *
 * @author maxim
 */

public class Point{
    
    public static double RAYON_IN_DRAW = 5;

    private double px;
    private double py;
    private Numeroteur<Point> num;

    public Point(double px, double py) {
        this.px = px;
        this.py = py;
    }

    public Point(double px, double py, Numeroteur<Point> num) {
        this.px = px;
        this.py = py;
        this.num = num;
    }
    
    public Point() {
        this(0, 0);
    }

    /**
     * initialise comme une copie du point
     * @param modele
     */
    public Point(Point modele) {
        this(modele.px,modele.px);
    }
    
    /**
     * @return the px
     */
    public double getPx() {
        return px;
    }

    /**
     * @param px the px to set
     */
    public void setPx(double px) {
        this.px = px;
    }

    /**
     * @return the py
     */
    public double getPy() {
        return py;
    }
    
    public Numeroteur<Point> getNum(){
        return this.num;
    }

    /**
     * @param py the py to set
     */
    public void setPy(double py) {
        this.py = py;
    }

    @Override
    public String toString() {
        return "(" + px + "," + py + ')';
    }

    public static Point demandePoint() {
        System.out.println("abscisse : ");
        double px = Lire.d();
        System.out.println("ordonnée : ");
        double py = Lire.d();
        return new Point(px, py);
    }

   
    public double maxX() {
        return this.px;
    }

    
    public double minX() {
        return this.px;
    }

  
    public double maxY() {
        return this.py;
    }

   
    public double minY() {
        return this.py;
    }

    
    public double distancePoint(Point p) {
        double dx = this.px - p.px;
        double dy = this.py - p.py;
        return Math.sqrt(dx*dx+dy*dy);

    }

    
    public void dessine(GraphicsContext context) {
        //context.setFill(this.getCouleur());
        context.fillOval(this.px-RAYON_IN_DRAW, this.py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }

    
    public void dessineSelection(GraphicsContext context) {
        //context.setFill(Figure.COULEUR_SELECTION);
        context.fillOval(this.px-RAYON_IN_DRAW, this.py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }

 
    public void save(Writer w, Numeroteur<Point> num) throws IOException {
        if(! num.objExist(this)) {
            int id;
            id = num.creeNum(this);
            w.append("Point;"+id+";"+this.px+";"+this.py+
                    ";" + /** FigureSimple.saveColor(this.getCouleur())**/  "\n");
        }
    }

}
        
