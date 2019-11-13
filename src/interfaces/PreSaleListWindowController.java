/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import domain.Product;
import static interfaces.Ecoshop.mySystem;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;
import javafx.util.Pair;

/**
 *
 * @author Agustin Hernandorena
 */
public class PreSaleListWindowController implements Initializable {

    @FXML
    private JFXTreeTableView<Sale> table;

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
        for (int i = 0; i < mySystem.getPreSales().size(); i++) {
            domain.Sale s = mySystem.getPreSales().get(i);
            preSales.add(new Sale(s.getTotalPrice(), s.getTicketNumber(), s.getPurchaseDate(), s.getPurchasedProducts(),s.getClient().getIdentifyCard()));
        }
        final TreeItem<Sale> root = new RecursiveTreeItem<Sale>(preSales, RecursiveTreeObject::getChildren);
        table.getColumns().setAll(orderedNumberCol, purchasedProductsCol, pickupDateCol, totalPriceCol, clientIdentityCardCol);
        table.setRoot(root);
        table.setShowRoot(false);
    }

    class Sale extends RecursiveTreeObject<Sale> {

        StringProperty totalPrice;
        StringProperty orderNumber;
        StringProperty pickupDate;
        StringProperty purchasedProducts;
        StringProperty clientIdentityCard;

        public Sale(int aTotalPrice, String orderNumber, LocalDateTime aPickupDate, ArrayList<Pair> aPurchasedProducts, String aIdentityCard) {
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
