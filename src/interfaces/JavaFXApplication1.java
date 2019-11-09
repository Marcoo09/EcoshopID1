/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import domain.Client;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import domain.System;
import domain.Package;
import domain.Product;
import domain.PointOfSale;

/**
 *
 * @author Agustin Hernandorena
 */
public class JavaFXApplication1 extends Application {

    public static Stage myPrimaryStage;
    public static System mySystem;

    @Override
    public void start(Stage primaryStage) throws IOException {
        myPrimaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("MenuWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    public static void main(String[] args) {
        mySystem = new System();
        Client c1 = new Client("Luis", "Perez", "58902346", "091234567", 1);
        Client c2 = new Client("Raul", "Diaz", "13456079", "099771234", 2);
        Client c3 = new Client("Nicolas", "Gomez", "34456788", "095458711", 3);
        Product product1 = new Product("Uruguay", true, true, 150, "No aplica", 1, "almendras");
        Product product2 = new Product("Uruguay", true, true, 190, "No aplica", 2, "almendrasacarameladas");
        Product product3 = new Product("Uruguay", true, true, 200, "No aplica", 4, "almendrasconchocolate");
        Product product4 = new Product("Uruguay", true, true, 120, "No aplica", 3, "ajogranulado");
        Package p1 = new Package("Tupper hermetico", "Plastico", 1800);
        Package p2 = new Package("Bolsa Ziploc 4cm x 6cm", "Plastico", 70);
        Package p3 = new Package("Bollon", "Vidrio", 100);
        mySystem.addPackage(p1);
        mySystem.addPackage(p2);
        mySystem.addPackage(p3);
        mySystem.addClient(c1);
        mySystem.addClient(c2);
        mySystem.addClient(c3);
        mySystem.addProduct(product1);
        mySystem.addProduct(product2);
        mySystem.addProduct(product3);
        mySystem.addProduct(product4);
        launch(args);
    }

}
