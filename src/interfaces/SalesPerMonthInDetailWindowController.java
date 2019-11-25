package interfaces;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import domain.Product;
import static interfaces.Ecoshop.myPrimaryStage;
import static interfaces.Ecoshop.mySystem;
import static interfaces.SalesPerMonthWindowController.monthSelected;
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
 * This class controls the window that shows a table with the sales made in a
 * given month.
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public class SalesPerMonthInDetailWindowController implements Initializable {

    @FXML
    private JFXTreeTableView<Sale> treeView;

    /**
     *
     * Method that shows a table with the sales made in a given month.
     *
     * @param location A location.
     * @param resources A resource.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFXTreeTableColumn<Sale, String> ticketNumberCol = new JFXTreeTableColumn<>("Numero de ticket");
        ticketNumberCol.setPrefWidth(150);
        ticketNumberCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Sale, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Sale, String> param) {
                return param.getValue().getValue().ticketNumber;
            }
        });
        JFXTreeTableColumn<Sale, String> purchasedDateCol = new JFXTreeTableColumn<>("Fecha de compra");
        purchasedDateCol.setPrefWidth(150);
        purchasedDateCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Sale, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Sale, String> param) {
                return param.getValue().getValue().purchasedDate;
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
        JFXTreeTableColumn<Sale, String> totalPriceCol = new JFXTreeTableColumn<>("Precio Total");
        totalPriceCol.setPrefWidth(150);
        totalPriceCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Sale, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Sale, String> param) {
                return param.getValue().getValue().totalPrice;
            }
        });
        ObservableList<Sale> sales = FXCollections.observableArrayList();
        for (int i = 0; i < mySystem.getSales().size(); i++) {
            domain.Sale s = mySystem.getSales().get(i);
            if (s.getPurchaseDate().getMonthValue() == Integer.parseInt(monthSelected)) {
                sales.add(new Sale(s.getTotalPrice(), s.getTicketNumber(), s.getPurchaseDate(), s.getPurchasedProducts()));
            }
        }
        final TreeItem<Sale> root = new RecursiveTreeItem<Sale>(sales, RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll(ticketNumberCol, purchasedDateCol, purchasedProductsCol, totalPriceCol);
        treeView.setRoot(root);
        treeView.setShowRoot(false);

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
     * This method opens the dasbord window.
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
     * Auxiliary class used to load the table.
     */
    class Sale extends RecursiveTreeObject<Sale> {

        StringProperty totalPrice;
        StringProperty ticketNumber;
        StringProperty purchasedDate;
        StringProperty purchasedProducts;

        Sale(int aTotalPrice, String ticketNumber, LocalDate aPurchasedDate, ArrayList<Pair> aPurchasedProducts) {
            this.totalPrice = new SimpleStringProperty(aTotalPrice + "");
            this.ticketNumber = new SimpleStringProperty(ticketNumber);
            this.purchasedDate = new SimpleStringProperty("" + aPurchasedDate.getDayOfMonth() + "-" + aPurchasedDate.getMonthValue() + "-" + aPurchasedDate.getYear());
            String products = "";
            for (int i = 0; i < aPurchasedProducts.size(); i++) {
                Product p = (Product) aPurchasedProducts.get(i).getKey();
                int quantity = (int) aPurchasedProducts.get(i).getValue();
                products = products + "-" + " " + p.getName() + " " + "x" + quantity + " " + "Unidades" + System.lineSeparator();

            }
            this.purchasedProducts = new SimpleStringProperty(products);
        }
    }

}
