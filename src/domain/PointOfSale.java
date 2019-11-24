package domain;

import java.util.ArrayList;

/**
 * This class represent a point of sale of the system. The point of sale has
 * products for sale that can be purchased by clients.
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

    /**
     * Constructor with parameters.
     *
     * @param address The adress of the point of sale.
     * @param name The name of the point of sale.
     * @param description A description of the point of sale.
     */
    public PointOfSale(String address, String name, String description) {
        this.setAddress(address);
        this.setName(name);
        this.setDescription(description);
        productsForSale = new ArrayList<>();
        selledProducts = new ArrayList<>();
        sales = new ArrayList<>();
    }

    /**
     * Method that return the adress of the point of sale.
     *
     * @return Adress of the point of sale.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method that sets the adress of the point of sale.
     *
     * @param address Adress of the point of sale.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Method that returns the name of the point of sale.
     *
     * @return Name of the point of sale.
     */
    public String getName() {
        return name;
    }

    /**
     * Method that sets the name of the point of sale.
     *
     * @param name Name of the point of sale.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that return a description of the point of sale.
     *
     * @return Description of the point of sale.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method that sets a description of the point of sale.
     *
     * @param description Description of the point of sale.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method that return the list of products for sale.
     *
     * @return The list of products for sale.
     */
    public ArrayList<Product> getProductsForSale() {
        return productsForSale;
    }

    /**
     * Method that return the sales list of the point of sale.
     *
     * @return The sales list.
     */
    public ArrayList<Sale> getSales() {
        return sales;
    }

    /**
     * Method that adds a sale to the point of sale.
     *
     * @param aSale The sale to add.
     */
    public void addSale(Sale aSale) {
        sales.add(aSale);
    }

    /**
     * Method that return the list of selled products of the point of sale.
     *
     * @return The list of selled products.
     */
    public ArrayList<Product> getSelledProducts() {
        return selledProducts;
    }

    /**
     * Method that adds a product to the list of products of the point of sale.
     *
     * @param product The product to add.
     */
    public void addProductForSale(Product product) {
        productsForSale.add(product);
    }

    /**
     * Method that adds a product to the list of selled products.
     *
     * @param product The name of the product sold.
     */
    public void addSoldProduct(Product product) {
        selledProducts.add(product);
    }

    /**
     * toString method to print a point of sale.
     *
     * @return The name of the product.
     */
    @Override
    public String toString() {
        return name;
    }

}
