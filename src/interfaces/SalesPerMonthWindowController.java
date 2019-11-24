package interfaces;

import com.jfoenix.controls.JFXComboBox;
import static interfaces.Ecoshop.myPrimaryStage;
import static interfaces.Ecoshop.mySystem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */

public class SalesPerMonthWindowController implements Initializable {
    public static String monthSelected;

    @FXML
    private BarChart<?, ?> salesChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private JFXComboBox<Label> monthCheckBox;

    
    @FXML
    private AnchorPane mainPane;
    @FXML
    private ImageView perfil;
    @FXML
    private Label bestSeller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 1; i <= 12; i++) {
            monthCheckBox.getItems().add(new Label("" + i));
        }
        XYChart.Series set1 = new XYChart.Series<>();
        int[] salesPerMonth = mySystem.salesPerMonth();
        for (int i = 1; i <= 12; i++) {
            set1.getData().add(new XYChart.Data(i + "", salesPerMonth[i]));
        }
        salesChart.getData().addAll(set1);
    }

    @FXML
    public void addProduct(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfSeller.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
    @FXML
    public void mostSelledProducts(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MostSelledProductsWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    @FXML
    public void salesPerMonthEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SalesPerMonthWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    @FXML
    public void preSalesEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PreSaleListWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    @FXML
    public void pieChartEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OrganicProductsPieChart.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
    @FXML
    public void buyerProfileEvent(MouseEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfBuyer.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
    @FXML
    public void addProductEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfSeller.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
    @FXML
    public void reusedPackagesEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MostUsedPackageWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    @FXML
    public void dashboardEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DashboardWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
    public void monthEvent(ActionEvent e) {
        monthSelected = monthCheckBox.getSelectionModel().getSelectedItem().getText();
    }
    
    public void viewDetail (ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("SalesPerMonthInDetailWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show(); 
    }


}
