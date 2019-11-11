/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import domain.Product;
import domain.Sale;
import static interfaces.Ecoshop.myPrimaryStage;
import static interfaces.Ecoshop.mySystem;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Agustin Hernandorena
 */
public class MainWindowOfBuyerController implements Initializable {

    @FXML
    GridPane pane;
    @FXML
    Label lblCant;
    private Sale newSale;
    private int count;
    private ImageView actualImage;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newSale = new Sale();
        count = 0;
        actualImage = new ImageView();
        chargePane();
    }

    @FXML
    public void plusEvent(ActionEvent e) throws IOException {
        count++;
        lblCant.setText("" + count);
        ArrayList<Product> productList = mySystem.getProducts();
        Button btn = (Button) e.getSource();
        String element = btn.getId();
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getName().equalsIgnoreCase(element)) {
                //TO DO
               // newSale.addProductToCart(product);
            }
        }
    }

    @FXML
    public void chargePane() {
        int index = 0;
        ArrayList<Product> productList = mySystem.getProducts();
        for (int i = 0; i <= 1 && index < productList.size(); i++) {
            for (int j = 0; j <= 1 && index < productList.size(); j++) {
                ObservableList<Node> list = pane.getChildren(); 
                Image image;
                AnchorPane productPane = (AnchorPane) list.get(index);                
                ObservableList<Node> listOfChildrens = productPane.getChildren(); 
                ImageView imageOfProduct = (ImageView )listOfChildrens.get(0);
                Label labelOfName = (Label) listOfChildrens.get(1);
                Button addToCart = (Button) listOfChildrens.get(2);
                Label labelOfPrice = (Label) listOfChildrens.get(3);
                Label labelOfQuantity = (Label) listOfChildrens.get(4);                
                Product currentProduct = productList.get(index);       
                
                image = new Image("resources/" + currentProduct.getName() + ".png");
                imageOfProduct.setImage(image);  
                imageOfProduct.setId(currentProduct.getName());
                labelOfName.setText(currentProduct.getName());
                labelOfPrice.setText(Integer.toString(currentProduct.getPrice()));
                labelOfQuantity.setText("0");
                addToCart.setId(currentProduct.getName());
                index++;
            }
        }
    }
}
