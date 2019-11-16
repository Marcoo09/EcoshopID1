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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */

public class MainWindowOfBuyerController implements Initializable {

    private Sale newSale;
    private int count;
    
    @FXML
    GridPane pane;
    
    @FXML
    Label lblCant;  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newSale = new Sale();
        count = 0;
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
                Pair pairOfProduct = newSale.getProduct(product);
                if(pairOfProduct.getKey() == product.getName()){
                    newSale.removeProductOfCart(pairOfProduct);
                    Pair newPair = new Pair(pairOfProduct.getKey(),(int)pairOfProduct.getValue() + 1);
                    newSale.addProductToCart(newPair);
                    chargePane();
                }else{
                    Pair newProduct = new Pair(product.getName(),1);
                    newSale.addProductToCart(newProduct);
                    chargePane();
                }
            }
        }
    }

    @FXML
    public void goToCartEvent(ActionEvent e) throws IOException {
        System.out.println("Se ejecuto");
        Parent root = FXMLLoader.load(getClass().getResource("PurchaseDetail.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
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
                int quantityOfTimes = (int) newSale.getProduct(currentProduct).getValue();
                labelOfQuantity.setText(Integer.toString(quantityOfTimes));
                addToCart.setId(currentProduct.getName());
                index++;
            }
        }
    }
}
