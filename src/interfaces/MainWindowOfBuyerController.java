package interfaces;

import components.ProductController;
import domain.Product;
import static interfaces.Ecoshop.myPrimaryStage;
import static interfaces.Ecoshop.mySystem;
import static interfaces.Ecoshop.newSale;
import static interfaces.Ecoshop.pendingProduct;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */

public class MainWindowOfBuyerController implements Initializable {

    @FXML
    GridPane pane;
    
    @FXML
    Label lblCant;  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chargePane();
        String quantityOfProducstAdded = Integer.toString(newSale.getPurchasedProducts().size());
        if(newSale.getPurchasedProducts().size() != 0){
            changeStyleOfQuantityText(true);
        }
        lblCant.setText(quantityOfProducstAdded);
    }

    @FXML
    public void plusEvent(ActionEvent e) throws IOException {
        pendingProduct = new Product();
        Button btn = (Button) e.getSource();
        String element = btn.getId();
        pendingProduct = mySystem.getProductsByName(element);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProductToCart.fxml"));
        Scene newScene;
        try {
            newScene = new Scene(loader.load());
        } catch (IOException ex) {
            return;
        }        
        Stage inputStage = new Stage();
        inputStage.initStyle(StageStyle.UNDECORATED);
        inputStage.initOwner(myPrimaryStage);
        inputStage.setScene(newScene);
        inputStage.showAndWait();

        chargePane();
        if(newSale.getPurchasedProducts().size() != 0){
            changeStyleOfQuantityText(true);
        }
        lblCant.setText(" " + newSale.getPurchasedProducts().size());
    }

    @FXML
    public void goToCartEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PurchaseDetail.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    @FXML
    public void chargePane() {
        int index = 0;
        ArrayList<Product> productList = mySystem.getProducts();
            for (int j = 0; j <= 8 ; j++) {
                ObservableList<Node> list = pane.getChildren(); 
                Image image;      
                //Obtain the product component to modify
                AnchorPane productPane = (AnchorPane) list.get(index);   
                
                ObservableList<Node> listOfChildrens = productPane.getChildren(); 
                //Get each component and charge
                ImageView imageOfProduct = (ImageView )listOfChildrens.get(0);
                Label labelOfName = (Label) listOfChildrens.get(1);
                Button addToCart = (Button) listOfChildrens.get(2);
                Label labelOfPrice = (Label) listOfChildrens.get(3);
                Label labelOfQuantity = (Label) listOfChildrens.get(4);     
                
                try{
                    Product currentProduct = productList.get(index);      
                    image = new Image("resources/" + currentProduct.getName() + ".png");
                    imageOfProduct.setImage(image);  
                    imageOfProduct.setId(currentProduct.getName());
                    labelOfName.setText(currentProduct.getName());
                    labelOfPrice.setText(Integer.toString(currentProduct.getPrice()));
                    int quantityOfTimes = (int) newSale.getProduct(currentProduct).getValue();
                    labelOfQuantity.setText(Integer.toString(quantityOfTimes));
                    addToCart.setId(currentProduct.getName());
                }catch(Exception e){
                    productPane.setVisible(false);
                }
                index++;
            }
    }
    
    @FXML
    public void changeStyleOfQuantityText(boolean cartWithProducts){
        if(cartWithProducts){
            Color col = Color.rgb(255, 0, 0, 1);
            CornerRadii corn = new CornerRadii(30);
            Background background = new Background(new BackgroundFill(col, corn, Insets.EMPTY));
            lblCant.setBackground(background);
        }
    }
}
