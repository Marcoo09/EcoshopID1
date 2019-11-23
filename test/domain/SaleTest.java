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
public class SaleTest {

    private Sale aSale;

    public SaleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        aSale = new Sale();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getClient method, of class Sale.
     */
    @Test
    public void testGetClient() {
        Client expect = new Client("Luis", "Perez", "1223232", "24305678", "1");
        aSale.setClient(expect);
        assertEquals(expect, aSale.getClient());
    }

    /**
     * Test of setClient method, of class Sale.
     */
    @Test
    public void testSetClient() {
        Client expect = new Client("Raul", "Rodriguez", "23433434", "29078902", "3");
        aSale.setClient(expect);
        assertEquals(expect, aSale.getClient());
    }

    /**
     * Test of isIsPreSale method, of class Sale.
     */
    @Test
    public void testIsIsPreSale() {
        boolean expected = true;
        aSale.setIsPreSale(true);
        assertEquals(expected, aSale.isIsPreSale());
    }

    /**
     * Test of isIsPreSale method, of class Sale.
     */
    @Test
    public void testIsIsPreSale2() {
        boolean expected = false;
        aSale.setIsPreSale(false);
        assertEquals(expected, aSale.isIsPreSale());
    }

    /**
     * Test of setIsPreSale method, of class Sale.
     */
    @Test
    public void testSetIsPreSale() {
        boolean expected = true;
        aSale.setIsPreSale(expected);
        assertEquals(expected, aSale.isIsPreSale());
    }

    /**
     * Test of setIsPreSale method, of class Sale.
     */
    @Test
    public void testSetIsPreSale2() {
        boolean expected = false;
        aSale.setIsPreSale(expected);
        assertEquals(expected, aSale.isIsPreSale());
    }

    /**
     * Test of getPurchasedProducts method, of class Sale. Case : Empty list.
     */
    @Test
    public void testGetPurchasedProducts() {
        ArrayList<Product> expected = new ArrayList<>();
        assertEquals(expected, aSale.getPurchasedProducts());
    }

    /**
     * Test of getPurchasedProducts method, of class Sale. Case : Empty list.
     */
    @Test
    public void testGetPurchasedProducts2() {
        ArrayList<Pair> expected = new ArrayList<>();
        Product aProduct = new Product("Uruguay", true, false, 120, "No aplica", 1, "Almendras");
        int quantity = 2;
        Pair expectedPair = new Pair(aProduct, quantity);
        aSale.addProductToCart(expectedPair);
        expected.add(expectedPair);
        assertEquals(expected, aSale.getPurchasedProducts());
    }

    /**
     * Test of getProduct method, of class Sale.
     */
    @Test
    public void testGetProduct() {
        Product aProduct = new Product("Uruguay", true, false, 120, "No aplica", 1, "Almendras");
        int quantity = 3;
        Pair expected = new Pair(aProduct, quantity);
        aSale.addProductToCart(expected);
        assertEquals(expected, aSale.getProduct(aProduct));
    }

    /**
     * Test of getProduct method, of class Sale.
     */
    @Test
    public void testGetProduct2() {
        Product aProduct = new Product("Uruguay", true, false, 120, "No aplica", 1, "Almendras");
        Product aProduct2 = new Product("Brasil", true, false, 180, "No aplica", 1, "Nueces");
        Pair pair1 = new Pair(aProduct, 3);
        Pair expected = new Pair(aProduct2, 4);
        aSale.addProductToCart(pair1);
        aSale.addProductToCart(expected);
        assertEquals(expected, aSale.getProduct(aProduct2));
    }

    /**
     * Test of pertain method, of class Sale.
     */
    @Test
    public void testPertain() {
        Product aProduct = new Product("Uruguay", true, false, 120, "No aplica", 1, "Almendras");
        Pair productPair = new Pair(aProduct, 2);
        aSale.addProductToCart(productPair);
        boolean expect = true;
        boolean result = aSale.pertain(aProduct);
        assertEquals(expect, result);
    }

