/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inteface;


import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Agustin Hernandorena
 */
public class MainMenuController implements Initializable {

    private Button boton;
    
    @FXML
    public void evento(ActionEvent e){
        System.out.println("hola");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    
}
