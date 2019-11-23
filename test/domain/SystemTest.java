/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.util.Pair;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Agustin Hernandorena
 */
public class SystemTest {

    private System mySystem;

    public SystemTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        mySystem = new System();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPreSales method, of class System. Case: Empty list.
     */
    @Test
    public void testGetPreSales() {
        ArrayList<Sale> expect = new ArrayList<>();
        assertEquals(expect, mySystem.getPreSales());
    }

    /**
     * Test of getPreSales method, of class System. Case: Lis with one element.
     */
    @Test
    public void testGetPreSales2() {
        ArrayList<Sale> expect = new ArrayList<>();
        PointOfSale shopPlace = new PointOfSale("Montevideo", "La Molienda", "Tienda");
        Sale saleToAdd = new Sale(shopPlace, "AVO1234", 1000, 790);
        expect.add(saleToAdd);
        mySystem.addPreSale(saleToAdd);
        assertEquals(expect, mySystem.getPreSales());
    }

    /**
     * Test of addPreSale method, of class System.
     */
    @Test
    public void testAddPreSale() {
        ArrayList<Sale> expect = new ArrayList<>();
        PointOfSale shopPlace = new PointOfSale("Montevideo", "La Molienda", "Tienda");
        Sale saleToAdd = new Sale(shopPlace, "12567", 1100, 530);
        expect.add(saleToAdd);
        mySystem.addPreSale(saleToAdd);
        assertEquals(expect, mySystem.getPreSales());
    }

    /**
     * Test of getClient method, of class System.
     */
    @Test
    public void testGetClient() {
        Client expect = new Client("Luis", "Perez", "5678934", "29045678", "1");
        mySystem.setClient(expect);
        assertEquals(expect, mySystem.getClient());
    }

    /**
     * Test of getPackagesList method, of class System. Case: Empty list.
     */
    @Test
    public void testGetPackagesList() {
        ArrayList<Package> expect = new ArrayList<>();
        assertEquals(expect, mySystem.getPackagesList());
    }

    /**
     * Test of getPackagesList method, of class System. Case: List with one
     * element.
     */
    @Test
    public void testGetPackagesList2() {
        ArrayList<Package> expect = new ArrayList<>();
        Package aPackage = new Package("Tupper", "Plastico", 200);
        expect.add(aPackage);
        mySystem.addPackage(aPackage);
        assertEquals(expect, mySystem.getPackagesList());
    }

    /**
     * Test of getSalePoints method, of class System. Case: Empty list.
     */
    @Test
    public void testGetSalePoints() {
        ArrayList<PointOfSale> expect = new ArrayList<>();
        assertEquals(expect, mySystem.getSalePoints());
    }

    /**
     * Test of getSalePoints method, of class System. Case: List with one
     * element.
     */
    @Test
    public void testGetSalePoints2() {
        PointOfSale shopPlace = new PointOfSale("Montevideo", "La Molienda", "Tienda");
        ArrayList<PointOfSale> expect = new ArrayList<>();
        expect.add(shopPlace);
        mySystem.addSalePoint(shopPlace);
        assertEquals(expect, mySystem.getSalePoints());
    }

    /**
     * Test of getProducts method, of class System. Case: Empty list.
     */
    @Test
    public void testGetProducts() {
        ArrayList<Product> expect = new ArrayList<>();
        assertEquals(expect, mySystem.getProducts());
    }

    /**
     * Test of getProducts method, of class System. Case: List whit one element.
     */
    @Test
    public void testGetProducts2() {
        Product aProduct = new Product("Uruguay", true, false, 1200, "No aplica", 1, "Nueces");
        ArrayList<Product> expect = new ArrayList<>();
        expect.add(aProduct);
        mySystem.addProduct(aProduct);
        assertEquals(expect, mySystem.getProducts());
    }

    /**
     * Test of getSales method, of class System. Case: Empty list.
     */
    @Test
    public void testGetSales() {
        ArrayList<Sale> expect = new ArrayList<>();
        assertEquals(expect, mySystem.getSales());
    }

    /**
     * Test of getSales method, of class System. Case: List with one element.
     */
    @Test
    public void testGetSales2() {
        PointOfSale shopPlace = new PointOfSale("Canelones", "El granero", "Tienda");
        Sale saleToAdd = new Sale(shopPlace, "BCF1235", 1000, 500);
        ArrayList<Sale> expect = new ArrayList<>();
        expect.add(saleToAdd);
        mySystem.addSale(saleToAdd);
        assertEquals(expect, mySystem.getSales());
    }

