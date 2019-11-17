package interfaces;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;
import components.ProductListCellController;
import static interfaces.Ecoshop.myPrimaryStage;
import static interfaces.Ecoshop.newSale;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author Marco Fiorito
 */
public class PurchaseDetailController implements Initializable {
    
    private Integer currentTab;
    
    @FXML
    JFXTabPane tabPane;
    
    @FXML
    JFXListView listOfProducts;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentTab = 0;
        initializeTabs();
        initializeListView();
    }
    
    @FXML
    private void initializeTabs(){
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }
    
    @FXML
    private void initializeListView() {
        ArrayList<Pair> purchasedProducts = newSale.getPurchasedProducts();
        purchasedProducts.forEach((product) -> {
            try{
                System.out.println("Entre");
                Label lbl = new Label("" +product.getValue());
                lbl.setGraphic(new ImageView(new Image("resources/" + product.getKey() + ".png")));
//                ProductListCellController productListCell = new ProductListCellController(product);
//                System.out.println("hasta aca lleguee");
//                listOfProducts.getItems().add(productListCell);
                  listOfProducts.getItems().add(lbl);
            }catch(Exception e){
                System.out.println("An error occurs in charge the list");
            }
        });
    }
        
    @FXML
    public void nextTabEvent(MouseEvent e) throws IOException{
        
        tabPane.getTabs().get(currentTab).setDisable(true);
        currentTab++;
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }
      
    @FXML
    public void previousTabEvent(MouseEvent e) throws IOException{
        tabPane.getTabs().get(currentTab).setDisable(true);
        currentTab--;
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }
    
    public void goToHome(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfBuyer.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
 
}
