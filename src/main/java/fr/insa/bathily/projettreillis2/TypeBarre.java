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
public class TypeBarre {

        private int id;
        private int cout;
        private int longmax;
        private int longmin;
        private int resmaxtension;
        private int resmaxcompression;
        
        private TypeBarre() {
            
        }

        public TypeBarre(int id, int cout, int longmax, int longmin, int resmaxtension, int resmaxcompression) {
            this.id = id;
            this.cout = cout;
            this.longmin = longmin;
            this.longmax = longmax;
            this.resmaxtension = resmaxtension;
            this.resmaxcompression = resmaxcompression;
        }

        public static TypeBarre typeBois() {
        TypeBarre res = new TypeBarre() ;
            res.id = 1;
            res.cout = 50;
            res.longmin = 0;
            res.longmax = 1000;
            res.resmaxtension = 50;
            res.resmaxcompression = 50;
            return res;
        }
        
        public static TypeBarre typeFer() {
        TypeBarre res = new TypeBarre() ;
            res.id = 2;
            res.cout = 80;
            res.longmin = 0;
            res.longmax = 1000;
            res.resmaxtension = 150;
            res.resmaxcompression = 150;
            return res;
        }
}