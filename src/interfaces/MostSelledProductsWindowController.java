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
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.Pair;

/**
 * This class controls the window that shows the best selling product, and a
 * list of all products and quantity sold.
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public class MostSelledProductsWindowController implements Initializable {

    @FXML
    private ImageView productImage;

    @FXML
    private Label lblName;

    @FXML
    private Label lblQuantity;

    @FXML
    private JFXTreeTableView<ProductInfo> table;

    /**
     *
     * This method loads a list with products and the quantity sold. At the
     * beginning, load the image of the best selling product.
     *
     * @param location A location.
     * @param resources A resources.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Pair mostSelled = mySystem.mostSelledProduct();
        Product mostSelledProduct = (Product) mostSelled.getKey();
        Image img = new Image("resources/" + mostSelledProduct.getName() + ".png");
        productImage.setImage(img);
        lblName.setText(mostSelledProduct.getName());
        lblQuantity.setText("" + mostSelled.getValue());
        JFXTreeTableColumn<ProductInfo, String> nameCol = new JFXTreeTableColumn<>("Nombre");
        nameCol.setPrefWidth(150);
        nameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ProductInfo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ProductInfo, String> param) {
                return param.getValue().getValue().productName;
            }
        });
        JFXTreeTableColumn<ProductInfo, String> quantityCol = new JFXTreeTableColumn<>("Cantidad");
        quantityCol.setPrefWidth(150);
        quantityCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ProductInfo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ProductInfo, String> param) {
                return param.getValue().getValue().quantitySold;
            }
        });
        JFXTreeTableColumn<ProductInfo, String> incomeGeneratedCol = new JFXTreeTableColumn<>("Ganancias generadas");
        incomeGeneratedCol.setPrefWidth(150);
        incomeGeneratedCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ProductInfo, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<ProductInfo, String> param) {
                return param.getValue().getValue().incomeGenerated;
            }
        });
        ObservableList<ProductInfo> products = FXCollections.observableArrayList();
        ArrayList<Pair> sortedProducts = mySystem.totalQuantitySoldPerProduct();
        for (int i = 0; i < sortedProducts.size(); i++) {
            Pair p = sortedProducts.get(i);
            products.add(new ProductInfo((Product) p.getKey(), (int) p.getValue()));
        }
        final TreeItem<ProductInfo> root = new RecursiveTreeItem<ProductInfo>(products, RecursiveTreeObject::getChildren);
        table.getColumns().setAll(nameCol, quantityCol, incomeGeneratedCol);
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
     * This method opens the dashboard window.
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
     * Auxiliary class used to complete the table.
     */
    class ProductInfo extends RecursiveTreeObject<ProductInfo> {

        StringProperty productName;
        StringProperty quantitySold;
        StringProperty incomeGenerated;

        ProductInfo(Product aProduct, int quantity) {
            this.productName = new SimpleStringProperty(aProduct.getName());
            this.quantitySold = new SimpleStringProperty("" + quantity);
            this.incomeGenerated = new SimpleStringProperty("" + (quantity * aProduct.getPrice()));
        }
    }

}
