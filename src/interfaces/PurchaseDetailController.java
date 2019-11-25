package interfaces;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import javafx.util.Pair;

/**
 *
 * This class controls the window in which the process of buying a product
 * occurs.
 *
 * @author Agustín Hernandorena and Marco Fiorito
 */
public class PurchaseDetailController implements Initializable {

    private Integer currentTab;

    @FXML
    JFXTabPane tabPane;

    @FXML
    private JFXTreeTableView<PurchasedProductInfo> tableDetail;

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
    JFXTextField firstNameResume;

    @FXML
    JFXTextField lastNameResume;

    @FXML
    JFXTextField phoneNumberResume;

    @FXML
    JFXTextField identifyCardResume;

    @FXML
    JFXTextField clientNumberResume;

    @FXML
    JFXCheckBox isPreSaleResume;

    @FXML
    JFXDatePicker date;

    @FXML
    JFXDatePicker dateResume;

    @FXML
    Label confirmationText;

    @FXML
    private WebView browser;

    @FXML
    private JFXListView availablePointsOfSale;

    @FXML
    private JFXTreeTableView<PurchasedProductInfo> table;

    @FXML
    private Label lblName;

    @FXML
    private Label lblQuantity;

    @FXML
    private TitledPane datePane;

    @FXML
    private JFXTextArea txtAreaPintOfSale;

    @FXML
    private Text txtTotal;

    @FXML
    private ImageView arrowBack;

