package interfaces;

import com.jfoenix.controls.JFXTabPane;
import static interfaces.Ecoshop.myPrimaryStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Marco Fiorito
 */
public class PurchaseDetailController implements Initializable {
    
    private Integer currentTab;
    
    @FXML
    JFXTabPane tabPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentTab = 0;
        initializeTabs();
    }
    
    @FXML
    public void initializeTabs(){
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }
    
    @FXML
    public void nextTabEvent(MouseEvent e) throws IOException{
        
        tabPane.getTabs().get(currentTab).setDisable(true);
        currentTab++;
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }
      
    @FXML
    public void previousTabEvent(MouseEvent e) throws IOException{
        tabPane.getTabs().get(currentTab).setDisable(true);
        currentTab--;
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }
    
    public void goToHome(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfBuyer.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
}
