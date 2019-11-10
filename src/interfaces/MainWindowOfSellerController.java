/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Agustin Hernandorena
 */
public class MainWindowOfSellerController implements Initializable {

    @FXML
    private JFXCheckBox organicCheck;
    @FXML
    private Label bestSeller;
    @FXML
    private JFXListView<domain.Package> availablePackages;
    @FXML
    private Text agregarProducto;
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

    @FXML
    public void evento3(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BestSellerWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    @FXML
    public void registerEvent(ActionEvent e) {
        String name = nameTextField.getText();
        String originCountry = originCountryTextField.getText();
        int price = (Integer.parseInt(priceTextField.getText()));
        String material = materialTextField.getText();
        boolean isOrganic = false;
        boolean formedFromRecycledMaterial = false;
        if (organicCheck.isSelected()) {
            isOrganic = true;
        }
        if (formedForRecycledMaterialCheck.isSelected()) {
            formedFromRecycledMaterial = true;
        }
        ObservableList<domain.Package> list = availablePackages.getSelectionModel().getSelectedItems();
        Product p = new Product(originCountry, isOrganic, formedFromRecycledMaterial, price, material, 20, name);
        for (int i = 0; i < list.size(); i++) {
            p.addPackage(list.get(i));
        }
        mySystem.addProduct(p);
        JFXDialogLayout content = new JFXDialogLayout();
        myStackPane.setMargin(mainPane, new Insets(180, 141, 260, 280));
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        availablePackages.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        for (int i = 0; i < mySystem.getPackagesList().size(); i++) {
            availablePackages.getItems().add(mySystem.getPackagesList().get(i));
        }
    }
}
