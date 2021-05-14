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
public class Treillis {
    private Terrain Terr;
    private ensNoeuds ensN;
    private ensBarres ensB;
    private catalogue cata;
    public double xMax;
    public double xMin;
    public double yMax;
    public double yMin;


/*public Treillis(Terrain Terr, ensNoeuds ensN, ensBarres ensB, catalogue cata){
*this.Terr=Terr;
*this.ensN=ensN;
*this.ensB=ensB;
*this.cata=cata;
*/
// constructeur 
public Treillis (double xMax, double xMin, double yMax, double yMin){
    this.xMax = xMax;
    this.xMin= xMin;
    this.yMax= yMax;
    this.yMin= yMin;
}
// valeurs par défaut
public Treillis(){
    this(5000,0,5000,0)
}
// constructeurs

 public double getXMax() {
        return xMax;
    }

    public void setXMax(double xMax) {
        this.xMax = xMax;
    }

    public double getXMin() {
        return xMin;
    }

    public void setXMin(double xMin) {
        this.xMin = xMin;
    }

    public double getYMax() {
        return yMax;
    }

    public void setYMax(double yMax) {
        this.yMax = yMax;
    }

    public double getYMin() {
        return yMin;
    }

    public void setYMin(double Ymin) {
        this.yMin = yMin;
}
// obtenir la zone constructible
public void demandeZone(){
        System.out.println("entrez Xmin");
        this.setXmin(Lire.d());
        System.out.println("entrez Xmax");
        this.setXmax(Lire.d());
        System.out.println("entrez Ymin");
        this.setYmin(Lire.d());
        System.out.println("entrez Xmax");
        this.setYmax(Lire.d());
    }
// test
/* public static Treillis treillisTest(){
        Treillis res = new Treillis();
        double [][] PT1 ={{100,50},{50,100},{50,50}};
        TriangleTerrain TT1= new TriangleTerrain(res.numTT, PT1, Color.GREEN);
        res.TT.add(TT1);
        double [][] PT2 ={{10,20},{10,10},{20,10}};
        TriangleTerrain TT2= new TriangleTerrain(res.numTT, PT2, Color.GREEN);
        res.TT.add(TT2);
        return res;
    }
*/
// methode pour savoir si le noeud est dans le terrain
public boolean noeudDansZone(double x, double y){
        if(x>this.getXMax() || x<this.getXMin() || y>this.getYMax() || y<this.getYMin()){
            return false;
        }else{
            return true;
        }
}
public double[] demandeNoeud(){
        System.out.println("abscisse : ");
        double x= Lire.d();
        System.out.println("ordonnée : ");
        double y= Lire.d();
        if(this.noeudDansZone(x, y)==false){
            return null;
        }
        double[] p = {x, y};
        return p;
    }
// todo : menu text avec les différentes possibilités( des if ou des switch)

}
