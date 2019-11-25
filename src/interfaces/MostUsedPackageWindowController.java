package interfaces;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
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
 * This class controls the window that shows the most reused package and a list
 * of all the packages and with number of times they were reused.
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public class MostUsedPackageWindowController implements Initializable {

    @FXML
    private JFXTreeTableView<Container> table;

    @FXML
    private ImageView packageImage;

    @FXML
    private Label lblQuantity;

    @FXML
    private Label lblName;

    /**
     *
     * At the beginning, the most used package image is loaded. Then a table is
     * loaded with all the packages and the number of times they were reused.
     *
     * @param location A location.
     * @param resources A resorces.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Pair mostUsedPackage = mySystem.mostUsedPackage();
        domain.Package aPackage = (domain.Package) mostUsedPackage.getKey();
        Image img = new Image("resources/" + aPackage.getName() + ".png");
        packageImage.setImage(img);
        lblName.setText(aPackage.getName());
        lblQuantity.setText("" + mostUsedPackage.getValue());
        JFXTreeTableColumn<Container, String> nameCol = new JFXTreeTableColumn<>("Nombre");
        nameCol.setPrefWidth(150);
        nameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Container, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Container, String> param) {
                return param.getValue().getValue().name;
            }
        });
        JFXTreeTableColumn<Container, String> quantityCol = new JFXTreeTableColumn<>("Cantidad");
        quantityCol.setPrefWidth(150);
        quantityCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Container, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Container, String> param) {
                return param.getValue().getValue().numberOfTimesReused;
            }
        });
        JFXTreeTableColumn<Container, String> materialCol = new JFXTreeTableColumn<>("Material");
        materialCol.setPrefWidth(150);
        materialCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Container, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Container, String> param) {
                return param.getValue().getValue().material;
            }
        });
        ObservableList<Container> packages = FXCollections.observableArrayList();
        ArrayList<Pair> usedPackages = mySystem.totalUsedPackages();
        for (int i = 0; i < usedPackages.size(); i++) {
            Pair p = usedPackages.get(i);
            domain.Package currentPackage = (domain.Package) p.getKey();
            int quantity = (int) p.getValue();
            packages.add(new Container(currentPackage.getName(), quantity, currentPackage.getMaterial()));
        }
        final TreeItem<Container> root = new RecursiveTreeItem<Container>(packages, RecursiveTreeObject::getChildren);
        table.getColumns().setAll(nameCol, quantityCol, materialCol);
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
     * Auxiliary class used to complete the table
     */
    class Container extends RecursiveTreeObject<Container> {

        StringProperty name;
        StringProperty numberOfTimesReused;
        StringProperty material;

        Container(String aName, int aNumberOfTimesReused, String aMaterial) {
            this.name = new SimpleStringProperty(aName);
            this.numberOfTimesReused = new SimpleStringProperty("" + aNumberOfTimesReused);
            this.material = new SimpleStringProperty(aMaterial);
        }
    }

}
