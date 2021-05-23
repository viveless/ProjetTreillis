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
 * @param <TO>
 */

public class Numeroteur<TO> {
    private TreeMap<Integer, TO> numVersObjet;
    private Map<TO, Integer> objetVersNum;
    
    private int numSuivant;
    
    
public Numeroteur (){
    this(0);
}


public Numeroteur (int idSuivant){
    this.numSuivant = idSuivant;
    this.numVersObjet = new TreeMap<>();
    this.objetVersNum = new HashMap<>();
}

    /**
     *
     * @param obj
     * @return
     */
    public int creeNum(TO obj){
    if(this.objetVersNum.containsKey(obj)){
        throw new Error("objet" + obj + "deja dans le numeroteur");
    }
    this.numVersObjet.put(numSuivant, obj);
    this.objetVersNum.put(obj, numSuivant);
    this.numSuivant++;
    return this.numSuivant - 1;
}


public boolean estPresent(TO obj){
    return(this.objetVersNum.get(obj)!=null);
}


public boolean objExist(TO obj){
    return this.objetVersNum.containsKey(obj);
}


public int getOrCreateNum(TO obj){
    if(this.objExist(obj)){
        return this.objetVersNum.get(obj);
    }else{
        return this.creeNum(obj);
        
    }
}


public void associe(TO obj){
    this.objetVersNum.put(obj, this.numSuivant);
    this.numVersObjet.put(this.numSuivant, obj);
    this.numSuivant++;
}



}

