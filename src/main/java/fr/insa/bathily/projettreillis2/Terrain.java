/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author donia
 */
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Terrain {
    private double xmin;
    private double xmax;
    private double ymin; 
    private double ymax;
    private List<TriTerr> triangles;
    
    public Terrain(){
        this.xmin=-2;
        this.xmax=5;
        this.ymin=-5;
        this.ymax=2;
        this.triangles = new ArrayList<TriTerr>();
    }
    
    public Terrain (double xmin, double xmax, double ymin, double ymax){
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
        this.triangles= new ArrayList<TriTerr>();
    }
    
    public String toString(){
    String res="ZoneConstructible;"+this.getXmin()+";"+this.getXmax()+";"+this.getYmin()+";"+this.getYmax()+"\n";
    for(int i=0; i<this.getTriangles().size(); i++){
        res=res+this.getTriangles().get(i).toString()+"\n";
    }
    return res;  
    }

    public double getXmin() {
        return xmin;
    }

    public double getXmax() {
        return xmax;
    }

    public double getYmin() {
        return ymin;
    }

    public double getYmax() {
        return ymax;
    }

    public void setXmin(double xmin) {
        this.xmin = xmin;
    }

    public void setXmax(double xmax) {
        this.xmax = xmax;
    }

    public void setYmin(double ymin) {
        this.ymin = ymin;
    }

    public void setYmax(double ymax) {
        this.ymax = ymax;
    }

    public List<TriTerr> getTriangles() {
        return triangles;
    }

    public void setTriangles(List<TriTerr> triangles) {
        this.triangles = triangles;
    } 
    
    public void dessine (GraphicsContext gc){
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(0.1);
        gc.strokeLine(this.getXmin(),-1*this.getYmin(),this.getXmin(),-1*this.getYmax());
        gc.strokeLine(this.getXmin(),-1*this.getYmax(),this.getXmax(),-1*this.getYmax());
        gc.strokeLine(this.getXmax(),-1*this.getYmax(),this.getXmax(),-1*this.getYmin());
        gc.strokeLine(this.getXmax(),-1*this.getYmin(),this.getXmin(),-1*this.getYmin());
        for (int i=0; i<this.getTriangles().size(); i++){
            this.getTriangles().get(i).dessine(gc);
        }
    }
}
