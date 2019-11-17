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
import domain.Sale;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javafx.util.Pair;

/**
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */

public class Ecoshop extends Application {

    public static Stage myPrimaryStage;
    public static System mySystem;
    public static Sale newSale;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        myPrimaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("HomeWindow.fxml"));
        Scene scene = new Scene(root);
        newSale = new Sale();
        myPrimaryStage.setMaximized(true);
        myPrimaryStage.setWidth(screenSize.getWidth());
        myPrimaryStage.setHeight(screenSize.getHeight());
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    public static void main(String[] args) {
        mySystem = new System();
        Client c1 = new Client("Luis", "Perez", "58902346", "091234567", 1);
        Client c2 = new Client("Raul", "Diaz", "13456079", "099771234", 2);
        Client c3 = new Client("Nicolas", "Gomez", "34456788", "095458711", 3);
        Product product1 = new Product("Uruguay", true, true, 150, "No aplica", 1, "almendras");
        Product product2 = new Product("Uruguay", false, true, 190, "No aplica", 2, "almendrasacarameladas");
        Product product3 = new Product("Uruguay", false, true, 200, "No aplica", 4, "almendrasconchocolate");
        Product product4 = new Product("Uruguay", true, true, 120, "No aplica", 3, "ajogranulado");
        PointOfSale store = new PointOfSale("Ejido 1423, Montevideo", "La Molienda", "Incursionamos en el  área de elaboración de alimentos, un menú diario vegetariano y saludable,  postres, veganos y sin azúcar");
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
        Sale s1 = new Sale();
        Sale s2 = new Sale();
        s1.addProductToCart(new Pair(product1, 1));
        s1.addProductToCart(new Pair(product2, 2));
        s1.addUsedPackage(p1);
        s1.setShopPlace(store);
        s1.setTicketNumber("1");
        s1.setTotalPrice(s1.obtainPrice());
        LocalDate date1 = LocalDate.of(2019, 1, 25);
        s1.setPurchaseDate(date1);
        mySystem.addSale(s1);
        s2.addProductToCart(new Pair(product1, 5));
        s2.addProductToCart(new Pair(product2, 3));
        s2.addUsedPackage(p3);
        s2.setShopPlace(store);
        s2.setTicketNumber("2");
        s2.setTotalPrice(s2.obtainPrice());
        s2.setClient(c3);
        s2.setPurchaseDate(LocalDate.of(2019, 2, 15));
        mySystem.addSale(s2);
        mySystem.addPreSale(s2);
        launch(args);
    }

}
