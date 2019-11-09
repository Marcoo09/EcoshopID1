package inteface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import interfaces.MainWindowOfSellerController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import domain.System;
/**
 *
 * @author Agustin Hernandorena
 */
public class ObligatorioIDS extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        System mySystem = new System();
        MainWindowOfSellerController m = new MainWindowOfSellerController(mySystem);
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfSeller.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main (String [] args){
        launch(args);
    }

}
