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
 * This class controls the window that shows the map with the points of sale.
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

    /**
     * This method loads the html in the webview called browser, to display the
     * map.
     */
    @FXML
    private void intitializeMap() {
        final URL urlGoogleMaps = getClass().getResource("htmlResources/mapPointOfSale.html");
        browser.getEngine().load(urlGoogleMaps.toExternalForm());
    }

    /**
     *
     * This method opens a window with the purchase process.
     *
     * @param e Click on the cart.
     * @throws IOException A exception.
     */
    @FXML
    public void goToCartEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PurchaseDetail.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     * This method does not change the window.
     *
     * @param e Click made by the client in "list of products"
     * @throws IOException
     */
    @FXML
    public void goToListOfProducts(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfBuyer.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     *
     * This method opens a window with the seller profile.
     *
     * @param e Click made by the client in "Seller profile".
     * @throws IOException A exception.
     */
    @FXML
    public void sellerProfileEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfSeller.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     *
     * It shows a window with a map containing the points of sale.
     *
     * @param e Click made by the user in "Points of sale"
     * @throws IOException A exception.
     */
    @FXML
    public void pointsOfSaleEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PointsOfSaleWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     *
     * This method opens a window that allows you to register a client.
     *
     * @param e Click made by the client in "Register client".
     * @throws IOException A exception.
     */
    @FXML
    public void registerClientEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegisterClientWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

}
