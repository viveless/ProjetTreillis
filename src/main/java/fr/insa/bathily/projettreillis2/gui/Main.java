/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.bathily.projettreillis2;
// il faut import des dossiers je suppose ( todo)
/**
 *
 * @author mbathily01
 */
public class Main extends Application {

    @Override
    public void start (Stage stage ){
        Scene sc = new Scene(new MainPane(stage,Groupe.groupetest(),800,600));
        stage.setScene(sc);
        stage.setTitle("Nouveau");
            stage.show();
}

    public static void main(STring[] args){
        launch();
}


}
