/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dtrad01
 */
public class RectangleHV {

private double xmin ; 
private double xmax ; 
private double ymin;
private double ymax;

Public RectangleHV(double xmin , double xmax, double ymin, double ymax ) {
this.xmin=xmin ;
this.xmax=xmax;
this.ymin = ymin ;
this.ymax= ymax ;

public String toString() { 
return "RectangleHV"+"xmin"+ xmin , "xmax" +xmax , "ymin"+ymin , "ymax"+ymax ;
}

public RectangleHV scale(double facteur) { 
double dx = this.xmax - this.xmin ;
double dy = this.ymax - this.ymin ;
double cx = (this.xmax+this.xmin)/2 ; 
double cy = (this.ymax+this.ymin)/2 ;
double nxmin = cx - (dx/2) * facteur ; 

}
