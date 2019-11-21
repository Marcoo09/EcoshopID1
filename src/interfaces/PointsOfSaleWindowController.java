package interfaces;

import static interfaces.Ecoshop.myPrimaryStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;

/**
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public class PointsOfSaleWindowController implements Initializable {
    
    @FXML
    private WebView browser;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        intitializeMap();
    }
    
    @FXML
    private void intitializeMap(){
       final URL urlGoogleMaps = getClass().getResource("htmlResources/mapPointOfSale.html");
       browser.getEngine().load(urlGoogleMaps.toExternalForm()); 
    }
    
    @FXML
    public void goToCartEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PurchaseDetail.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    @FXML
    public void sellerProfileEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfSeller.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
    @FXML
    public void pointsOfSaleEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PointsOfSaleWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
    @FXML
    public void registerClientEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegisterClientWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
}
