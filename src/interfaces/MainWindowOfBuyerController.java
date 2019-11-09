/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import domain.Product;
import domain.Sale;
import static interfaces.JavaFXApplication1.myPrimaryStage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    public void imageEvent(MouseEvent e) throws IOException {
        count++;
        lblCant.setText("" + count);
        ArrayList<Product> productList = JavaFXApplication1.mySystem.getProducts();
        String elem = e.getPickResult().getIntersectedNode().getId();
        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            if (p.getName().equalsIgnoreCase(elem)) {
                newSale.addProductToCart(p);
            }
        }
    }

    @FXML
    public void chargePane() {
        int count = 0;
        ArrayList<Product> productList = JavaFXApplication1.mySystem.getProducts();
        for (int i = 0; i <= 1 && count < productList.size(); i++) {
            for (int j = 0; j <= 1 && count < productList.size(); j++) {
                Image image;
                Product p = productList.get(count);
                image = new Image("utilites/" + p.getName() + ".png");
                ObservableList<Node> list = pane.getChildren();
                ImageView im = (ImageView) list.get(count);
                im.setId(p.getName());
                im.setImage(image);
                count++;
            }
        }
    }

}
