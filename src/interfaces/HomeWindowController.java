package interfaces;

import static interfaces.Ecoshop.myPrimaryStage;
import java.awt.Dimension;
import java.awt.Toolkit;
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
 * This class shows the main menu. From it you can access the seller profile or
 * the buyer profile.
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public class HomeWindowController implements Initializable {

    /**
     *
     * This method opens the window in the seller profile.
     *
     * @param e Click on the seller button.
     * @throws IOException A exception.
     */
    @FXML
    public void sellerEvent(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfSeller.fxml"));
        Scene scene = new Scene(root);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        myPrimaryStage.setScene(scene);
        myPrimaryStage.setMaximized(true);
        myPrimaryStage.setWidth(screenSize.getWidth());
        myPrimaryStage.setHeight(screenSize.getHeight());
        myPrimaryStage.show();
    }

    /**
     * This method opens the window in the buyer profile.
     *
     * @param e Click on the buyer button.
     * @throws IOException A exception.
     */
    @FXML
    public void buyerEvent(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfBuyer.fxml"));
        Scene scene = new Scene(root);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        myPrimaryStage.setScene(scene);
        myPrimaryStage.setMaximized(true);
        myPrimaryStage.setWidth(screenSize.getWidth());
        myPrimaryStage.setHeight(screenSize.getHeight());
        myPrimaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
