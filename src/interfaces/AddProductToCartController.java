package interfaces;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marco Fiorito
 */
public class AddProductToCartController implements Initializable {
    
    @FXML
    ImageView mainImage;
    
    @FXML
    ImageView firstAuxImage;
        
    @FXML
    VBox secondAuxImage;
            
    @FXML
    VBox thirdAuxImage;
    
    @FXML
    Label nameOfProduct;
    
    @FXML
    Label price;
    
    @FXML
    Label description;
    
    @FXML
    JFXButton decrementButton;
    
    @FXML
    JFXButton incrementButton;
    
    @FXML
    JFXButton confirmAddToCartButton;
    
    @FXML 
    HBox packagesContainer;
    @FXML
    private JFXButton closeButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void close(MouseEvent event){
        Button btn = (Button) event.getSource();
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }
}
