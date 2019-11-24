package components;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author Marco Fiorito
 */
public class ProductController extends Region implements Initializable {
    @FXML
    ImageView image;
    @FXML
    Label price;
    @FXML
    Label name;
    @FXML
    JFXButton addToCart;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        price.setText("Precio");;
        name.setText("Name");
        Image auxImage = new Image("resources/almendras.png");
        image = new ImageView(auxImage);
    }    
}
