/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

/**
 *
 * @author Agustin Hernandorena
 */
public class PointsOfSaleWindowController implements Initializable {
    
    @FXML
    private WebView browser;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       final URL urlGoogleMaps = getClass().getResource("map.html");
       browser.getEngine().load(urlGoogleMaps.toExternalForm()); 
    }
    
}