    @FXML
    private ImageView arrowNext;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentTab = 0;
        initializeTabs();
        initializeMoreInformation();
        intitializeMap();
        initializeListViewOfPointOfSales();
        initializeResume();
        if (mySystem.isIsInPreSaleMode()) {
            tabPane.getTabs().get(currentTab).setDisable(true);
            if (!"".equals(mySystem.getClient().getFirstName())) {
                currentTab = 2;
            } else {
                currentTab = 1;
            }
            isPreSale.setSelected(true);
            arrowBack.setVisible(true);
            tabPane.getTabs().get(currentTab).setDisable(false);
            tabPane.getSelectionModel().select(currentTab);
        }
    }

    /**
     * Method that shows a summary of the purchase.
     */
    @FXML
    private void initializeResume() {
        initializeDetail();
        txtTotal.setText("$" + newSale.getFullPayment());
    }

    /**
     *
     * Method that loads a list with each product purchased, quantity, price and
     * total price.
     */
    @FXML
    private void initializeDetail() {
        JFXTreeTableColumn<PurchasedProductInfo, String> nameCol = new JFXTreeTableColumn<>("Nombre");
        nameCol.setPrefWidth(250);
        JFXTreeTableColumn<PurchasedProductInfo, String> quantityCol = new JFXTreeTableColumn<>("Cantidad");
        quantityCol.setPrefWidth(250);
        JFXTreeTableColumn<PurchasedProductInfo, String> priceUnitCol = new JFXTreeTableColumn<>("Precio");
        priceUnitCol.setPrefWidth(250);
        JFXTreeTableColumn<PurchasedProductInfo, String> priceAllCol = new JFXTreeTableColumn<>("Precio Total");
        priceAllCol.setPrefWidth(250);

        nameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PurchasedProductInfo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PurchasedProductInfo, String> param) {
                return param.getValue().getValue().productName;
            }
        });

        quantityCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PurchasedProductInfo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PurchasedProductInfo, String> param) {
                return param.getValue().getValue().quantitySold;
            }
        });

        priceUnitCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PurchasedProductInfo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PurchasedProductInfo, String> param) {
                return param.getValue().getValue().priceUnit;
            }
        });

        priceAllCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PurchasedProductInfo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PurchasedProductInfo, String> param) {
                return param.getValue().getValue().incomeGenerated;
            }
        });

        ObservableList<PurchasedProductInfo> products = FXCollections.observableArrayList();
        ArrayList<Pair> purchasedProducts = newSale.getPurchasedProducts();

        for (int i = 0; i < purchasedProducts.size(); i++) {
            Pair productPair = purchasedProducts.get(i);
            Product value = (Product) productPair.getKey();
            int quantity = (int) productPair.getValue();
            products.add(new PurchasedProductInfo(value, quantity));
        }
        final TreeItem<PurchasedProductInfo> root = new RecursiveTreeItem<PurchasedProductInfo>(products, RecursiveTreeObject::getChildren);
        table.getColumns().setAll(nameCol, quantityCol, priceUnitCol, priceAllCol);
        table.setRoot(root);
        table.setShowRoot(false);
        tableDetail.getColumns().setAll(nameCol, quantityCol, priceUnitCol, priceAllCol);
        tableDetail.setRoot(root);
        tableDetail.setShowRoot(false);
    }

    /**
     *
     * Method to place more information in the summary of the sale.
     */
    private void initializeMoreInfoOnResume() {
        Client client = newSale.getClient();
        firstNameResume.setText(client.getFirstName());
        lastNameResume.setText(client.getLastName());
        phoneNumberResume.setText(client.getPhoneNumber());
        identifyCardResume.setText(client.getIdentifyCard());
        clientNumberResume.setText(client.getClientNumber());
        isPreSale.setSelected(newSale.isIsPreSale());
    }

    /**
     *
     * Method to place the date in the summary of the sale.
     */
    private void initializeDateOnResume() {
        if (!newSale.isIsPreSale()) {
            datePane.setDisable(true);
        } else {
            dateResume.setValue(newSale.getPurchaseDate());
        }
    }

    /**
     *
     *
     * Method to place the point of sale in the summary of the sale.
     */
    @FXML
    private void initializePointOfSaleOnResume() {
        PointOfSale shopPlace = newSale.getShopPlace();
        txtAreaPintOfSale.setText(shopPlace.getName() + ", " + shopPlace.getAddress());
    }

    /**
     *
     * Method that initializes the more informationsection.
     */
    @FXML
    private void initializeMoreInformation() {
        Client client = mySystem.getClient();
        if (!"".equals(client.getClientNumber())) {
            clientNumber.setText(client.getClientNumber());
            clientNumber.setDisable(true);
        }
        if (!"".equals(client.getFirstName())) {
            firstName.setText(client.getFirstName());
            firstName.setDisable(true);
        }
        if (!"".equals(client.getLastName())) {
            lastName.setText(client.getLastName());
            lastName.setDisable(true);
        }
        if (!"".equals(client.getIdentifyCard())) {
            identifyCard.setText(client.getIdentifyCard());
            identifyCard.setDisable(true);
        }
        if (!"".equals(client.getPhoneNumber())) {
            phoneNumber.setText(client.getPhoneNumber());
            phoneNumber.setDisable(true);
        }
    }

    /**
     * Method that initializes the map.
     */
    @FXML
    private void intitializeMap() {
        final URL urlGoogleMaps = getClass().getResource("htmlResources/mapBuyFlow.html");
        browser.getEngine().load(urlGoogleMaps.toExternalForm());
    }

    /**
     *
     * Method that loads the list of points of sale.
     */
    private void initializeListViewOfPointOfSales() {
        availablePointsOfSale.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        ArrayList<PointOfSale> points = mySystem.getSalePoints();
        for (int i = 0; i < points.size(); i++) {
            availablePointsOfSale.getItems().add(points.get(i));
        }
    }

    /**
     *
     * Method that initializes the part of the window where the purchase process
     * takes place.
     */
    @FXML
    private void initializeTabs() {
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
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
     * Method that opens a window when the user is in the "Points of sale"
     * section and clicks on next arrow.
     *
     * @param e Click in next arrow.
     * @throws IOException A exception.
     */
    @FXML
    public void nextOfPointOfSaleTabEvent(MouseEvent e) throws IOException {
        PointOfSale pointSelected = (PointOfSale) availablePointsOfSale.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error de local seleccionado");
        if (pointSelected != null) {
            newSale.setShopPlace(pointSelected);
            initializeDateOnResume();
            initializePointOfSaleOnResume();
            nextTabLogic();
        } else {
            alert.setContentText("Debe seleccionar un punto de venta");
            alert.showAndWait();
        }
    }

    /**
     * Method that opens a window when the user is in the "Purchase date"
     * section and clicks on next arrow.
     *
     * @param e Click in next arrow.
     * @throws IOException A exception.
     */
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

    /**
     *
     * Method that opens a window when the user is in the "More info" section
     * and clicks on next arrow.
     *
     * @param e Click in next arrow.
     * @throws IOException A exception.
     */
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
            initializeMoreInfoOnResume();
        }
    }

    /**
     * Method that returns true if the user completes all fields.
     *
     * @return true if the user completes all fields.
     */
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

    /**
     * Method that invokes the "nextTabLogic" method.
     *
     * @param e Click in next arrow.
     * @throws IOException
     */
    @FXML
    public void nextTabEvent(MouseEvent e) throws IOException {
        nextTabLogic();
    }

    /**
     * Method that invokes the "previousTabLogic" method.
     *
     * @param e Click in previous arrow.
     * @throws IOException A exception.
     */
    @FXML
    public void previousTabEvent(MouseEvent e) throws IOException {
        previousTabLogic();
    }

    /**
     * Method that confirms and adds the sale to the system.
     *
     * @param e Click in "Register purchase".
     * @throws IOException A exception.
     */
    @FXML
    public void confirmTabEvent(MouseEvent e) throws IOException {
        newSale.setTotalPrice(newSale.obtainPrice());
        mySystem.addSale(newSale);
        newSale = new Sale();

        nextTabLogic();
    }

    /**
     *
     *
     * Method to go back in the map window.
     *
     * @param e Click in previous arrow.
     * @throws IOException A exception.
     */
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

    /**
     * Method that opens the window that contains all the products (main
     * window).
     *
     * @param e Click in "list of products".
     * @throws IOException A exception.
     */
    public void goToHome(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfBuyer.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     *
     * Logic of the method when moving forward in the sales process.
     */
    public void nextTabLogic() {
        tabPane.getTabs().get(currentTab).setDisable(true);
        currentTab++;
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }

    /**
     *
     * Logic of the method when going backwards in the sales process.
     */
    public void previousTabLogic() {
        tabPane.getTabs().get(currentTab).setDisable(true);
        currentTab--;
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }

    /**
     *
     * Method that passes to the previous stage in the sales process
     *
     * @param e Click in previous right.
     * @throws IOException A exception.
     */
    @FXML
    public void backLogic(MouseEvent e) throws IOException {
        switch (currentTab) {
            case 1:
                arrowBack.setVisible(false);
                previousTabLogic();
                break;
            case 2:
                previousTabLogic();
                break;
            case 3:
                previousOfPointsOfSaleTabEvent(e);
                break;
            case 4:
                previousTabLogic();
                break;
        }
    }

    /**
     *
     * Method that passes to the next stage in the sales process
     *
     * @param e Click in arrow next.
     * @throws IOException A exception.
     */
    @FXML
    public void nextLogic(MouseEvent e) throws IOException {
        switch (currentTab) {
            case 0:
                nextTabEvent(e);
                arrowBack.setVisible(true);
                break;
            case 1:
                nextOfMoreInfoTabEvent(e);
                break;
            case 2:
                nextOfDateTabEvent(e);
                break;
            case 3:
                nextOfPointOfSaleTabEvent(e);
                break;
            case 4:
                confirmTabEvent(e);
                arrowBack.setVisible(false);
                arrowNext.setVisible(false);
                break;
        }
    }

    /**
     *
     * Auxiliary class to load the table.
     */
    class PurchasedProductInfo extends RecursiveTreeObject<PurchasedProductInfo> {

        StringProperty productName;
        StringProperty quantitySold;
        StringProperty incomeGenerated;
        StringProperty priceUnit;

        PurchasedProductInfo(Product aProduct, int quantity) {
            this.productName = new SimpleStringProperty(aProduct.getName());
            this.quantitySold = new SimpleStringProperty("" + quantity);
            this.incomeGenerated = new SimpleStringProperty("$ " + (quantity * aProduct.getPrice()));
            this.priceUnit = new SimpleStringProperty("$ " + aProduct.getPrice());
        }
    }

}
