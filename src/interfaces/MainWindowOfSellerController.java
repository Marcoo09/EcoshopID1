/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import static interfaces.JavaFXApplication1.myPrimaryStage;
import java.io.IOException;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Agustin Hernandorena
 */
public class MainWindowOfSellerController implements Initializable {

    @FXML
    private JFXCheckBox check;
    @FXML
    private Label bestSeller;
    @FXML
    private JFXComboBox<Label> combo = new JFXComboBox<>();

    @FXML
    public void evento(ActionEvent e) {
        java.lang.System.out.println("hola");
    }

    @FXML
    public void evento3(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BestSellerWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    @FXML
    public void evento2(ActionEvent e) {
        if (check.isSelected()) {
            java.lang.System.out.println("hola");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Label l = new Label("Plastico");
        combo.getItems().add(l);
    }
}
