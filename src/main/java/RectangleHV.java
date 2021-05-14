/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.bathily.projettreillis2;

/**
 *
 * @author donia
 */
public class RectangleHV {
private double xmin ; 
private double xmax ; 
private double ymin;
private double ymax;

public RectangleHV(double xmin , double xmax, double ymin, double ymax ) {
this.xmin=xmin ;
this.xmax=xmax;
this.ymin = ymin ;
this.ymax= ymax ;

public String toString() { 
return "RectangleHV{"+"xmin"+ xmin + ",xmax" +xmax +",ymin"+ymin +",ymax"+ymax+ '}';
}

public RectangleHV scale(double facteur) { 
double dx = this.xmax - this.xmin ;
double dy = this.ymax - this.ymin ;
double cx = (this.xmax+this.xmin)/2 ; 
double cy = (this.ymax+this.ymin)/2 ;
  double nxmin = cx - (dx / 2) * facteur;
        double nxmax = cx + (dx / 2) * facteur;
        double nymin = cy - (dy / 2) * facteur;
        double nymax = cy + (dy / 2) * facteur;
        return new RectangleHV(nxmin, nxmax, nymin, nymax);    
    }
    
   
    public RectangleHV translationGauche(double partieConservee) {
        double dx = (this.xmax - this.xmin)*(1-partieConservee);
        return new RectangleHV(this.xmin-dx,this.xmax-dx,this.ymin,this.ymax);
    }
    
    public RectangleHV translationDroite(double partieConservee) {
        double dx = (this.xmax - this.xmin)*(1-partieConservee);
        return new RectangleHV(this.xmin+dx,this.xmax+dx,this.ymin,this.ymax);
    }
    
    public RectangleHV translationHaut(double partieConservee) {
        double dy = (this.ymax - this.ymin)*(1-partieConservee);
        return new RectangleHV(this.xmin,this.xmax,this.ymin-dy,this.ymax-dy);
    }
    
   public RectangleHV translationBas(double partieConservee) {
        double dy = (this.ymax - this.ymin)*(1-partieConservee);
        return new RectangleHV(this.xmin,this.xmax,this.ymin+dy,this.ymax+dy);
    }
    
  
    public Transform fitTransform(RectangleHV vue) {
        double minX1 = this.xmin;
        double maxX1 = this.xmax;
        double minY1 = this.ymin;
        double maxY1 = this.ymax;
        double dx1 = (maxX1 - minX1);
        double dy1 = (maxY1 - minY1);
        double cx1 = (maxX1 + minX1) / 2;
        double cy1 = (maxY1 + minY1) / 2;
        double minX2 = vue.xmin;
        double minY2 = vue.ymin;
        double maxX2 = vue.xmax;
        double maxY2 = vue.ymax;
        double dx2 = maxX2 - minX2;
        double dy2 = maxY2 - minY2;
        double cx2 = (maxX2 + minX2) / 2;
        double cy2 = (maxY2 + minY2) / 2;
        
        Transform ttrans1 = Transform.translate(-cx1, -cy1);
       
        Transform tscale = Transform.scale(1, 1);
        if (dx1 > 0 && dy1 > 0 && dx2 > 0 && dy2 > 0) {
            double scale = Math.min(dx2 / dx1, dy2 / dy1);
            tscale = Transform.scale(scale, scale);
        }
        
        Transform ttrans2 = Transform.translate(cx2, cy2);
        Transform res = ttrans2.createConcatenation(tscale).createConcatenation(ttrans1);
        return res;
    }

   
    public double getxMin() {
        return xmin;
    }

    
    public double getxMax() {
        return xmax;
    }

   
    public double getyMin() {
        return ymin;
    }

   
    public double getyMax() {
        return ymax;
    }

    
    public void setxMin(double xMin) {
        this.xmin = xmin;
    }

    
    public void setxMax(double xMax) {
        this.xmax = xmax;
    }

   
    public void setyMin(double yMin) {
        this.ymin = ymin;
    }

    
    public void setyMax(double yMax) {
        this.ymax = ymax;
    }
}
}
