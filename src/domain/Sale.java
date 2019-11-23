package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */

public class Sale {

    private ArrayList<Pair> purchasedProducts;
    private PointOfSale shopPlace;
    private int totalPrice;
    private String ticketNumber;
    private LocalDate purchaseDate;
    private int fullPayment;
    private int change;
    private ArrayList<Package> usedPackagingList;
    private boolean isPreSale;
    private Client client;
    
    public Sale() {
        purchasedProducts = new ArrayList<>();
        usedPackagingList = new ArrayList<>();
        setPurchaseDate(LocalDate.now());
    }

    public Sale(PointOfSale shopPlace, String ticketNumber, int fullPayment, int totalPrice) {
        setShopPlace(shopPlace);
        setTicketNumber(ticketNumber);
        setFullPayment(fullPayment);
        setTotalPrice(totalPrice);
        setChange(totalPrice - fullPayment);
        purchasedProducts = new ArrayList<>();
        usedPackagingList = new ArrayList<>();
        setPurchaseDate(LocalDate.now());
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isIsPreSale() {
        return isPreSale;
    }

    public void setIsPreSale(boolean isPreSale) {
        this.isPreSale = isPreSale;
    }
    
    public ArrayList<Pair> getPurchasedProducts() {
        return purchasedProducts;
    }
    
    public Pair getProduct(Product product){
        Product aProduct = new Product();
        Pair returnedValue = new Pair(aProduct,0);
        for (int i = 0; i < purchasedProducts.size(); i++) {
            Pair currentPair = purchasedProducts.get(i);
            Product currentProduct = (Product)purchasedProducts.get(i).getKey();
            if(currentProduct.getName().equalsIgnoreCase(product.getName())){
                returnedValue = currentPair;
            }
        }
        return returnedValue;
    }
    
    public boolean pertain(Product product){
        boolean ret=false;
        for (int i = 0; i < purchasedProducts.size(); i++) {
            Product currentProduct = (Product)purchasedProducts.get(i).getKey();
            if(currentProduct.getName().equalsIgnoreCase(product.getName())){
                ret=true;
            }
        }
        return ret;
    }
    
    public void addProductToCart(Pair product) {
        Product productToAdd = (Product) product.getKey();
        int quantity = (int) product.getValue();
        setFullPayment(getFullPayment() + productToAdd.getPrice() * quantity);
        purchasedProducts.add(product);
    }

    public void removeProductOfCart(Pair product) {
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
        totalPrice = aTotalPrice;
    }

    public int obtainPrice() {
        int totalPrice = 0;
        for (int i = 0; i < purchasedProducts.size(); i++) {
            Product p = (Product) purchasedProducts.get(i).getKey();
            int quantity = (int) purchasedProducts.get(i).getValue();
            totalPrice += p.getPrice() * (quantity);
        }
        return totalPrice;
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

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
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

    @Override
    public String toString() {
        return "Sale{" + "purchasedProducts=" + purchasedProducts + ", shopPlace=" + shopPlace + ", totalPrice=" + totalPrice + ", ticketNumber=" + ticketNumber + ", purchaseDate=" + purchaseDate + ", fullPayment=" + fullPayment + ", change=" + change + ", usedPackagingList=" + usedPackagingList + '}';
    }
}
