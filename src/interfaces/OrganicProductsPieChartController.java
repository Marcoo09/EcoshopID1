package interfaces;

import static interfaces.Ecoshop.myPrimaryStage;
import static interfaces.Ecoshop.mySystem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.input.MouseEvent;

/**
 *
 * This class controls the window that shows a pie chart with the amount of
 * organic and inorganic products sold.
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public class OrganicProductsPieChartController implements Initializable {

    @FXML
    private PieChart pieChart;

    /**
     *
     * This method loads the quantity of organic and inorganic products sold in
     * a pie chart.
     *
     * @param location A location.
     * @param resources A resource.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Data> list = FXCollections.observableArrayList(
                new PieChart.Data("Organico", mySystem.quantityOfOrganicProductsSold()[0]),
                new PieChart.Data("Inorganico", mySystem.quantityOfOrganicProductsSold()[1])
        );
        pieChart.setData(list);
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

}
