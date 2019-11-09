/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import domain.Product;
import domain.Sale;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Agustin Hernandorena
 */
public class SaleWindowController implements Initializable {
    @FXML
    private Label lblName;
    @FXML
    private ImageView productImage;
    @FXML
    private Label lblPrice;
    
    private MainWindowOfBuyerController windowOfBuyer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public SaleWindowController(Label lblName, ImageView productImage, Label lblPrice, MainWindowOfBuyerController windowOfBuyer) {
        this.lblName = lblName;
        this.productImage = productImage;
        this.lblPrice = lblPrice;
        this.windowOfBuyer = windowOfBuyer;
    }
    
    
    
    
    
}