    /**
     * Test of pertain method, of class Sale.
     */
    @Test
    public void testPertain2() {
        Product aProduct = new Product("Uruguay", true, false, 120, "No aplica", 1, "Almendras");
        Product aProduct2 = new Product("Brasil", true, false, 180, "No aplica", 2, "Nueces");
        Pair productPair = new Pair(aProduct, 2);
        aSale.addProductToCart(productPair);
        boolean expect = false;
        boolean result = aSale.pertain(aProduct2);
        assertEquals(expect, result);
    }

    /**
     * Test of addProductToCart method, of class Sale.
     */
    @Test
    public void testAddProductToCart() {
        Product aProduct = new Product("Uruguay", true, false, 120, "No aplica", 1, "Almendras");
        Pair pairToAdd = new Pair(aProduct, 3);
        ArrayList<Pair> expect = new ArrayList<>();
        expect.add(pairToAdd);
        aSale.addProductToCart(pairToAdd);
        assertEquals(expect, aSale.getPurchasedProducts());
    }

    /**
     * Test of removeProductOfCart method, of class Sale.
     */
    @Test
    public void testRemoveProductOfCart() {
        Product aProduct = new Product("Uruguay", true, false, 120, "No aplica", 1, "Almendras");
        Pair pairToAdd = new Pair(aProduct, 3);
        ArrayList<Pair> expect = new ArrayList<>();
        expect.add(pairToAdd);
        aSale.addProductToCart(pairToAdd);
        expect.remove(pairToAdd);
        aSale.removeProductOfCart(pairToAdd);
        assertEquals(expect, aSale.getPurchasedProducts());
    }

    /**
     * Test of getShopPlace method, of class Sale.
     */
    @Test
    public void testGetShopPlace() {
        PointOfSale expected = new PointOfSale("Montevideo", "La Molienda", "Venta de productos organicos");
        aSale.setShopPlace(expected);
        assertEquals(expected, aSale.getShopPlace());
    }

    /**
     * Test of setShopPlace method, of class Sale.
     */
    @Test
    public void testSetShopPlace() {
        PointOfSale expected = new PointOfSale("Montevideo", "La Molienda", "Venta de productos organicos");
        aSale.setShopPlace(expected);
        assertEquals(expected, aSale.getShopPlace());
    }

    /**
     * Test of getTotalPrice method, of class Sale.
     */
    @Test
    public void testGetTotalPrice() {
        int expect = 1000;
        aSale.setTotalPrice(expect);
        assertEquals(expect, aSale.getTotalPrice());
    }

    /**
     * Test of setTotalPrice method, of class Sale.
     */
    @Test
    public void testSetTotalPrice() {
        int expect = 300;
        aSale.setTotalPrice(expect);
        assertEquals(expect, aSale.getTotalPrice());
    }

    /**
     * Test of obtainPrice method, of class Sale.
     */
    @Test
    public void testObtainPrice() {
        Product aProduct = new Product("Uruguay", true, false, 120, "No aplica", 1, "Almendras");
        Pair pairToAdd = new Pair(aProduct, 3);
        aSale.addProductToCart(pairToAdd);
        int expect = 360;
        int result = aSale.obtainPrice();
        assertEquals(expect, result);
    }

    /**
     * Test of obtainPrice method, of class Sale.
     */
    @Test
    public void testObtainPrice2() {
        int expect = 0;
        int result = aSale.obtainPrice();
        assertEquals(expect, result);
    }

    /**
     * Test of obtainPrice method, of class Sale.
     */
    @Test
    public void testObtainPrice3() {
        Product aProduct = new Product("Uruguay", true, false, 120, "No aplica", 1, "Almendras");
        Product aProduct2 = new Product("Brasil", true, false, 150, "No aplica", 1, "Nueces");
        Pair pairToAdd = new Pair(aProduct, 3);
        Pair pairToAdd2 = new Pair(aProduct2, 2);
        aSale.addProductToCart(pairToAdd);
        aSale.addProductToCart(pairToAdd2);
        int expect = 660;
        int result = aSale.obtainPrice();
        assertEquals(expect, result);
    }

