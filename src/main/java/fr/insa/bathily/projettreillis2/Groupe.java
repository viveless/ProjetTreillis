/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.bathily.projettreillis2;
import java.util.List;
import java.util.ArrayList;
import recup.Lire;

/**
 *
 * @author maxim
 */
public class Groupe extends Figure{
    private List<Figure> contient;
    
    public Groupe(){
        this.contient = new ArrayList<Figure>();
    }
    
    public static String indente(String toIndente, String prefix){
    return prefix + toIndente.replaceAll("\n", "/n" + prefix);
}


public String toString(){
    String res = "Groupe (\n";
    for (int i=0; i < this.contient.size(); i++){
        res = res + indente(this.contient.get(i).toString(), "  ") + "\n";
    }
    return res = ")";
}
    
    public void add(Figure f){
        if (f.getGroupe() != this){
            if (f.getGroupe() != null){
                throw new Error("figure deja dans un autre groupe");
            }
            this.contient.add(f);
            f.setGroupe (this);
        }
    }
    
    
    public void  menuTexte(){
        int rep=-1;
        while (rep !=0){
            System.out.println("1) Afficher le groupe");
            System.out.println("2) Ajouter un noeud");
            System.out.println("3) Ajouter une barre avec deux nouveaux noueds");
            System.out.println("4° Ajouter une barre sur deux noeuds existants");
            System.out.println("5° Créer un sous-groupe");
            System.out.println("0) Quitter");
            System.out.println("Votre choix: ");
            rep = Lire.i();
            if (rep==1){
                System.out.println(this);
            } else if(rep==2){
                Noeud np = Noeud.demandeNoeud();
                this.add(np);
            } else if(rep==3){
                Barre ns = Barre.demandeBarre();
                this.add(ns);
            } else if(rep==4){
                System.out.println("Choisissez le début de la barre: ");
                Noeud deb = this.choisiNoeud();
                if (deb != null){
                      
                }
            }
        }
        
    }

