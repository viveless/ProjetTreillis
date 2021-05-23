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
 * @author donia
 */

public class Segment {

    private Point debut;
    private Point fin;
    
    /**
     * @param debut the debut to set
     */
    public void setDebut(Point debut) {
        this.debut = debut;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(Point fin) {
        this.fin = fin;
    }
    
    private Segment() {
        this(null, null);
    }

    public Segment(Point debut, Point fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public Point getDebut() {
        return debut;
    }

    public Point getFin() {
        return fin;
    }

    @Override
    public String toString() {
        return "[" + this.debut + "," + this.fin + ']';
    }

    public static Segment demandeSegment() {
        System.out.println("point début : ");
        Point deb = Point.demandePoint();
        System.out.println("point fin : ");
        Point fin = Point.demandePoint();
        return new Segment(deb, fin);
    }

    
    public double maxX() {
        return Math.max(this.debut.maxX(), this.fin.maxX());
    }

    
    public double minX() {
        return Math.min(this.debut.minX(), this.fin.minX());
    }

    
    public double maxY() {
        return Math.max(this.debut.maxY(), this.fin.maxY());
    }

  
    public double minY() {
        return Math.min(this.debut.minY(), this.fin.minY());
    }

    
    public double distancePoint(Point p) {
        double x1 = this.debut.getPx();
        double y1 = this.debut.getPy();
        double x2 = this.fin.getPx();
        double y2 = this.fin.getPy();
        double x3 = p.getPx();
        double y3 = p.getPy();
        double up = ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1))
                / (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (up < 0) {
            return this.debut.distancePoint(p);
        } else if (up > 1) {
            return this.fin.distancePoint(p);
        } else {
            Point p4 = new Point(x1 + up * (x2 - x1),
                    y1 + up * (y2 - y1));
            return p4.distancePoint(p);
        }
    }

    
    public void dessine(GraphicsContext context) {
        //context.setStroke(this.getCouleur());
        context.strokeLine(this.debut.getPx(), this.debut.getPy(), this.fin.getPx(), this.fin.getPy());
    }

    
    public void dessineSelection(GraphicsContext context) {
      //  context.setStroke(Figure.COULEUR_SELECTION);
        context.strokeLine(this.debut.getPx(), this.debut.getPy(), this.fin.getPx(), this.fin.getPy());
    }

  
    public void save(Writer w, Numeroteur<Segment> num) throws IOException {
        if (!num.objExist(this)) {
            int id = num.creeNum(this);
            this.debut.save(w, this.debut.getNum());
            this.fin.save(w, this.fin.getNum());
            w.append("Segment;" + id + ";" +
                    num.getOrCreateNum(this) + ";" + num.getOrCreateNum(this) +
                    "; \n");
        }
    }

}
