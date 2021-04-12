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
}

public Treillis(Terrain Terr, ensNoeuds ensN, ensBarres ensB, catalogue cata){
this.Terr=Terr;
this.ensN=ensN;
this.ensB=ensB;
this.cata=cata;
}

}