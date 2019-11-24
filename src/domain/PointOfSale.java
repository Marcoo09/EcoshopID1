package domain;

import java.util.ArrayList;

/**
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public final class PointOfSale {

    private String address;
    private String name;
    private String description;
    private ArrayList<Product> productsForSale;
    private ArrayList<Product> selledProducts;
    private ArrayList<Sale> sales;

    public PointOfSale() {
        productsForSale = new ArrayList<>();
        selledProducts = new ArrayList<>();
        sales = new ArrayList<>();
        this.setAddress("");
        this.setName("");
        this.setDescription("");
    }

    public PointOfSale(String address, String name, String description) {
        this.setAddress(address);
        this.setName(name);
        this.setDescription(description);
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

    public ArrayList<Product> getSelledProducts() {
        return selledProducts;
    }

    public void addProductForSale(Product product) {
        productsForSale.add(product);
    }

    public void addSoldProduct(Product p) {
        selledProducts.add(p);
    }

    @Override
    public String toString() {
        return name;
    }

}
