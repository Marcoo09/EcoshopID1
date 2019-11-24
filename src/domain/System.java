package domain;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 * This class contains all the data collections: packages, sales, pre-sales,
 * points of sale.
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public class System {

    private Client client;
    private ArrayList<Package> packagesList;
    private ArrayList<PointOfSale> salePoints;
    private ArrayList<Product> products;
    private ArrayList<Sale> sales;
    private ArrayList<Sale> preSales;
    private boolean isInPreSaleMode;

    public System() {
        client = new Client();
        packagesList = new ArrayList<>();
        salePoints = new ArrayList<>();
        products = new ArrayList<>();
        sales = new ArrayList<>();
        preSales = new ArrayList<>();
        isInPreSaleMode = false;
    }

    /**
     * Method that returns True, if the client is making a pre-purchase.
     *
     * @return True, if the client is making a pre-purchase.
     */
    public boolean isIsInPreSaleMode() {
        return isInPreSaleMode;
    }

    /**
     * Method that sets True, if the client is making a pre-purchase.
     *
     * @param isInPreSaleMode True, if the client is making a pre-purchase.
     */
    public void setIsInPreSaleMode(boolean isInPreSaleMode) {
        this.isInPreSaleMode = isInPreSaleMode;
    }

    /**
     * Method that returns a list of pre-sales.
     *
     * @return The list of pre-sales.
     */
    public ArrayList<Sale> getPreSales() {
        return preSales;
    }

    /**
     * Method that adds a sale to the list of pre-sales.
     *
     * @param aSale The to add a list of pre-sales.
     */
    public void addPreSale(Sale aSale) {
        this.preSales.add(aSale);
    }

    /**
     * Method that returns the client of the system.
     *
     * @return The client of the System.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Method that returns the list of available packages.
     *
     * @return The list of packages.
     */
    public ArrayList<Package> getPackagesList() {
        return packagesList;
    }

    /**
     * Method that returns the list of point of sale.
     *
     * @return The list of points of sale.
     */
    public ArrayList<PointOfSale> getSalePoints() {
        return salePoints;
    }

    /**
     * Method that returns the list of products.
     *
     * @return The list of products.
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Method that returns the list of sales.
     *
     * @return The list of sales.
     */
    public ArrayList<Sale> getSales() {
        return sales;
    }

    /**
     * Method that set client to the system.
     *
     * @param aClient The client to set.
     */
    public void setClient(Client aClient) {
        client = aClient;
    }

    /**
     * Method that adds a package to the packages list of the system.
     *
     * @param aPackage Package to add.
     */
    public void addPackage(Package aPackage) {
        packagesList.add(aPackage);
    }

    /**
     * Method that add a point of sale to the sales point list of the system.
     *
     * @param aSalePoint Point of sale to add.
     */
    public void addSalePoint(PointOfSale aSalePoint) {
        salePoints.add(aSalePoint);
    }

    /**
     * Method that adds a product to the products list of the system.
     *
     * @param aProduct Product to add.
     */
    public void addProduct(Product aProduct) {
        products.add(aProduct);
    }

    /**
     * Method that adds a sale to the sales list of the system.
     *
     * @param aSale Sale to add.
     */
    public void addSale(Sale aSale) {
        sales.add(aSale);
    }

    /**
     * Method that returns a array with the total sales per month.
     *
     * @return An array of 13 positions, and in each of them the total sales
     * (the index corresponds to the month).
     */
    public int[] salesPerMonth() {
        int[] salesPerMonth = new int[13];
        for (int i = 0; i < sales.size(); i++) {
            salesPerMonth[sales.get(i).getPurchaseDate().getMonthValue()] += sales.get(i).getTotalPrice();
        }
        return salesPerMonth;
    }

    /**
     * Method that returns a Pair (Product,quantity)
     * formed by the product passed by parameter and the quantity sold thereof
     *
     * @param aProduct The product that you want to know the quantity sold
     * @return
     */
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

    /**
     * Method that returns a list of pairs (Product, quantity) which indicates
     * for each product the quantity of units sold.
     *
     * @return A list of pairs (Product,quantity)
     * which indicates for each product the quantity of units sold.
     */
    public ArrayList<Pair> totalQuantitySoldPerProduct() {
        ArrayList<Pair> returnList = new ArrayList<>();
        for (int i = 0; i < sales.size(); i++) {
            Sale actualSale = sales.get(i);
            for (int j = 0; j < actualSale.getPurchasedProducts().size(); j++) {
                Pair aPair = totalSaleByProduct((Product) actualSale.getPurchasedProducts().get(j).getKey());
                if (!returnList.contains(aPair)) {
                    returnList.add(aPair);
                }
            }
        }
        return returnList;
    }

    /**
     * Method that returns a Pair (Product, quantity) whit the most selled
     * product.
     *
     * @return A pair (Product, quantity) with the most selled product.
     */
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

    /**
     * Method that returns an array, in position 0 the quantity of organic
     * products sold and in position 1 the quantity of inorganic products sold.
     *
     * @return An array, in position 0 the quantity of organic products sold and
     * in position 1 the quantity of inorganic products sold.
     */
    public int[] quantityOfOrganicProductsSold() {
        //In position 0 put the organics and in 1 the inorganics.
        int[] organicAndInorganic = new int[2];
        ArrayList<Pair> list = totalQuantitySoldPerProduct();
        for (int i = 0; i < list.size(); i++) {
            Product aProduct = (Product) list.get(i).getKey();
            int quantity = (int) list.get(i).getValue();
            if (aProduct.isOrganic()) {
                organicAndInorganic[0] += quantity;
            } else {
                organicAndInorganic[1] += quantity;
            }
        }
        return organicAndInorganic;
    }

    /**
     * Method that returns a product that has the name passed by parameter.
     *
     * @param name Name of the product you want to obtain.
     * @return The product that has the name passed by parameter.
     */
    public Product getProductsByName(String name) {
        for (int i = 0; i < products.size(); i++) {
            Product currentProduct = products.get(i);
            if (currentProduct.getName() == null ? name == null : currentProduct.getName().equals(name)) {
                return currentProduct;
            }
        }
        return null;
    }

    /**
     * Method that returns a package that has the name passed by parameter.
     *
     * @param name Name of the package you want to obtain.
     * @return The package that has the name passed by parameter.
     */
    public Package getPackageByName(String name) {
        for (int i = 0; i < packagesList.size(); i++) {
            Package currentPackage = packagesList.get(i);
            if (currentPackage.getName() == null ? name == null : currentPackage.getName().equals(name)) {
                return currentPackage;
            }
        }
        return null;
    }

    /**
     * Method that returns the number of times the package passed by parameter
     * is reused.
     *
     * @param aPackage The package you want to know how many times it was used
     * @return The number of times the package passed by parameter is reused.
     */
    public int totalPerPackage(Package aPackage) {
        int quantity = 0;
        for (int i = 0; i < sales.size(); i++) {
            ArrayList<domain.Package> usedPackages = sales.get(i).getPackagesUsed();
            for (int j = 0; j < usedPackages.size(); j++) {
                if (usedPackages.get(j).getName().equals(aPackage.getName())) {
                    quantity++;
                }
            }
        }
        return quantity;
    }

    /**
     * Method that returns the total sales of the point of sale passed by
     * parameter.
     *
     * @param aPointOfSale The point of sale you want to know the total sales.
     * @return The total sales of the point of sale passed by parameter.
     */
    public int totalSalesPerPointOfSale(PointOfSale aPointOfSale) {
        int totalQuantity = 0;
        for (int i = 0; i < sales.size(); i++) {
            Sale currentSale = sales.get(i);
            if (currentSale.getShopPlace().getName().equals(aPointOfSale.getName())) {
                totalQuantity += sales.get(i).obtainPrice();
            }
        }
        return totalQuantity;
    }

    /**
     * Method that returns a list of pairs, (Point of sale, quantity) with the
     * total sales of each point of sale.
     *
     * @return A list of pairs, (Point of sale, quantity) with the total sales
     * of each point of sale.
     */
    public ArrayList<Pair> salesListPerPointOfSale() {
        ArrayList<Pair> returnList = new ArrayList<>();
        for (int i = 0; i < salePoints.size(); i++) {
            PointOfSale currentPointOfSale = salePoints.get(i);
            int quantity = totalSalesPerPointOfSale(currentPointOfSale);
            Pair pairToAdd = new Pair(currentPointOfSale, quantity);
            returnList.add(pairToAdd);
        }
        return returnList;
    }

    /**
     * Method that returns a list of pairs, (Package,quantity) with the number
     * of thimes each package was reused.
     *
     * @return A list of pairs, (Package,quantity)
     * with the number of times each package was reused.
     */
    public ArrayList<Pair> totalUsedPackages() {
        ArrayList<Pair> returnList = new ArrayList<>();
        for (int i = 0; i < packagesList.size(); i++) {
            int quantity = totalPerPackage(packagesList.get(i));
            Pair pairToAdd = new Pair(packagesList.get(i), quantity);
            returnList.add(pairToAdd);
        }
        return returnList;
    }

    /**
     * Method that returns a pair (Package, quantity) with the most used
     * package.
     *
     * @return The most used package.
     */
    public Pair mostUsedPackage() {
        ArrayList<Pair> totalPerPackage = totalUsedPackages();
        int maximum = -1;
        Pair returnPair = new Pair(new domain.Package(), maximum);
        for (int i = 0; i < totalUsedPackages().size(); i++) {
            Pair currentPair = totalUsedPackages().get(i);
            int quantity = (int) currentPair.getValue();
            if (quantity > maximum) {
                maximum = quantity;
                returnPair = currentPair;
            }
        }
        return returnPair;
    }

    /**
     * Method thats returns the quantity of pre-sales in the system.
     *
     * @return The quantity of pre-sales in the system.
     */
    public int quantityOfPreSales() {
        int quantityOfPreSales = 0;
        for (int i = 0; i < sales.size(); i++) {
            if (sales.get(i).isIsPreSale()) {
                quantityOfPreSales++;
            }
        }
        return quantityOfPreSales;
    }

}
