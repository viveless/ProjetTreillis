/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.bathily.projettreillis2;

import java.io.InputStream;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author mbathily01
 */
public class BoutonIcone extends Button{
    public BoutonIcone(String realPathOfImageFile, double sizeX, double sizeY) {
    InputStream is = this.getClass().getResourceAsStream(realPathOfImageFile);
if (is == null) {
            this.setText("?? " + realPathOfImageFile);
        } else {
            Image img = new Image(is, sizeX, sizeY, false, true);
            this.setGraphic(new ImageView(img));
        }
}
}
