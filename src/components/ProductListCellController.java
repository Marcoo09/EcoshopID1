/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class ProductListCellController implements Initializable {
    
    private Pair product;
    
    @FXML
    private ImageView image;
    @FXML
    private Label productName;
    @FXML
    private Label price;
    @FXML
    private Label quantity;
    @FXML
    private Label less;
    @FXML
    private Label plus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        image = new ImageView();
        productName = new Label();
        quantity = new Label();
        price = new Label();
        image.setImage(new Image("resources/" + product.getKey() + ".png"));
        productName.setText(product.getKey().toString());
        quantity.setText(product.getValue().toString());
    }
    
    public ProductListCellController(Pair product){
        System.out.println("me ejecutee");
        product = product;
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProductListCell.fxml"));
//        try {
//            fxmlLoader.load();
//        } catch (IOException exception) {
//            throw new RuntimeException(exception);
//        }
    }
    
}
