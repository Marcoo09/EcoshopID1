package domain;

/**
 * This class represents a package of a product.
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public final class Package {

    private String name;
    private String material;
    private int capacity;

    public Package() {
        this.setName("");
        this.setMaterial("");
        this.setCapacity(0);
    }

    /**
     * Constructor with parameters.
     *
     * @param name It is the name of the package.
     * @param material It is the material of the package.
     * @param capacity It is the capacity of the package.
     */
    public Package(String name, String material, int capacity) {
        this.setName(name);
        this.setMaterial(material);
        this.setCapacity(capacity);
    }

    /**
     * Method that returns the name of the package.
     *
     * @return Name of the package.
     */
    public String getName() {
        return name;
    }

    /**
     * Method that sets the name of the package
     *
     * @param name Name of the package.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that returns the material of the package.
     *
     * @return Material of the package
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Method that sets the material of the package.
     *
     * @param material Material of the package.
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Method that returns the capacity of the package.
     *
     * @return Capacity of the package.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Method that sets the capacity of the package.
     *
     * @param capacity Capacity of the package.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * toString method to print a package.
     *
     * @return Name of the package.
     */
    @Override
    public String toString() {
        return "" + name;
    }

}