    /**
     * Test of setClient method, of class System.
     */
    @Test
    public void testSetClient() {
        Client expect = new Client("Luisa", "Rodriguez", "45678945", "24056789", "3");
        mySystem.setClient(expect);
        assertEquals(expect, mySystem.getClient());
    }

    /**
     * Test of addPackage method, of class System.
     */
    @Test
    public void testAddPackage() {
        ArrayList<Package> expect = new ArrayList<>();
        Package aPackage = new Package("Tupper", "Plastico", 200);
        expect.add(aPackage);
        mySystem.addPackage(aPackage);
        assertEquals(expect, mySystem.getPackagesList());
    }

    /**
     * Test of addSalePoint method, of class System.
     */
    @Test
    public void testAddSalePoint() {
        PointOfSale shopPlace = new PointOfSale("Montevideo", "La Molienda", "Tienda");
        ArrayList<PointOfSale> expect = new ArrayList<>();
        expect.add(shopPlace);
        mySystem.addSalePoint(shopPlace);
        assertEquals(expect, mySystem.getSalePoints());
    }

    /**
     * Test of addProduct method, of class System.
     */
    @Test
    public void testAddProduct() {
        Product aProduct = new Product("Uruguay", true, false, 1200, "No aplica", 1, "Nueces");
        ArrayList<Product> expect = new ArrayList<>();
        expect.add(aProduct);
        mySystem.addProduct(aProduct);
        assertEquals(expect, mySystem.getProducts());
    }

    /**
     * Test of addSale method, of class System.
     */
    @Test
    public void testAddSale() {
        ArrayList<Sale> expect = new ArrayList<>();
        PointOfSale shopPlace = new PointOfSale("Maldonado", "El granero", "Tienda");
        Sale saleToAdd = new Sale(shopPlace, "AVO9023", 1100, 990);
        expect.add(saleToAdd);
        mySystem.addSale(saleToAdd);
        assertEquals(expect, mySystem.getSales());
    }

    /**
     * Test of salesPerMonth method, of class System.
     */
    @Test
    public void testSalesPerMonth() {
        int[] salesPerMonth = new int[13];
        PointOfSale shopPlace = new PointOfSale("Maldonado", "El granero", "Tienda");
        Sale saleToAdd = new Sale(shopPlace, "AVO9023", 1100, 990);
        saleToAdd.setPurchaseDate(LocalDate.of(2019, 5, 12));
        Sale saleToAdd2 = new Sale(shopPlace, "AVO930", 1200, 1100);
        saleToAdd2.setPurchaseDate(LocalDate.of(2019, 1, 20));
        mySystem.addSale(saleToAdd);
        mySystem.addSale(saleToAdd2);
        int[] expect = {0, 1100, 0, 0, 0, 990, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expect, mySystem.salesPerMonth());
    }

    /**
     * Test of totalSaleByProduct method, of class System.
     */
    @Test
    public void testTotalSaleByProduct() {
        Sale s1 = new Sale();
        Product aProduct1 = new Product("Uruguay", true, true, 150, "No aplica", 1, "Nueces");
        Pair pairToAdd = new Pair(aProduct1, 3);
        Pair pairToAdd2 = new Pair(aProduct1, 5);
        s1.addProductToCart(pairToAdd);
        s1.addProductToCart(pairToAdd2);
        mySystem.addSale(s1);
        Pair expect = new Pair(aProduct1, 8);
        assertEquals(expect, mySystem.totalSaleByProduct(aProduct1));
    }

    /**
     * Test of totalSaleByProduct method, of class System.
     */
    @Test
    public void testTotalSaleByProduct2() {
        Sale s1 = new Sale();
        Product aProduct1 = new Product("Uruguay", true, true, 150, "No aplica", 1, "Nueces");
        Product aProduct2 = new Product("Uruguay", true, true, 180, "No aplica", 2, "Almendras");
        Pair pairToAdd = new Pair(aProduct1, 3);
        Pair pairToAdd2 = new Pair(aProduct2, 5);
        s1.addProductToCart(pairToAdd);
        s1.addProductToCart(pairToAdd2);
        mySystem.addSale(s1);
        Pair expect = new Pair(aProduct2, 5);
        assertEquals(expect, mySystem.totalSaleByProduct(aProduct2));
    }

