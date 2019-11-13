/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import static interfaces.Ecoshop.mySystem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author Agustin Hernandorena
 */
public class OrganicProductsPieChartController implements Initializable {

    @FXML
    private PieChart pieChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Data> list = FXCollections.observableArrayList(
                new PieChart.Data("Organico", mySystem.quantityOfOrganicProductsSold()[0]),
                new PieChart.Data("Inorganico", mySystem.quantityOfOrganicProductsSold()[1])
        );
        pieChart.setData(list);
    }

}
