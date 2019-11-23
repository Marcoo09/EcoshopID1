package interfaces;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import domain.Product;
import static interfaces.Ecoshop.mySystem;
import static interfaces.Ecoshop.newSale;
import static interfaces.Ecoshop.pendingProduct;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

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
    ImageView secondAuxImage;

    @FXML
    ImageView thirdAuxImage;

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
    JFXComboBox<Label> packagesContainer;

    @FXML
    TextField quantity;

    private int quantityOfProductsToBuy;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeDetail();
    }

    @FXML
    private void initializeDetail() {
        Image image = new Image("resources/" + pendingProduct.getName() + ".png");
        Image secondImage = new Image("resources/" + pendingProduct.getName() + "2.png");
        Image thirdImage = new Image("resources/" + pendingProduct.getName() + "3.png"); 
        mainImage.setImage(image);
        firstAuxImage.setImage(image);
        secondAuxImage.setImage(secondImage);
        thirdAuxImage.setImage(thirdImage);
        nameOfProduct.setText(pendingProduct.getName());
        price.setText("$ " + pendingProduct.getPrice());
        description.setText(pendingProduct.toString());
        quantity.setText(Integer.toString(quantityOfProductsToBuy));
        confirmAddToCartButton.setId(pendingProduct.getName());

        ArrayList<domain.Package> packagesAvailable = pendingProduct.getListOfAvailablePackages();

        for (int i = 0; i < packagesAvailable.size(); i++) {
            domain.Package currentPackage = packagesAvailable.get(i);
            Label labelToAdd = new Label();
            labelToAdd.setText(currentPackage.getName());
            packagesContainer.getItems().add(labelToAdd);
        }
    }

    @FXML
    private void firstImageEvent(MouseEvent event) {
        Image image = new Image("resources/" + pendingProduct.getName() + ".png");
        mainImage.setImage(image);
    }

    @FXML
    private void secondImageEvent(MouseEvent event) {
        Image image = new Image("resources/" + pendingProduct.getName() + "2.png");
        mainImage.setImage(image);
    }
    
    @FXML
    private void thirdImageEvent(MouseEvent event) {
        Image image = new Image("resources/" + pendingProduct.getName() + "3.png");
        mainImage.setImage(image);
    }
    
    

    @FXML
    private void close(MouseEvent event) {
        Button btn = (Button) event.getSource();
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void increment(MouseEvent event) {
        quantityOfProductsToBuy++;
        quantity.setText(Integer.toString(quantityOfProductsToBuy));
    }

    @FXML
    private void decrement(MouseEvent event) {
        if (quantityOfProductsToBuy >= 1) {
            quantityOfProductsToBuy--;
            quantity.setText(Integer.toString(quantityOfProductsToBuy));
        }
    }

    @FXML
    private void confirmEvent(MouseEvent e) throws IOException {
        ArrayList<Product> productList = mySystem.getProducts();
        Button btn = (Button) e.getSource();
        String element = btn.getId();
        String packageUsed;
        try {
            packageUsed = packagesContainer.getSelectionModel().getSelectedItem().getText();
        } catch (Exception error) {
            packageUsed = "default";
        }

        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getName().equalsIgnoreCase(element)) {
                if (quantityOfProductsToBuy > 0) {
                    if (newSale.pertain(product)) {
                        Pair aPair = newSale.getProduct(product);
                        Product aProduct = (Product) aPair.getKey();
                        newSale.removeProductOfCart(aPair);
                        Pair newPair = new Pair(aProduct, (int) aPair.getValue() + quantityOfProductsToBuy);
                        newSale.addProductToCart(newPair);
                    } else {
                        Pair newProduct = new Pair(product, quantityOfProductsToBuy);
                        newSale.addProductToCart(newProduct);
                    }
                    if (packageUsed != "default") {
                        domain.Package pack = mySystem.getPackageByName(packageUsed);
                        if (pack != null) {
                            newSale.addUsedPackage(pack);
                        }
                    } else {
                        //We asume that he/she select the first
                        domain.Package pack = mySystem.getPackagesList().get(0);
                        if (pack != null && !newSale.getPackagesUsed().contains(pack)) {
                            newSale.addUsedPackage(pack);
                        }
                    }
                }
            }
        }
        pendingProduct = null;
        close(e);
    }
}
