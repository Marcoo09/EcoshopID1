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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author Agustín Hernandorena and Marco Fiorito
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
        initializeListView();
        initializeMoreInformation();
        intitializeMap();
        initializeListViewOfPointOfSales();
        initializeResume();
    }

    @FXML
    private void initializeResume(){
        initializeDetailOnResume();
        txtTotal.setText("$" + newSale.getFullPayment());
    }
    
    @FXML
    private void initializeDetailOnResume(){
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
            products.add(new PurchasedProductInfo(value,quantity));
        }
        final TreeItem<PurchasedProductInfo> root = new RecursiveTreeItem<PurchasedProductInfo>(products, RecursiveTreeObject::getChildren);
        table.getColumns().setAll(nameCol, quantityCol, priceUnitCol,priceAllCol);
        table.setRoot(root);
        table.setShowRoot(false);
    }
    
    private void initializeMoreInfoOnResume(){
        Client client = newSale.getClient();
        firstNameResume.setText(client.getFirstName());
        lastNameResume.setText(client.getLastName());
        phoneNumberResume.setText(client.getPhoneNumber());
        identifyCardResume.setText(client.getIdentifyCard());
        clientNumberResume.setText(client.getClientNumber());
        isPreSale.setSelected(newSale.isIsPreSale());
    }
    
    private void initializeDateOnResume(){
        if(!newSale.isIsPreSale()){
            datePane.setDisable(true);
        }else{
            dateResume.setValue(newSale.getPurchaseDate());
        }
    }

    @FXML
    private void initializePointOfSaleOnResume(){
        PointOfSale shopPlace = newSale.getShopPlace();
        txtAreaPintOfSale.setText(shopPlace.getName() + ", " + shopPlace.getAddress());
    }
    
    @FXML
    private void initializeMoreInformation(){
        Client client = mySystem.getClient();
        if(client.getClientNumber() != ""){
            clientNumber.setText(client.getClientNumber());
            clientNumber.setDisable(true);
        }
        if(client.getFirstName()!= ""){
            firstName.setText(client.getFirstName());
            firstName.setDisable(true);
        }
        if(client.getLastName()!= ""){
            lastName.setText(client.getLastName());
            lastName.setDisable(true);
        }
        if(client.getIdentifyCard()!= ""){
            identifyCard.setText(client.getIdentifyCard());
            identifyCard.setDisable(true);
        }
        if(client.getPhoneNumber()!= ""){
            phoneNumber.setText(client.getPhoneNumber());
            phoneNumber.setDisable(true);
        }
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
            initializeDateOnResume();
            initializePointOfSaleOnResume();
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
            initializeMoreInfoOnResume();
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
        java.lang.System.out.println(mySystem.totalUsedPackages());
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

    @FXML
    public void backLogic(MouseEvent e) throws IOException {
        switch(currentTab){ 
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
    
    @FXML
    public void nextLogic(MouseEvent e) throws IOException {
        switch(currentTab){ 
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
    
    class PurchasedProductInfo extends RecursiveTreeObject<PurchasedProductInfo> {

        StringProperty productName;
        StringProperty quantitySold;
        StringProperty incomeGenerated;
        StringProperty priceUnit;
        
        public PurchasedProductInfo(Product aProduct, int quantity) {
            this.productName = new SimpleStringProperty(aProduct.getName());
            this.quantitySold = new SimpleStringProperty("" + quantity);
            this.incomeGenerated = new SimpleStringProperty("$ " + (quantity * aProduct.getPrice()));
            this.priceUnit = new SimpleStringProperty("$ " + aProduct.getPrice());
        }
    }
    
}
