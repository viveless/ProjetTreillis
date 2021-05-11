/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author donia
 */
public class Segment {
    
}
public class Segment extends FigureSimple {

    private Point debut;
    private Point fin;

    private Segment() {
        this(null, null);
    }

    public Segment(Point debut, Point fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public Segment(Point debut, Point fin) {
        this(debut, fin);
    }

    public Point getDebut() {
        return debut;
    }

    public Point getFin() {
        return fin;
    }

    
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

    @Override
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
        context.setStroke(this.getCouleur());
        context.strokeLine(this.debut.getPx(), this.debut.getPy(), this.fin.getPx(), this.fin.getPy());
    }

   
    public void dessineSelection(GraphicsContext context) {
        context.setStroke(Figure.COULEUR_SELECTION);
        context.strokeLine(this.debut.getPx(), this.debut.getPy(), this.fin.getPx(), this.fin.getPy());
    }

    public void save(Writer w, Numeroteur<Figure> num) throws IOException {
        if (!num.objExist(this)) {
            int id = num.creeID(this);
            this.debut.save(w, num);
            this.fin.save(w, num);
            w.append("Segment" + id +
                    num.getID(this.debut) + ";" + num.getID(this.fin) +
                    ";" + FigureSimple.saveColor(this.getCouleur())+"\n");
        }
    }

}