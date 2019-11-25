package interfaces;

import domain.PointOfSale;
import static interfaces.Ecoshop.myPrimaryStage;
import static interfaces.Ecoshop.mySystem;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;

/**
 *
 * This class contains graphic representations of the main metrics of the
 * ecoshop: total sales per month, sales per ecoshop.
 *
 * @author Marco Fiorito and Agustin Hernandorena
 */
public class DashboardWindowController implements Initializable {

    @FXML
    private PieChart saleAndPreSale;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initalizePieChart();
        initalizeBarChart();
        initalizeLineChart();
    }

    /**
     *
     * This method loads the amount of sales and pre-sales data in a pie chart.
     */
    public void initalizePieChart() {
        int quantityOfPreSales = mySystem.quantityOfPreSales();
        int quantityOfSales = mySystem.getSales().size() - quantityOfPreSales;
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList(
                new PieChart.Data("Ventas", quantityOfSales),
                new PieChart.Data("Pre-ventas", quantityOfPreSales)
        );
        saleAndPreSale.setData(list);
    }

    /**
     *
     * This method loads the total sales amount per point of sale in a bar
     * chart.
     */
    public void initalizeBarChart() {
        ArrayList<Pair> salesPerPointOfSale = mySystem.salesListPerPointOfSale();
        XYChart.Series set1 = new XYChart.Series<>();
        for (int i = 0; i < salesPerPointOfSale.size(); i++) {
            Pair currentPair = salesPerPointOfSale.get(i);
            PointOfSale currentPointOfSale = (PointOfSale) currentPair.getKey();
            int gain = (int) currentPair.getValue();
            set1.getData().add(new XYChart.Data(currentPointOfSale.getName(), gain));
        }
        barChart.getData().addAll(set1);
    }

    /**
     *
     * This method loads the total sales amount of all the sales points in each
     * month in a linear graph.
     */
    public void initalizeLineChart() {
        XYChart.Series set1 = new XYChart.Series<>();
        int[] salesPerMonth = mySystem.salesPerMonth();
        for (int i = 1; i <= 12; i++) {
            set1.getData().add(new XYChart.Data(i + "", salesPerMonth[i]));
        }
        lineChart.getData().addAll(set1);
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