    /**
     * Test of getTicketNumber method, of class Sale.
     */
    @Test
    public void testGetTicketNumber() {
        String expect = "AVO106017";
        aSale.setTicketNumber(expect);
        assertEquals(expect, aSale.getTicketNumber());
    }

    /**
     * Test of setTicketNumber method, of class Sale.
     */
    @Test
    public void testSetTicketNumber() {
        String expect = "BCA10232";
        aSale.setTicketNumber(expect);
        assertEquals(expect, aSale.getTicketNumber());
    }

    /**
     * Test of getFullPayment method, of class Sale.
     */
    @Test
    public void testGetFullPayment() {
        int expect = 700;
        aSale.setFullPayment(expect);
        assertEquals(expect, aSale.getFullPayment());
    }

    /**
     * Test of getPurchaseDate method, of class Sale.
     */
    @Test
    public void testGetPurchaseDate() {
        LocalDate expect = LocalDate.of(2019, 04, 13);
        aSale.setPurchaseDate(expect);
        assertEquals(expect, aSale.getPurchaseDate());
    }

    /**
     * Test of setPurchaseDate method, of class Sale.
     */
    @Test
    public void testSetPurchaseDate() {
        LocalDate expect = LocalDate.now();
        aSale.setPurchaseDate(expect);
        assertEquals(expect, aSale.getPurchaseDate());
    }

    /**
     * Test of setFullPayment method, of class Sale.
     */
    @Test
    public void testSetFullPayment() {
        int expect = 300;
        aSale.setFullPayment(expect);
        assertEquals(expect, aSale.getFullPayment());
    }

    /**
     * Test of getChange method, of class Sale.
     */
    @Test
    public void testGetChange() {
        int expect = 300;
        aSale.setChange(expect);
        assertEquals(expect, aSale.getChange());
    }

    /**
     * Test of setChange method, of class Sale.
     */
    @Test
    public void testSetChange() {
        int expect = 175;
        aSale.setChange(expect);
        assertEquals(expect, aSale.getChange());
    }

    /**
     * Test of getPackagesUsed method, of class Sale. Case: Empty list.
     */
    @Test
    public void testGetPackagesUsed() {
        ArrayList<domain.Package> expect = new ArrayList<>();
        assertEquals(expect, aSale.getPackagesUsed());
    }

    /**
     * Test of getPackagesUsed method, of class Sale. Case: List with one
     * element.
     */
    @Test
    public void testGetPackagesUsed2() {
        ArrayList<domain.Package> expect = new ArrayList<>();
        domain.Package aPackage = new domain.Package("Tupper", "Plastico", 50);
        expect.add(aPackage);
        aSale.addUsedPackage(aPackage);
        assertEquals(expect, aSale.getPackagesUsed());
    }

    /**
     * Test of addUsedPackage method, of class Sale.
     */
    @Test
    public void testAddUsedPackage() {
        ArrayList<domain.Package> expect = new ArrayList<>();
        domain.Package aPackage = new domain.Package("Frasco", "Vidrio", 150);
        expect.add(aPackage);
        aSale.addUsedPackage(aPackage);
        assertEquals(expect, aSale.getPackagesUsed());
    }

    /**
     * Test of removeUsedPackage method, of class Sale.
     */
    @Test
    public void testRemoveUsedPackage() {
        ArrayList<domain.Package> expect = new ArrayList<>();
        domain.Package aPackage = new domain.Package("Frasco", "Vidrio", 150);
        expect.add(aPackage);
        aSale.addUsedPackage(aPackage);
        expect.remove(aPackage);
        aSale.removeUsedPackage(aPackage);
        assertEquals(expect, aSale.getPackagesUsed());
    }

}
