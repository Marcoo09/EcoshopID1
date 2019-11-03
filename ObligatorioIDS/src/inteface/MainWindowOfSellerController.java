/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteface;

import domain.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Agustin Hernandorena
 */
public class MainWindowOfSellerController implements Initializable {
    private TextField name;
    private TextField countryOfOrigin;
    private TextField price;
    private TextField material;
    private CheckBox organic;
    private boolean isOrganic;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void registerPurchsae(ActionEvent e){
        String nameOfProduct = name.getText();
        String originCountry = countryOfOrigin.getText();
        double precio = Integer.parseInt(price.getText());
        if(organic.isSelected()){
            isOrganic=true;
        }
        Product productToAdd = new Product(nameOfProduct, isOrganic, isOrganic, 0, nameOfProduct, 0);
        
        
    }
}
