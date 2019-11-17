package interfaces;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import components.ProductListCellController;
import domain.Client;
import static interfaces.Ecoshop.myPrimaryStage;
import static interfaces.Ecoshop.newSale;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author Marco Fiorito
 */
public class PurchaseDetailController implements Initializable {
    
    private Integer currentTab;
    
    @FXML
    JFXTabPane tabPane;
    
    @FXML
    JFXListView listOfProducts;
    
    @FXML
    JFXTextField firstName;
    
    @FXML    
    JFXTextField lastName;
    
    @FXML
    JFXTextField phoneNumber;
            
    @FXML
    JFXCheckBox isPreSale;
         
    @FXML
    JFXDatePicker date;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentTab = 0;
        initializeTabs();
        initializeListView();
    }
    
    @FXML
    private void initializeTabs(){
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }
    
    @FXML
    private void initializeListView() {
        ArrayList<Pair> purchasedProducts = newSale.getPurchasedProducts();
        purchasedProducts.forEach((product) -> {
            try{
//                System.out.println("Entre");
                Label lbl = new Label("" +product.getValue());
                lbl.setGraphic(new ImageView(new Image("resources/" + product.getKey() + ".png")));
//                ProductListCellController productListCell = new ProductListCellController(product);
//                System.out.println("hasta aca lleguee");
//                listOfProducts.getItems().add(productListCell);
                  listOfProducts.getItems().add(lbl);
            }catch(Exception e){
                System.out.println("An error occurs in charge the list");
            }
        });
    }
    
    @FXML
    public void nextOfDateTabEvent(MouseEvent e) throws IOException{
        LocalDate dateSelected = date.getValue();
        if(dateSelected!= null){
            LocalDate today = now();
            if(dateSelected.isBefore(today)){
                //ERROR FECHA INVALIDA
            }else{
                newSale.setPurchaseDate(dateSelected);
                nextTabLogic();
            }
        }else{
            //ERROR SELECCIONAR FECHA
        }
    }
    
    
    @FXML
    public void nextOfMoreInfoTabEvent(MouseEvent e) throws IOException{
        Client client = new Client(firstName.getText(),lastName.getText(),"",phoneNumber.getText(),0);
        boolean isPreSaleValue = isPreSale.isSelected();
        newSale.setClient(client);
        newSale.setIsPreSale(isPreSaleValue);
        tabPane.getTabs().get(currentTab).setDisable(true);
        currentTab++;
        if(!isPreSaleValue){
            currentTab++;
        }
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }
    
    @FXML
    public void nextTabEvent(MouseEvent e) throws IOException{        
        nextTabLogic();
    }
      
    @FXML
    public void previousTabEvent(MouseEvent e) throws IOException{
        previousTabLogic();
    }
    
    @FXML
    public void previousOfPointsOfSaleTabEvent(MouseEvent e) throws IOException{
        tabPane.getTabs().get(currentTab).setDisable(true);
        currentTab--;
        if(!newSale.isIsPreSale()){
            currentTab--;
        }
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }
    
    public void goToHome(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowOfBuyer.fxml"));
        Scene scene = new Scene(root);
        myPrimaryStage.setScene(scene);
        myPrimaryStage.show();
    }
    
    public void nextTabLogic(){
        tabPane.getTabs().get(currentTab).setDisable(true);
        currentTab++;
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);
    }
    
    public void previousTabLogic(){
        tabPane.getTabs().get(currentTab).setDisable(true);
        currentTab--;
        tabPane.getTabs().get(currentTab).setDisable(false);
        tabPane.getSelectionModel().select(currentTab);     
    }
    
}
