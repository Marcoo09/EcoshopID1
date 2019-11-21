package interfaces;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import domain.Client;
import domain.PointOfSale;
import domain.Product;
import domain.Sale;
import static interfaces.Ecoshop.myPrimaryStage;
import static interfaces.Ecoshop.mySystem;
import static interfaces.Ecoshop.newSale;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
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

    @FXML
    JFXTextField firstName;

    @FXML
    JFXTextField lastName;

    @FXML
    JFXTextField phoneNumber;

    @FXML
    JFXTextField identifyCard;

    @FXML
    JFXTextField clientNumber;

    @FXML
    JFXCheckBox isPreSale;

    @FXML
    JFXDatePicker date;

    @FXML
    Label confirmationText;

    @FXML
    private WebView browser;

    @FXML
    private JFXListView availablePointsOfSale;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentTab = 0;
        initializeTabs();
        initializeListView();
        intitializeMap();
        initializeListViewOfPointOfSales();
    }

    @FXML
    private void intitializeMap(){
        final URL urlGoogleMaps = getClass().getResource("htmlResources/mapBuyFlow.html");
        browser.getEngine().load(urlGoogleMaps.toExternalForm());
    }
    
    private void initializeListViewOfPointOfSales(){
        availablePointsOfSale.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        ArrayList<PointOfSale> points = mySystem.getSalePoints();
        for (int i = 0; i < points.size(); i++) {
            availablePointsOfSale.getItems().add(points.get(i));
        }
    }
    
    @FXML
    private void initializeTabs() {
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }

    @FXML
    private void initializeListView() {
        ArrayList<Pair> purchasedProducts = newSale.getPurchasedProducts();
        purchasedProducts.forEach((product) -> {
            try {
                Product aProduct = (Product) product.getKey();
                Label lbl = new Label("" + (int) product.getValue());
                lbl.setGraphic(new ImageView(new Image("resources/" + aProduct.getName() + ".png")));
                listOfProducts.getItems().add(lbl);
            } catch (Exception e) {
                System.out.println("An error occurs in charge the list");
            }
        });
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
    
    @FXML
    public void nextOfPointOfSaleTabEvent(MouseEvent e) throws IOException {
        PointOfSale pointSelected = (PointOfSale)availablePointsOfSale.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error de local seleccionado");
        if (pointSelected != null) {
            newSale.setShopPlace(pointSelected);
            nextTabLogic();
        } else {
            alert.setContentText("Debe seleccionar un punto de venta");
            alert.showAndWait();
        }
    }
    
    @FXML
    public void nextOfDateTabEvent(MouseEvent e) throws IOException {
        LocalDate dateSelected = date.getValue();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error de fecha");
        if (dateSelected != null) {
            LocalDate today = now();
            if (dateSelected.isBefore(today)) {
                alert.setContentText("Debe ingresar una fecha posterior al dia de hoy.");
                alert.showAndWait();
            } else {
                newSale.setPurchaseDate(dateSelected);
                nextTabLogic();
            }
        } else {
            alert.setContentText("Debe seleccionar una fecha.");
            alert.showAndWait();
        }
    }

    @FXML
    public void nextOfMoreInfoTabEvent(MouseEvent e) throws IOException {
        if (enterAllFields()) {
            Client client = new Client(firstName.getText(), lastName.getText(), identifyCard.getText(), phoneNumber.getText(), clientNumber.getText());
            boolean isPreSaleValue = isPreSale.isSelected();
            newSale.setClient(client);
            newSale.setIsPreSale(isPreSaleValue);
            tabPane.getTabs().get(currentTab).setDisable(true);
            currentTab++;
            if (!isPreSaleValue) {
                currentTab++;
            }
            tabPane.getTabs().get(currentTab).setDisable(false);
            tabPane.getSelectionModel().select(currentTab);
        }
    }

    @FXML
    public boolean enterAllFields() {
        boolean enterAllFields = false;
        String name = "";
        String surname = "";
        String telephoneNumber = "";
        String identificationDocument = "";
        String clientId = "";
        name = firstName.getText();
        surname = lastName.getText();
        telephoneNumber = phoneNumber.getText();
        identificationDocument = identifyCard.getText();
        clientId = clientNumber.getText();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Campo sin completar.");
        if (name.equals("")) {
            alert.setContentText("Debe ingresar un nombre.");
            alert.showAndWait();
        } else if (surname.equals("")) {
            alert.setContentText("Debe ingresar un apellido.");
            alert.showAndWait();
        } else if (telephoneNumber.equals("")) {
            alert.setContentText("Debe ingresar un numero de telefono.");
            alert.showAndWait();
        } else if (identificationDocument.equals("")) {
            alert.setContentText("Debe ingresar su cedula de identidad.");
            alert.showAndWait();
        } else if (clientId.equals("")) {
            alert.setContentText("Debe ingresar su numero de cliente.");
            alert.showAndWait();
        } else {
            enterAllFields = true;
        }
        return enterAllFields;
    }

    @FXML
    public void nextTabEvent(MouseEvent e) throws IOException {
        nextTabLogic();
    }

    @FXML
    public void previousTabEvent(MouseEvent e) throws IOException {
        previousTabLogic();
    }

    @FXML
    public void confirmTabEvent(MouseEvent e) throws IOException {
        newSale.setTotalPrice(newSale.obtainPrice());
        mySystem.addSale(newSale);
        newSale = new Sale();

        nextTabLogic();
    }

    @FXML
    public void previousOfPointsOfSaleTabEvent(MouseEvent e) throws IOException {
        tabPane.getTabs().get(currentTab).setDisable(true);
        currentTab--;
        if (!newSale.isIsPreSale()) {
            currentTab--;
        }
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }

    public void goToHome(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfBuyer.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    public void nextTabLogic() {
        tabPane.getTabs().get(currentTab).setDisable(true);
        currentTab++;
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }

    public void previousTabLogic() {
        tabPane.getTabs().get(currentTab).setDisable(true);
        currentTab--;
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }

}