    /**
     * Test of totalQuantitySoldPerProduct method, of class System.
     */
    @Test
    public void testTotalQuantitySoldPerProduct() {
        Sale s1 = new Sale();
        Sale s2 = new Sale();
        Product aProduct1 = new Product("Uruguay", true, true, 150, "No aplica", 1, "Nueces");
        Product aProduct2 = new Product("Uruguay", true, true, 180, "No aplica", 2, "Almendras");
        Product aProduct3 = new Product("Brasil", true, true, 200, "No aplica", 3, "Castanas");
        Pair pairToAdd = new Pair(aProduct1, 3);
        Pair pairToAdd2 = new Pair(aProduct2, 5);
        Pair pairToAdd3 = new Pair(aProduct1, 2);
        s1.addProductToCart(pairToAdd);
        s1.addProductToCart(pairToAdd2);
        s2.addProductToCart(pairToAdd3);
        mySystem.addSale(s1);
        mySystem.addSale(s2);
        ArrayList<Pair> expect = new ArrayList<>();
        expect.add(new Pair(aProduct1, 5));
        expect.add(new Pair(aProduct2, 5));
        assertEquals(expect, mySystem.totalQuantitySoldPerProduct());
    }

    /**
     * Test of mostSelledProduct method, of class System.
     */
    @Test
    public void testMostSelledProduct() {
        Sale s1 = new Sale();
        Sale s2 = new Sale();
        Product aProduct1 = new Product("Uruguay", true, true, 150, "No aplica", 1, "Nueces");
        Product aProduct2 = new Product("Uruguay", true, true, 180, "No aplica", 2, "Almendras");
        Product aProduct3 = new Product("Brasil", true, true, 200, "No aplica", 3, "Castanas");
        Pair pairToAdd = new Pair(aProduct1, 3);
        Pair pairToAdd2 = new Pair(aProduct2, 5);
        Pair pairToAdd3 = new Pair(aProduct1, 3);
        s1.addProductToCart(pairToAdd);
        s1.addProductToCart(pairToAdd2);
        s2.addProductToCart(pairToAdd3);
        mySystem.addSale(s1);
        mySystem.addSale(s2);
        Pair expect = new Pair(aProduct1, 6);
        assertEquals(expect, mySystem.mostSelledProduct());
    }

    /**
     * Test of quantityOfOrganicProductsSold method, of class System.
     */
    @Test
    public void testQuantityOfOrganicProductsSold() {
        Sale s1 = new Sale();
        Sale s2 = new Sale();
        Product aProduct1 = new Product("Uruguay", true, true, 150, "No aplica", 1, "Nueces");
        Product aProduct2 = new Product("Uruguay", false, true, 180, "No aplica", 2, "Almendras");
        Product aProduct3 = new Product("Brasil", false, true, 200, "No aplica", 3, "Castanas");
        Pair pairToAdd = new Pair(aProduct1, 3);
        Pair pairToAdd2 = new Pair(aProduct2, 5);
        Pair pairToAdd3 = new Pair(aProduct1, 3);
        s1.addProductToCart(pairToAdd);
        s1.addProductToCart(pairToAdd2);
        s2.addProductToCart(pairToAdd3);
        mySystem.addSale(s1);
        mySystem.addSale(s2);
        int[] expect = {6, 5};
        assertArrayEquals(expect, mySystem.quantityOfOrganicProductsSold());
    }

    /**
     * Test of getProductsByName method, of class System.
     */
    @Test
    public void testGetProductsByName() {
        Product expect = new Product("Uruguay", true, true, 150, "No aplica", 1, "Nueces");
        mySystem.addProduct(expect);
        assertEquals(expect, mySystem.getProductsByName("Nueces"));
    }

    /**
     * Test of getProductsByName method, of class System.
     */
    @Test
    public void testGetProductsByName2() {
        Product aProduct = new Product("Uruguay", false, true, 180, "No aplica", 2, "Almendras");
        Product expect = new Product("Uruguay", true, true, 150, "No aplica", 1, "Nueces");
        mySystem.addProduct(aProduct);
        mySystem.addProduct(expect);
        assertEquals(expect, mySystem.getProductsByName("Nueces"));
    }

    /**
     * Test of getPackageByName method, of class System.
     */
    @Test
    public void testGetPackageByName() {
        Package expect = new Package("Tupper", "Plastico", 150);
        mySystem.addPackage(expect);
        assertEquals(expect, mySystem.getPackageByName("Tupper"));
    }

