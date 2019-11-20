/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author Marco Fiorito
 */
public class ProductController extends Region implements Initializable {
    @FXML
    ImageView image;
    @FXML
    Label price;
    @FXML
    Label name;
    @FXML
    JFXButton addToCart;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        price.setText("Precio");;
        name.setText("Name");
        Image auxImage = new Image("resources/almendras.png");
        image = new ImageView(auxImage);
    }    
}
