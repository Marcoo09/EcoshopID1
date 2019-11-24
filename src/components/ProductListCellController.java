package components;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author Marco Fiorito
 */
public class ProductListCellController implements Initializable {

    private Pair product;

    @FXML
    private ImageView image;
    @FXML
    private Label productName;
    @FXML
    private Label price;
    @FXML
    private Label quantity;
    @FXML
    private Label less;
    @FXML
    private Label plus;

    public ProductListCellController(Pair product) {
        product = product;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        image = new ImageView();
        productName = new Label();
        quantity = new Label();
        price = new Label();
        image.setImage(new Image("resources/" + product.getKey() + ".png"));
        productName.setText(product.getKey().toString());
        quantity.setText(product.getValue().toString());
    }

}
