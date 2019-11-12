/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.time.LocalDateTime;
import javafx.util.Pair;

/**
 *
 * @author Agustin Hernandorena
 */
public class Sale {

    private ArrayList<Pair> purchasedProducts;
    private PointOfSale shopPlace;
    private int totalPrice;
    private String ticketNumber;
    private LocalDateTime purchaseDate;
    private int fullPayment;
    private int change;
    private ArrayList<Package> usedPackagingList;

    public Sale() {
        purchasedProducts = new ArrayList<>();
        usedPackagingList = new ArrayList<>();
    }

    public Sale(PointOfSale shopPlace, String ticketNumber, int fullPayment,
            int totalPrice) {
        setShopPlace(shopPlace);
        setTicketNumber(ticketNumber);
        setFullPayment(fullPayment);
        setTotalPrice(totalPrice);
        setChange(totalPrice - fullPayment);
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

    public void removeProductOfCart(Product product) {
        purchasedProducts.remove(product);
    }

    public PointOfSale getShopPlace() {
        return shopPlace;
    }

    public void setShopPlace(PointOfSale shopPlace) {
        this.shopPlace = shopPlace;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int aTotalPrice) {
        totalPrice=aTotalPrice;
    }
    
    public int obtainPrice(){
        int totalPrice = 0;
        for (int i = 0; i < purchasedProducts.size(); i++) {
            Product p = (Product) purchasedProducts.get(i).getKey();
            int quantity = (int) purchasedProducts.get(i).getValue();
            totalPrice += p.getPrice() * (quantity);
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Sale{" + "purchasedProducts=" + purchasedProducts + ", shopPlace=" + shopPlace + ", totalPrice=" + totalPrice + ", ticketNumber=" + ticketNumber + ", purchaseDate=" + purchaseDate + ", fullPayment=" + fullPayment + ", change=" + change + ", usedPackagingList=" + usedPackagingList + '}';
    }
    
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getFullPayment() {
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

    public int getChange() {
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

    public void removeUsedPackage(Package aPackage) {
        usedPackagingList.remove(aPackage);
    }

}
