package interfaces;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import domain.Client;
import static interfaces.Ecoshop.myPrimaryStage;
import static interfaces.Ecoshop.mySystem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public class RegisterClientWindowController implements Initializable {
    
    @FXML
    private JFXTextField name;
    
    @FXML
    private JFXTextField surname;
    
    @FXML
    private JFXTextField telephone;
    
    @FXML
    private JFXTextField indentifyCard;
    
    @FXML
    private JFXButton btnRegister;
    
    @FXML
    private StackPane myPane;
    
    @FXML
    private Label title;
    
    @FXML
    private AnchorPane mainPane;
    
    private boolean existClient;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        existClient = false;
        Client aClient = mySystem.getClient();
        if (!aClient.getFirstName().equals("")) {
            existClient = true;
            btnRegister.setText("Actualizar");
            title.setText("Modificar cuenta");
            name.setText(aClient.getFirstName());
            surname.setText(aClient.getLastName());
            telephone.setText(aClient.getPhoneNumber());
            indentifyCard.setText(aClient.getIdentifyCard());
        }
    }
    
    @FXML
    public void mainWindowOfBuyerEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfBuyer.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
    @FXML
    public void goToCartEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PurchaseDetail.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }

    @FXML
    public void sellerProfileEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfSeller.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
    @FXML
    public void pointsOfSaleEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PointsOfSaleWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
    @FXML
    public void registerClientEvent(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegisterClientWindow.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
    @FXML
    public void eventRegister(ActionEvent e) {
        Client aClient = mySystem.getClient();
        String nameOfClient = "";
        String surnameOfClient = "";
        String telephoneNumberOfClient = "";
        String identificationDocumentOfClient = "";
        nameOfClient = name.getText();
        surnameOfClient = surname.getText();
        telephoneNumberOfClient = telephone.getText();
        identificationDocumentOfClient = indentifyCard.getText();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Campo sin completar.");
        if (nameOfClient.equals("")) {
            alert.setContentText("Debe ingresar un nombre.");
            alert.showAndWait();
        } else if (surnameOfClient.equals("")) {
            alert.setContentText("Debe ingresar un apellido.");
            alert.showAndWait();
        } else if (telephoneNumberOfClient.equals("")) {
            alert.setContentText("Debe ingresar un numero de telefono.");
            alert.showAndWait();
        } else if (identificationDocumentOfClient.equals("")) {
            alert.setContentText("Debe ingresar su cedula de identidad.");
            alert.showAndWait();
        } else {
            aClient.setFirstName(nameOfClient);
            aClient.setlastName(surnameOfClient);
            aClient.setIdentifyCard(identificationDocumentOfClient);
            aClient.setPhoneNumber(telephoneNumberOfClient);
            aClient.setClientNumber(nameOfClient + identificationDocumentOfClient);
            JFXDialogLayout content = new JFXDialogLayout();
            if (!existClient) {
                existClient = true;
                content.setHeading(new Text("Registro."));
                content.setBody(new Text("El cliente se ha registrado en el sistema."));
            } else {
                content.setHeading(new Text("Modificacion."));
                content.setBody(new Text("Se han actualizado los datos correctamente."));
            }
            myPane.setMargin(mainPane, new Insets(180, 141, 260, 280));
            JFXDialog dialog = new JFXDialog(myPane, content, JFXDialog.DialogTransition.CENTER);
            JFXButton okButton = new JFXButton("Aceptar");
            okButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    title.setText("Modificar cuenta");
                    btnRegister.setText("Actualizar");
                    dialog.close();
                }
            });
            content.setActions(okButton);
            dialog.show();
        }
    }
}
