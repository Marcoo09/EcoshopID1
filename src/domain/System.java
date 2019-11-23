package domain;

import java.util.ArrayList;
import javafx.util.Pair;

/**
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

    public boolean isIsInPreSaleMode() {
        return isInPreSaleMode;
    }

    public void setIsInPreSaleMode(boolean isInPreSaleMode) {
        this.isInPreSaleMode = isInPreSaleMode;
    }

    public ArrayList<Sale> getPreSales() {
        return preSales;
    }

    public void addPreSale(Sale aSale) {
        this.preSales.add(aSale);
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Package> getPackagesList() {
        return packagesList;
    }

    public ArrayList<PointOfSale> getSalePoints() {
        return salePoints;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public void setClient(Client aClient) {
        client = aClient;
    }

    public void addPackage(Package aPackage) {
        packagesList.add(aPackage);
    }

    public void addSalePoint(PointOfSale aSalePoint) {
        salePoints.add(aSalePoint);
    }

    public void addProduct(Product aProduct) {
        products.add(aProduct);
    }

    public void addSale(Sale aSale) {
        sales.add(aSale);
    }

    public int[] salesPerMonth() {
        int[] salesPerMonth = new int[13];
        for (int i = 0; i < sales.size(); i++) {
            salesPerMonth[sales.get(i).getPurchaseDate().getMonthValue()] += sales.get(i).getTotalPrice();
        }
        return salesPerMonth;
    }

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

    public Product getProductsByName(String name) {
        for (int i = 0; i < products.size(); i++) {
            Product currentProduct = products.get(i);
            if (currentProduct.getName() == name) {
                return currentProduct;
            }
        }
        return null;
    }

    public Package getPackageByName(String name) {
        for (int i = 0; i < packagesList.size(); i++) {
            Package currentPackage = packagesList.get(i);
            if (currentPackage.getName() == name) {
                return currentPackage;
            }
        }
        return null;
    }

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

    public int totalSalesPerPointOfSale(PointOfSale aPointOfSale) {
        int totalQuantity = 0;
        for (int i = 0; i < sales.size(); i++) {
            Sale currentSale = sales.get(i);
            if (currentSale.getShopPlace().getName().equals(aPointOfSale.getName())) {
                totalQuantity = totalQuantity + sales.get(i).obtainPrice();
            }
        }
        return totalQuantity;
    }

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

    public ArrayList<Pair> totalUsedPackages() {
        ArrayList<Pair> returnList = new ArrayList<>();
        for (int i = 0; i < packagesList.size(); i++) {
            int quantity = totalPerPackage(packagesList.get(i));
            Pair pairToAdd = new Pair(packagesList.get(i), quantity);
            returnList.add(pairToAdd);
        }
        return returnList;
    }

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
