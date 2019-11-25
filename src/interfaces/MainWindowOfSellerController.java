package interfaces;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import domain.Product;
import static interfaces.Ecoshop.myPrimaryStage;
import static interfaces.Ecoshop.mySystem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 *
 * This class controls the window that allows you to register a product in the
 * system.
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public class MainWindowOfSellerController implements Initializable {

    @FXML
    private JFXCheckBox organicCheck;
    @FXML
    private JFXListView<domain.Package> availablePackages;
    @FXML
    private JFXTextField nameTextField;
    @FXML
    private JFXTextField originCountryTextField;
    @FXML
    private JFXTextField priceTextField;
    @FXML
    private JFXTextField materialTextField;
    @FXML
    private JFXCheckBox formedForRecycledMaterialCheck;
    @FXML
    private StackPane myStackPane;
    @FXML

    private AnchorPane mainPane;

    private int count = mySystem.getProducts().size();

    /**
     *
     * This method loads the list of packages available for the product to add.
     *
     * @param url A url.
     * @param rb A rb.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        availablePackages.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        for (int i = 0; i < mySystem.getPackagesList().size(); i++) {
            availablePackages.getItems().add(mySystem.getPackagesList().get(i));
        }
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
     * This method registers the product in the system, if the entries are
     * correct.
     *
     * @param e Click in "Register" button.
     */
    public void registerEvent(ActionEvent e) {
        String name = "";
        String originCountry = "";
        String material = "";
        String price = "";
        int intPrice = -1;
        boolean isInt = false;
        boolean isLetter = false;
        name = nameTextField.getText();
        originCountry = originCountryTextField.getText();
        price = priceTextField.getText();
        try {
            intPrice = Integer.parseInt(price);
            isInt = true;
        } catch (NumberFormatException excepcion) {
            isLetter = true;
        }
        material = materialTextField.getText();
        boolean isOrganic = false;
        boolean formedFromRecycledMaterial = false;
        if (organicCheck.isSelected()) {
            isOrganic = true;
        }
        if (formedForRecycledMaterialCheck.isSelected()) {
            formedFromRecycledMaterial = true;
        }
        ObservableList<domain.Package> list = availablePackages.getSelectionModel().getSelectedItems();
        Product p = new Product(originCountry, isOrganic, formedFromRecycledMaterial, intPrice, material, 20, name);
        for (int i = 0; i < list.size(); i++) {
            p.addPackage(list.get(i));
        }
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error faltan ingresar datos.");
        if (list.size() == 0) {
            alert.setContentText("Debe seleccionar algun envase.");
            alert.showAndWait();
        } else if (name.equals("")) {
            alert.setContentText("Debe ingresar un nombre.");
            alert.showAndWait();
        } else if (originCountry.equals("")) {
            alert.setContentText("Debe ingresar un pais de origen.");
            alert.showAndWait();
        } else if (material.equals("")) {
            alert.setContentText("Debe ingresar un material.");
            alert.showAndWait();
        } else if (price.equals("")) {
            alert.setContentText("Debe ingresar un precio.");
            alert.showAndWait();
        } else if (isLetter) {
            alert.setContentText("El precio debe ser un numero.");
            alert.showAndWait();
        } else if (intPrice <= 0 && isInt) {
            alert.setContentText("El precio debe ser positivo.");
            alert.showAndWait();
        } else {
            mySystem.addProduct(p);
            JFXDialogLayout content = new JFXDialogLayout();
            StackPane.setMargin(mainPane, new Insets(100, 141, 260, 500));
            content.setHeading(new Text("Alta de producto"));
            content.setBody(new Text("El producto se ha registrado correctamente en el sistema"));
            JFXDialog dialog = new JFXDialog(myStackPane, content, JFXDialog.DialogTransition.CENTER);
            JFXButton okButton = new JFXButton("Aceptar");
            okButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    dialog.close();
                    nameTextField.setText("");
                    originCountryTextField.setText("");
                    materialTextField.setText("");
                    priceTextField.setText("");
                    organicCheck.setSelected(false);
                    formedForRecycledMaterialCheck.setSelected(false);
                    availablePackages.getSelectionModel().clearSelection();

                }
            });
            content.setActions(okButton);
            dialog.show();
            count++;
        }

    }
}
