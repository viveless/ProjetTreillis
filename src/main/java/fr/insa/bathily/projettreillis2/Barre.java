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


public class Barre extends Figure{
private int id ; 
private Noeud debut ;
private Noeud fin ; 
private TypeBarre type ; 


public Barre (){
this.debut=debut;
this.fin=fin; 
this.id = id ;
this.type = type ; 
}


public Noeud getDebut(){
    return debut;
}
       

public Noeud getFin(){
    return fin;
}
        
        
public double maxX(){
    return Math.max(this.debut.maxX(), this.fin.maxX());
}


public String toString(){
    return "[" + this.debut + "," + this.fin + "]";
}

public static Barre demandeBarre(){
    System.out.println("noeud debut : ");
    Noeud debut = Noeud.demandeNoeud();
    System.out.println("noeud fin : ");
    Noeud fin = Noeud.demandeNoeud();
    return new Barre(deb, fin);
}

public class TypeBarre {
private int id ; 
private int cout ; 
private int longmax ;
private int longmin ; 
private int resmaxtension ;
private int resmaxcompression ; 


public TypeBarre (int id , int cout, int longmax , int longmin , int resmaxtension , int resmaxcompression){
this.id=id;
this.cout=cout; 
this.longmin = longmin ; 
this.longmax = longmax ;
this.resmaxtension = resmaxtension ; 
this.resmaxcompression = resmaxcompression ;
}


}
}
}