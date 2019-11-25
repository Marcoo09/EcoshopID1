package interfaces;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import domain.Product;
import static interfaces.Ecoshop.myPrimaryStage;
import static interfaces.Ecoshop.mySystem;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.Pair;

/**
 *
 * This class controls the window that shows a list of pre-sales.
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public class PreSaleListWindowController implements Initializable {

    @FXML
    private JFXTreeTableView<Sale> table;

    /**
     *
     * Method that loads a list with pre-sales.
     *
     * @param location A location.
     * @param resources A resources.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFXTreeTableColumn<Sale, String> orderedNumberCol = new JFXTreeTableColumn<>("Numero de orden");
        orderedNumberCol.setPrefWidth(150);
        orderedNumberCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Sale, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Sale, String> param) {
                return param.getValue().getValue().orderNumber;
            }
        });
        JFXTreeTableColumn<Sale, String> purchasedProductsCol = new JFXTreeTableColumn<>("Productos comprados");
        purchasedProductsCol.setPrefWidth(220);
        purchasedProductsCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Sale, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Sale, String> param) {
                return param.getValue().getValue().purchasedProducts;
            }
        });
        JFXTreeTableColumn<Sale, String> pickupDateCol = new JFXTreeTableColumn<>("Fecha de recogida");
        pickupDateCol.setPrefWidth(150);
        pickupDateCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Sale, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Sale, String> param) {
                return param.getValue().getValue().pickupDate;
            }
        });
        JFXTreeTableColumn<Sale, String> totalPriceCol = new JFXTreeTableColumn<>("Precio Total");
        totalPriceCol.setPrefWidth(150);
        totalPriceCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Sale, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Sale, String> param) {
                return param.getValue().getValue().totalPrice;
            }
        });
        JFXTreeTableColumn<Sale, String> clientIdentityCardCol = new JFXTreeTableColumn<>("Cedula de Identidad");
        clientIdentityCardCol.setPrefWidth(150);
        clientIdentityCardCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Sale, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Sale, String> param) {
                return param.getValue().getValue().clientIdentityCard;
            }
        });
        ObservableList<Sale> preSales = FXCollections.observableArrayList();
        for (int i = 0; i < mySystem.getSales().size(); i++) {
            domain.Sale s = mySystem.getSales().get(i);
            if (s.isIsPreSale()) {
                preSales.add(new Sale(s.getTotalPrice(), s.getTicketNumber(), s.getPurchaseDate(), s.getPurchasedProducts(), s.getClient().getIdentifyCard()));
            }
        }
        final TreeItem<Sale> root = new RecursiveTreeItem<Sale>(preSales, RecursiveTreeObject::getChildren);
        table.getColumns().setAll(orderedNumberCol, purchasedProductsCol, pickupDateCol, totalPriceCol, clientIdentityCardCol);
        table.setRoot(root);
        table.setShowRoot(false);
    }

    /**
     * This method opens the window of adding a product to the system.
     *
     * @param e Click made by the client.
     * @throws IOException A exception.
     */
    @FXML
    public void addProduct(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfSeller.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     *
     * This method opens the window of the best selling product.
     *
     * @param e Click made by the client.
     * @throws IOException A exception.
     */
    @FXML
    public void mostSelledProducts(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MostSelledProductsWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     *
     * This method opens the sales per month window.
     *
     * @param e Click made by the client.
     * @throws IOException A exception.
     */
    @FXML
    public void salesPerMonthEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SalesPerMonthWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     *
     * This method opens the window that contains the pre-sales list.
     *
     * @param e Click made by the client.
     * @throws IOException A exception.
     */
    @FXML
    public void preSalesEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PreSaleListWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     *
     * This method opens the window that contains a pie chart with the quantity
     * of organic and inorganic products sold.
     *
     * @param e Click made by the client.
     * @throws IOException A exception.
     */
    @FXML
    public void pieChartEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OrganicProductsPieChart.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     *
     * This method opens the buyer profile window.
     *
     * @param e Click made by the client.
     * @throws IOException A exception.
     */
    @FXML
    public void buyerProfileEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfBuyer.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     * This method opens the window of adding a product to the system.
     *
     * @param e Click made by the client.
     * @throws IOException A exception.
     */
    @FXML
    public void addProductEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfSeller.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     *
     * This method opens the most used package window.
     *
     * @param e Click made by the client.
     * @throws IOException A exception.
     */
    @FXML
    public void reusedPackagesEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MostUsedPackageWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     *
     * This method opens this same window.
     *
     * @param e Click made by the client.
     * @throws IOException A exception.
     */
    @FXML
    public void dashboardEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DashboardWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    /**
     *
     * Auxiliary class to load the table.
     */
    class Sale extends RecursiveTreeObject<Sale> {

        StringProperty totalPrice;
        StringProperty orderNumber;
        StringProperty pickupDate;
        StringProperty purchasedProducts;
        StringProperty clientIdentityCard;

        Sale(int aTotalPrice, String orderNumber, LocalDate aPickupDate, ArrayList<Pair> aPurchasedProducts, String aIdentityCard) {
            this.totalPrice = new SimpleStringProperty(aTotalPrice + "");
            this.orderNumber = new SimpleStringProperty(orderNumber);
            this.pickupDate = new SimpleStringProperty("" + aPickupDate.getDayOfMonth() + "-" + aPickupDate.getMonthValue() + "-" + aPickupDate.getYear());
            String products = "";
            for (int i = 0; i < aPurchasedProducts.size(); i++) {
                Product p = (Product) aPurchasedProducts.get(i).getKey();
                int quantity = (int) aPurchasedProducts.get(i).getValue();
                products = products + "-" + " " + p.getName() + " " + "x" + quantity + " " + "Unidades" + System.lineSeparator();
            }
            this.purchasedProducts = new SimpleStringProperty(products);
            this.clientIdentityCard = new SimpleStringProperty(aIdentityCard);
        }
    }

}
