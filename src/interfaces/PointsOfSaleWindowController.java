package interfaces;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
}