    /**
     * Test of getPackageByName method, of class System.
     */
    @Test
    public void testGetPackageByName2() {
        Package aPackage = new Package("Frasco", "Vidrio", 250);
        Package expect = new Package("Tupper", "Plastico", 150);
        mySystem.addPackage(aPackage);
        mySystem.addPackage(expect);
        assertEquals(expect, mySystem.getPackageByName("Tupper"));
    }

    /**
     * Test of totalPerPackage method, of class System.
     */
    @Test
    public void testTotalPerPackage() {
        Sale s1 = new Sale();
        Product aProduct1 = new Product("Uruguay", true, true, 150, "No aplica", 1, "Nueces");
        Product aProduct2 = new Product("Uruguay", true, true, 180, "No aplica", 2, "Almendras");
        Product aProduct3 = new Product("Brasil", true, true, 200, "No aplica", 3, "Castanas");
        Package aPackage = new Package("Tupper", "Plastico", 170);
        Package aPackage2 = new Package("Frasco", "Vidrio", 170);
        Pair pairToAdd = new Pair(aProduct1, 3);
        Pair pairToAdd2 = new Pair(aProduct2, 5);
        Pair pairToAdd3 = new Pair(aProduct3, 3);
        s1.addProductToCart(pairToAdd);
        s1.addProductToCart(pairToAdd2);
        s1.addUsedPackage(aPackage2);
        s1.addUsedPackage(aPackage);
        s1.addUsedPackage(aPackage);
        mySystem.addSale(s1);
        int expect = 2;
        assertEquals(expect, mySystem.totalPerPackage(aPackage));
    }

    /**
     * Test of totalSalesPerPointOfSale method, of class System.
     */
    @Test
    public void testTotalSalesPerPointOfSale() {
        Sale s1 = new Sale();
        Product aProduct1 = new Product("Uruguay", true, true, 150, "No aplica", 1, "Nueces");
        Product aProduct2 = new Product("Uruguay", true, true, 180, "No aplica", 2, "Almendras");
        Product aProduct3 = new Product("Brasil", true, true, 200, "No aplica", 3, "Castanas");
        Package aPackage = new Package("Tupper", "Plastico", 170);
        Package aPackage2 = new Package("Frasco", "Vidrio", 170);
        Pair pairToAdd = new Pair(aProduct1, 3);
        Pair pairToAdd2 = new Pair(aProduct2, 5);
        Pair pairToAdd3 = new Pair(aProduct3, 3);
        PointOfSale aPointOfSale1 = new PointOfSale("Montevideo", "La Molienda", "Tienda");
        s1.addProductToCart(pairToAdd);
        s1.addProductToCart(pairToAdd2);
        s1.addProductToCart(pairToAdd3);
        s1.setShopPlace(aPointOfSale1);
        mySystem.addSale(s1);
        int expect = 1950;
        assertEquals(expect, mySystem.totalSalesPerPointOfSale(aPointOfSale1));
    }

    /**
     * Test of totalSalesPerPointOfSale method, of class System.
     */
    @Test
    public void testTotalSalesPerPointOfSale2() {
        Sale s1 = new Sale();
        Sale s2 = new Sale();
        Product aProduct1 = new Product("Uruguay", true, true, 150, "No aplica", 1, "Nueces");
        Product aProduct2 = new Product("Uruguay", true, true, 180, "No aplica", 2, "Almendras");
        Product aProduct3 = new Product("Brasil", true, true, 200, "No aplica", 3, "Castanas");
        Package aPackage = new Package("Tupper", "Plastico", 170);
        Package aPackage2 = new Package("Frasco", "Vidrio", 170);
        Pair pairToAdd = new Pair(aProduct1, 3);
        Pair pairToAdd2 = new Pair(aProduct2, 5);
        Pair pairToAdd3 = new Pair(aProduct3, 3);
        PointOfSale aPointOfSale1 = new PointOfSale("Montevideo", "La Molienda", "Tienda");
        PointOfSale aPointOfSale2 = new PointOfSale("Canelones", "El granero", "Tienda");
        s1.addProductToCart(pairToAdd);
        s1.addProductToCart(pairToAdd2);
        s1.addProductToCart(pairToAdd3);
        s2.addProductToCart(pairToAdd3);
        s2.setShopPlace(aPointOfSale2);
        s1.setShopPlace(aPointOfSale1);
        mySystem.addSale(s1);
        mySystem.addSale(s2);
        int expect = 600;
        assertEquals(expect, mySystem.totalSalesPerPointOfSale(aPointOfSale2));
    }

