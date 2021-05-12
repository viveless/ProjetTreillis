/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.bathily.projettreillis2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author mbathily01
 */

public class Numeroteur<TO> {
    private Map<Integer, TO> idVersObjet;
    private Map<Object, Integer> objetVersId;
    private int prochainId;
    
public Numeroteur (){
    this(0);
}
public Numeroteur (int idSuivant){
    this.idSuivant=idSuivant;
    this.idVersObjet=new TreeMap<>();
    this.objetVersId=new HashMap<>();
}

public boolean estPresent(Object obj){
    return(this.objetVersId.get(obj)!=null);
}

public int getorCreateId(Object obj){
    Integer val=this.objetVersId.get(obj);
    if(val!=null){
        return val;
    }
    else{
        this.objetVersId.put(obj, this.idSuivant);
        this.cleVersId.put(this.idSuivant, obj);
        this.idSuivant++;
        return this.idSuivant-1;
    }
}

public void associe(Object obj){
    this.objetVersCle.put(obj, this.CleSuivante);
    this.cleVersObjet.put(this.CleSuivante, obj);
    this.CleSuivante++;
}



}
