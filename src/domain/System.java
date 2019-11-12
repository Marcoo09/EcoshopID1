/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.util.Pair;

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

    public System() {
        clientList = new ArrayList<>();
        packagesList = new ArrayList<>();
        salePoints = new ArrayList<>();
        products = new ArrayList<>();
        sales = new ArrayList<>();
    }

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public ArrayList<Package> getPackagesList() {
        return packagesList;
    }

    public ArrayList<PointOfSale> getSalePoints() {
        return salePoints;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

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

    public int[] salesPerMonth() {
        int[] salesPerMonth = new int[13];
        for (int i = 0; i < sales.size(); i++) {
            salesPerMonth[sales.get(i).getPurchaseDate().getMonthValue()] += sales.get(i).getTotalPrice();
        }
        return salesPerMonth;
    }

    public Pair totalSaleByProduct(Product aProduct) {
        int quantity = 0;
        for (int i = 0; i < sales.size(); i++) {
            ArrayList<Pair> purchasedProducts = sales.get(i).getPurchasedProducts();
            for (int j = 0; j < purchasedProducts.size(); j++) {
                Pair actualProduct = purchasedProducts.get(j);
                Product myProduct = (Product) actualProduct.getKey();
                int actualQuantity = (int) actualProduct.getValue();
                if (myProduct.getName().equals(aProduct.getName())) {
                    quantity += actualQuantity;
                }
            }
        }
        Pair returnPair = new Pair(aProduct, quantity);
        return returnPair;
    }

    public ArrayList<Pair> totalQuantitySoldPerProduct() {
        ArrayList<Pair> returnList = new ArrayList<>();
        for (int i = 0; i < sales.size(); i++) {
            Sale actualSale = sales.get(i);
            for (int j = 0; j < actualSale.getPurchasedProducts().size(); j++) {
                Pair aPair = totalSaleByProduct((Product) actualSale.getPurchasedProducts().get(j).getKey());
                if(!returnList.contains(aPair)){
                    returnList.add(aPair);
                } 
            }
        }
        return returnList;
    }

    public Pair mostSelledProduct() {
        ArrayList<Pair> list = totalQuantitySoldPerProduct();
        int max = -1;
        Pair returnPair = null;
        for (int i = 0; i < list.size(); i++) {
            Pair actualPair = list.get(i);
            if ((int) actualPair.getValue() > max) {
                max = (int) actualPair.getValue();
                returnPair = actualPair;
            }
        }
        return returnPair;
    }

    public ArrayList<Pair> productsOrderedBySales() {
        ArrayList<Pair> list = totalQuantitySoldPerProduct();
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if ((int) (o1.getValue()) > (int) o2.getValue()) {
                    return -1;
                } else if ((int) (o1.getValue()) == (int) o2.getValue()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
        );
        return list;
    }

}
