package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 * This class represents a sale, one of the main functionalities of the system.
 * It contains the list of products sold, list of packages, client, among
 * others.
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public final class Sale {

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
        this.setPurchaseDate(LocalDate.now());
    }

    /**
     * Constructor with parameters.
     *
     * @param shopPlace The shop place of the sale.
     * @param ticketNumber The ticket number of the sale.
     * @param fullPayment The full payment made by the client.
     * @param totalPrice The total price of the sale. It is the sum of the
     * prices of the products sold.
     */
    public Sale(PointOfSale shopPlace, String ticketNumber, int fullPayment, int totalPrice) {
        this.setShopPlace(shopPlace);
        this.setTicketNumber(ticketNumber);
        this.setFullPayment(fullPayment);
        this.setTotalPrice(totalPrice);
        this.setChange(totalPrice - fullPayment);
        purchasedProducts = new ArrayList<>();
        usedPackagingList = new ArrayList<>();
        this.setPurchaseDate(LocalDate.now());
    }

    /**
     * Method that returns the client who made the purchase.
     *
     * @return The client who made the purchase.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Method that sets the client who made the purchase.
     *
     * @param client The client who made the purchase.
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Method that returns true if it is a pre-purchase.
     *
     * @return True, if it is a pre-purchase
     */
    public boolean isIsPreSale() {
        return isPreSale;
    }

    /**
     * Method that sets true if it is a pre-purchase.
     *
     * @param isPreSale True, if it is a pre-purchase.
     */
    public void setIsPreSale(boolean isPreSale) {
        this.isPreSale = isPreSale;
    }

    /**
     * Method that returns a list of pairs: (Product sold, quantity)
     *
     * @return A list of pairs: (Product sold, quantity).
     */
    public ArrayList<Pair> getPurchasedProducts() {
        return purchasedProducts;
    }

    /**
     * Method that returns a Pair with the product passed by parameter, and the
     * quantity sold currently.
     *
     * @param product The product we want to know the current quantity sold.
     * @return
     */
    public Pair getProduct(Product product) {
        Product aProduct = new Product();
        Pair returnedValue = new Pair(aProduct, 0);
        for (int i = 0; i < purchasedProducts.size(); i++) {
            Pair currentPair = purchasedProducts.get(i);
            Product currentProduct = (Product) purchasedProducts.get(i).getKey();
            if (currentProduct.getName().equalsIgnoreCase(product.getName())) {
                returnedValue = currentPair;
            }
        }
        return returnedValue;
    }

    /**
     *
     * Given a product, it returns true if that product belongs to the list of
     * products sold.
     *
     * @param product The product you want to know if it belongs to the list of
     * products sold
     * @return
     */
    public boolean pertain(Product product) {
        boolean ret = false;
        for (int i = 0; i < purchasedProducts.size(); i++) {
            Product currentProduct = (Product) purchasedProducts.get(i).getKey();
            if (currentProduct.getName().equalsIgnoreCase(product.getName())) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Given a pair (Product, Quantity), add this product to the list of
     * products sold
     *
     * @param product Product that you want to add to the cart.
     */
    public void addProductToCart(Pair product) {
        Product productToAdd = (Product) product.getKey();
        int quantity = (int) product.getValue();
        setFullPayment(getFullPayment() + productToAdd.getPrice() * quantity);
        purchasedProducts.add(product);
    }

    /**
     * Given a pair (Product,Quantity) remove this product to the list of
     * products sold.
     *
     * @param product Product that you want to remove to the cart.
     */
    public void removeProductOfCart(Pair product) {
        purchasedProducts.remove(product);
    }

    /**
     * Method that returns a shop place of the sale.
     *
     * @return The shop place of the sale.
     */
    public PointOfSale getShopPlace() {
        return shopPlace;
    }

    /**
     * Method that sets a shop place of the sale.
     *
     * @param shopPlace The shop place of the sale.
     */
    public void setShopPlace(PointOfSale shopPlace) {
        this.shopPlace = shopPlace;
    }

    /**
     * Method that returns a total price of the sale.
     *
     * @return The total price of the sale.
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * Method that sets a total price of the sale.
     *
     * @param aTotalPrice The total price of the sale.
     */
    public void setTotalPrice(int aTotalPrice) {
        totalPrice = aTotalPrice;
    }

    /**
     * Method that obtain de total price of the sale. Adding the price of each
     * product sold multiplied by its quantity.
     *
     * @return The total price of the sale.
     */
    public int obtainPrice() {
        int totalPrice = 0;
        for (int i = 0; i < purchasedProducts.size(); i++) {
            Product p = (Product) purchasedProducts.get(i).getKey();
            int quantity = (int) purchasedProducts.get(i).getValue();
            totalPrice += p.getPrice() * (quantity);
        }
        return totalPrice;
    }

    /**
     * Method that returns a ticket number of the sale.
     *
     * @return A ticket number of the sale.
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Method that sets a ticket number of the sale.
     *
     * @param ticketNumber A ticket number of the sale.
     */
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    /**
     * Method that returns the total client payment.
     *
     * @return The total client payment.
     */
    public int getFullPayment() {
        return fullPayment;
    }

    /**
     * Method that returns the purchase date.
     *
     * @return Purchase date
     */
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Method that sets the purchase date.
     *
     * @param purchaseDate The purchase date.
     */
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * Method that sets the total client payment.
     *
     * @param fullPayment The total client payment.
     */
    public void setFullPayment(int fullPayment) {
        this.fullPayment = fullPayment;
    }

    /**
     * Method that returns the change of the sale. The change of the sale equals
     * full payment - total price.
     *
     * @return The change of the sale.
     */
    public int getChange() {
        return change;
    }

    /**
     * Method that sets the change of the sale.
     *
     * @param change The change of the sale.
     */
    public void setChange(int change) {
        this.change = change;
    }

    /**
     * Method that returns the list of used packages for sale.
     *
     * @return The list of used packages for sale.
     */
    public ArrayList<Package> getPackagesUsed() {
        return usedPackagingList;
    }

    /**
     * Method that adds a package to used packages list of the sale.
     *
     * @param aPackage The package to add.
     */
    public void addUsedPackage(Package aPackage) {
        usedPackagingList.add(aPackage);
    }

    /**
     * Method that remove a package to used packages list of the sale.
     *
     * @param aPackage The package to remove.
     */
    public void removeUsedPackage(Package aPackage) {
        usedPackagingList.remove(aPackage);
    }

}
