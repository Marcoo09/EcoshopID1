/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Agustin Hernandorena
 */
public class System {

    private ArrayList<Client> clientList;
    private ArrayList<Package> packagesList;
    private ArrayList<PointOfSale> salePoints;
    private ArrayList<Product> products;
    private ArrayList<Sale> sales;

    public void addClient(Client aClient) {
        clientList.add(aClient);
    }

    public void addPackage(Package aPackage) {
        packagesList.add(aPackage);
    }

    public void addSalePoint(PointOfSale aSalePoint) {
        salePoints.add(aSalePoint);
    }

    public void addProduct(Product aProduct) {
        products.add(aProduct);
    }

    public void addSale(Sale aSale) {
        sales.add(aSale);
    }
    
}
