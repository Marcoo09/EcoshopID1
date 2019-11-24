package domain;

import java.util.ArrayList;

/**
 *
 * This class represents a product, which can be purchased by a client.
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public final class Product {

    private String name;
    private String countryOfOrigin;
    private boolean Organic;
    private boolean formedFromRecycledMaterials;
    private int price;
    private String material;
    private int identifier;

    private ArrayList<Package> listOfAvailablePackages;

    public Product() {
        this.setCountryOfOrigin("");
        this.setOrganic(false);
        this.setFormedFromRecycledMaterials(false);
        this.setPrice(0);
        this.setMaterial("");
        this.setIdentifier(0);
        listOfAvailablePackages = new ArrayList<>();
    }

    /**
     * Constructor with parameters.
     *
     * @param countryOfOrigin The country of origin of the product.
     * @param organic It is true if the product is organic.
     * @param formedFromRecycledMaterials It is true if the product is formed
     * from recycled materials.
     * @param price The price of the product.
     * @param material The material of the product.
     * @param identifier The identifier of the product.
     * @param name The name of the product.
     */
    public Product(String countryOfOrigin, boolean organic,
            boolean formedFromRecycledMaterials, int price,
            String material, int identifier, String name) {
        this.setCountryOfOrigin(countryOfOrigin);
        this.setOrganic(organic);
        this.setFormedFromRecycledMaterials(formedFromRecycledMaterials);
        this.setPrice(price);
        this.setMaterial(material);
        this.setIdentifier(identifier);
        this.setName(name);

        listOfAvailablePackages = new ArrayList<>();
    }

    /**
     * Method that returns the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Method that sets the name of the product.
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that returns the country of origin of the product.
     *
     * @return The country of origin of the product.
     */
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    /**
     * Method that sets the country of origin of the product.
     *
     * @param countryOfOrigin Country of the origin of the product.
     */
    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    /**
     * Method that returns true if the product is organic.
     *
     * @return True, if the product is organic.
     */
    public boolean isOrganic() {
        return Organic;
    }

    /**
     * Method that sets true if the product is organic.
     *
     * @param Organic True, if the product is organic.
     */
    public void setOrganic(boolean Organic) {
        this.Organic = Organic;
    }

    /**
     * Method that returns true if the product is formed from recycled
     * materials.
     *
     * @return True, if the product is formed from recycled materials.
     */
    public boolean isFormedFromRecycledMaterials() {
        return formedFromRecycledMaterials;
    }

    /**
     * Method that sets true if the product is formed from recycled materials.
     *
     * @param formedFromRecycledMaterials True, if the product is formed from
     * recycled materials.
     */
    public void setFormedFromRecycledMaterials(boolean formedFromRecycledMaterials) {
        this.formedFromRecycledMaterials = formedFromRecycledMaterials;
    }

    /**
     * Method that returns the price of the product.
     *
     * @return The price of the product.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Method that sets the price of the product.
     *
     * @param price The price of the product.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Method that return the material of the product.
     *
     * @return The material of the product.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Method that sets the material of the product.
     *
     * @param material The material of the product.
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Method that return the identifier of the product (Integer number).
     *
     * @return The identifier of the product.
     */
    public int getIdentifier() {
        return identifier;
    }

    /**
     * Method that sets the identifier of the product (Integer number).
     *
     * @param identifier The identifier of the product.
     */
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    /**
     * Method that returns the list of available packages for this product.
     *
     * @return The list of available packages for this product.
     */
    public ArrayList<Package> getListOfAvailablePackages() {
        return listOfAvailablePackages;
    }

    /**
     * Method that adds a package to the list of available packages for this
     * product.
     *
     * @param aPackage The package to add.
     */
    public void addPackage(Package aPackage) {
        listOfAvailablePackages.add(aPackage);
    }

    /**
     * toString method to print a product.
     *
     * @return The material of the product, "organic", if the product is
     * organic, "inorganic" if the product is inorganic, and the country of
     * origin.
     */
    @Override
    public String toString() {
        return "El material es: " + material + "\n" + (Organic ? "Es organico\n" : "No es Organico\n")
                + "Proviene de " + countryOfOrigin + "\n";
    }

}
