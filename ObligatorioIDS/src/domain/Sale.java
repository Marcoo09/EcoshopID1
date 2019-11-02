/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.time.LocalDateTime;
import utilites.Pair;

/**
 *
 * @author Agustin Hernandorena
 */
public class Sale {
    //The pair represents: (quantity, product).
    private ArrayList<Pair> purchasedProducts;
    private PointOfSale shopPlace;
    private double totalPrice;
    private String ticketNumber;
    private LocalDateTime purchaseDate;
    private double fullPayment;
    private double change;
    private ArrayList<Package> usedPackagingList;
    

    Sale() {
        purchasedProducts = new ArrayList<>();
        usedPackagingList = new ArrayList<>();
    }

    Sale(PointOfSale shopPlace, String ticketNumber, int fullPayment,
            int totalPrice) {
        setShopPlace(shopPlace);
        setTicketNumber(ticketNumber);
        setFullPayment(fullPayment);
        setTotalPrice(totalPrice);
        setChange(totalPrice-fullPayment);
        purchasedProducts = new ArrayList<>();
        usedPackagingList = new ArrayList<>();
        setPurchaseDate(LocalDateTime.now());
        
    }

    public ArrayList<Pair> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void addProductToCart(Pair product) {
        purchasedProducts.add(product);
    }
    
    public void removeProductOfCart(Pair product){
        purchasedProducts.remove(product);
    }

    public PointOfSale getShopPlace() {
        return shopPlace;
    }

    public void setShopPlace(PointOfSale shopPlace) {
        this.shopPlace = shopPlace;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public double getFullPayment() {
        return fullPayment;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setFullPayment(int fullPayment) {
        this.fullPayment = fullPayment;
    }

    public double getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public ArrayList<Package> getPackagesUsed() {
        return usedPackagingList;
    }

    public void addUsedPackage(Package aPackage) {
        usedPackagingList.add(aPackage);
    }
    
    public void removeUsedPackage(Package aPackage){
        usedPackagingList.remove(aPackage);
    }
    
}
