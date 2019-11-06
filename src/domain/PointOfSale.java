/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Product;
import domain.Sale;
import java.util.ArrayList;
import java.util.Collections;
import utilites.Pair;

/**
 *
 * @author Agustin Hernandorena
 */
public class PointOfSale {

    private String address;
    private String name;
    private String description;
    private ArrayList<Product> productsForSale;
    private ArrayList<Pair> selledProducts;
    private ArrayList<Sale> sales;

    PointOfSale() {
        productsForSale = new ArrayList<>();
        selledProducts = new ArrayList<>();
        sales = new ArrayList<>();
    }

    PointOfSale(String address, String name, String description) {
        setAddress(address);
        setName(name);
        setDescription(description);
        productsForSale = new ArrayList<>();
        selledProducts = new ArrayList<>();
        sales = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Product> getProductsForSale() {
        return productsForSale;
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public void addSale(Sale aSale) {
        sales.add(aSale);
    }

    public ArrayList<Pair> getSelledProducts() {
        return selledProducts;
    }

    public void addProductForSale(Product product) {
        productsForSale.add(product);
    }

    public void addSoldProduct(Pair p) {
        selledProducts.add(p);
    }

    //PRE: The store sold some product.
    //POS: Given a natural n, returns a list of the n best selling products of
    // the store.
    public ArrayList<Pair> mostSelledProducts(int quantity) {
        ArrayList<Pair> listOfBestSellingProducts = new ArrayList<>();
        for (int i = 0; i < selledProducts.size() && quantity > 0; i++) {
            listOfBestSellingProducts.add(selledProducts.get(i));
            quantity--;
        }
        return listOfBestSellingProducts;
    }

    //PRE: This operation don't have preconditions.
    //POS: Given a month, return a list of all sales in that month.
    public ArrayList<Sale> salesPerMonth(int month) {
        ArrayList<Sale> returnList = new ArrayList<>();
        for (int i = 0; i < sales.size(); i++) {
            if (sales.get(i).getPurchaseDate().getDayOfMonth() == month) {
                returnList.add(sales.get(i));
            }
        }
        return returnList;
    }

}
