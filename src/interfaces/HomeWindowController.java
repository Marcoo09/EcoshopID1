package interfaces;

import com.jfoenix.controls.JFXButton;
import static interfaces.Ecoshop.myPrimaryStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */

public class HomeWindowController implements Initializable {

    @FXML
    public void sellerEvent(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfSeller.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show(); 
    }
    
    @FXML
    public void buyerEvent(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfBuyer.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show(); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