    /**
     * Test of salesListPerPointOfSale method, of class System.
     */
    @Test
    public void testSalesListPerPointOfSale() {
        ArrayList<Pair> expect = new ArrayList<>();
        Sale s1 = new Sale();
        Sale s2 = new Sale();
        Product aProduct1 = new Product("Uruguay", true, true, 150, "No aplica", 1, "Nueces");
        Product aProduct2 = new Product("Uruguay", true, true, 180, "No aplica", 2, "Almendras");
        Product aProduct3 = new Product("Brasil", true, true, 200, "No aplica", 3, "Castanas");
        Pair pairToAdd = new Pair(aProduct1, 3);
        Pair pairToAdd2 = new Pair(aProduct2, 5);
        Pair pairToAdd3 = new Pair(aProduct3, 3);
        PointOfSale aPointOfSale1 = new PointOfSale("Montevideo", "La Molienda", "Tienda");
        PointOfSale aPointOfSale2 = new PointOfSale("Canelones", "El granero", "Tienda");
        s1.addProductToCart(pairToAdd);
        s1.addProductToCart(pairToAdd2);
        s1.addProductToCart(pairToAdd3);
        s2.addProductToCart(pairToAdd3);
        s2.setShopPlace(aPointOfSale2);
        s1.setShopPlace(aPointOfSale1);
        Pair pair1 = new Pair(aPointOfSale1, 1950);
        Pair pair2 = new Pair(aPointOfSale2, 600);
        expect.add(pair2);
        expect.add(pair1);
        mySystem.addSale(s2);
        mySystem.addSale(s1);
        mySystem.addSalePoint(aPointOfSale2);
        mySystem.addSalePoint(aPointOfSale1);
        assertEquals(expect, mySystem.salesListPerPointOfSale());
    }

    /**
     * Test of totalUsedPackages method, of class System.
     */
    @Test
    public void testTotalUsedPackages() {
        ArrayList<Pair> expect = new ArrayList<>();
        Sale s1 = new Sale();
        Sale s2 = new Sale();
        Package p1 = new Package("Tupper", "Plastico", 170);
        Package p2 = new Package("Frasco", "Vidrio", 200);
        Package p3 = new Package("Botella", "Vidrio", 500);
        mySystem.addPackage(p1);
        mySystem.addPackage(p2);
        mySystem.addPackage(p3);
        s1.addUsedPackage(p1);
        s1.addUsedPackage(p2);
        s1.addUsedPackage(p3);
        s2.addUsedPackage(p1);
        s2.addUsedPackage(p2);
        Pair pair1 = new Pair(p1, 2);
        Pair pair2 = new Pair(p2, 2);
        Pair pair3 = new Pair(p3, 1);
        expect.add(pair1);
        expect.add(pair2);
        expect.add(pair3);
        mySystem.addSale(s1);
        mySystem.addSale(s2);
        assertEquals(expect, mySystem.totalUsedPackages());
    }

    /**
     * Test of mostUsedPackage method, of class System.
     */
    @Test
    public void testMostUsedPackage() {
        Sale s1 = new Sale();
        Sale s2 = new Sale();
        Package p1 = new Package("Tupper", "Plastico", 170);
        Package p2 = new Package("Frasco", "Vidrio", 200);
        Package p3 = new Package("Botella", "Vidrio", 500);
        mySystem.addPackage(p1);
        mySystem.addPackage(p2);
        mySystem.addPackage(p3);
        s1.addUsedPackage(p1);
        s1.addUsedPackage(p2);
        s1.addUsedPackage(p3);
        s1.addUsedPackage(p2);
        s2.addUsedPackage(p1);
        s2.addUsedPackage(p2);
        mySystem.addSale(s1);
        mySystem.addSale(s2);
        Pair expect = new Pair(p2, 3);
        assertEquals(expect, mySystem.mostUsedPackage());
    }

    /**
     * Test of quantityOfPreSales method, of class System.
     */
    @Test
    public void testQuantityOfPreSales() {
        Sale s1 = new Sale();
        Sale s2 = new Sale();
        Sale s3 = new Sale();
        s1.setIsPreSale(true);
        s2.setIsPreSale(true);
        mySystem.addSale(s1);
        mySystem.addSale(s2);
        mySystem.addSale(s3);
        int expect = 2;
        assertEquals(expect, mySystem.quantityOfPreSales());
    }

}
