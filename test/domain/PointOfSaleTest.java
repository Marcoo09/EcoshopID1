package domain;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Agustin Hernandorena
 */
public class PointOfSaleTest {


    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    private PointOfSale aPointOfSale;
    public PointOfSaleTest() {
    }

    @Before
    public void setUp() {
        aPointOfSale = new PointOfSale();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAddress method, of class PointOfSale.
     */
    @Test
    public void testGetAddress() {
        String expected = "Ejido 1203, Montevideo";
        aPointOfSale.setAddress(expected);
        assertEquals(expected, aPointOfSale.getAddress());
    }

    /**
     * Test of setAddress method, of class PointOfSale.
     */
    @Test
    public void testSetAddress() {
        String expected = "18 de Julio 1334, Montevideo";
        aPointOfSale.setAddress(expected);
        assertEquals(expected, aPointOfSale.getAddress());
    }

    /**
     * Test of getName method, of class PointOfSale.
     */
    @Test
    public void testGetName() {
        String expected = "La Molienda";
        aPointOfSale.setName(expected);
        assertEquals(expected, aPointOfSale.getName());
    }

    /**
     * Test of setName method, of class PointOfSale.
     */
    @Test
    public void testSetName() {
        String expected = "El granero";
        aPointOfSale.setName(expected);
        assertEquals(expected, aPointOfSale.getName());
    }

    /**
     * Test of getDescription method, of class PointOfSale.
     */
    @Test
    public void testGetDescription() {
        String expected = "Empresa que vende productos organicos";
        aPointOfSale.setDescription(expected);
        assertEquals(expected, aPointOfSale.getDescription());
    }

    /**
     * Test of setDescription method, of class PointOfSale.
     */
    @Test
    public void testSetDescription() {
        String expected = "Empresa destinada a la venta de productos ecologicos";
        aPointOfSale.setDescription(expected);
        assertEquals(expected, aPointOfSale.getDescription());
    }

    /**
     * Test of getProductsForSale method, of class PointOfSale. Boundary case:
     * Empty list.
     */
    @Test
    public void testGetProductsForSale() {
        ArrayList<Product> expected = new ArrayList<>();
        assertEquals(expected, aPointOfSale.getProductsForSale());
    }

    /**
     * Test of getProductsForSale method, of class PointOfSale. Boundary case:
     * Single item list.
     */
    @Test
    public void testGetProductsForSale2() {
        ArrayList<Product> expected = new ArrayList<>();
        Product aProduct = new Product("Uruguay", true, true, 150, "Madera", 2, "Cepillo");
        expected.add(aProduct);
        aPointOfSale.addProductForSale(aProduct);
        assertEquals(expected, aPointOfSale.getProductsForSale());
    }

    /**
     * Test of getProductsForSale method, of class PointOfSale. Case: List with
     * two elements.
     */
    @Test
    public void testGetProductsForSale3() {
        ArrayList<Product> expected = new ArrayList<>();
        Product aProduct1 = new Product("Uruguay", true, true, 150, "Madera", 2, "Cepillo");
        Product aProduct2 = new Product("Brasil", false, true, 200, "No aplica", 2, "Almendras");
        expected.add(aProduct1);
        expected.add(aProduct2);
        aPointOfSale.addProductForSale(aProduct1);
        aPointOfSale.addProductForSale(aProduct2);
        assertEquals(expected, aPointOfSale.getProductsForSale());
    }

    /**
     * Test of getProductsForSale method, of class PointOfSale. Case: Test if
     * the list contains a certain product.
     */
    @Test
    public void testContainProductsForSale() {
        Product aProduct1 = new Product("Uruguay", true, true, 150, "Madera", 2, "Cepillo");
        Product aProduct2 = new Product("Brasil", false, true, 200, "No aplica", 2, "Almendras");
        aPointOfSale.addProductForSale(aProduct1);
        boolean expected = false;
        boolean result = aPointOfSale.getProductsForSale().contains(aProduct2);
        assertEquals(expected, result);
    }

    /**
     * Test of getProductsForSale method, of class PointOfSale. Case: Test if
     * the list contains a certain product.
     */
    @Test
    public void testContainProductsForSale2() {
        Product aProduct1 = new Product("Uruguay", true, true, 150, "Madera", 2, "Cepillo");
        Product aProduct2 = new Product("Brasil", false, true, 200, "No aplica", 2, "Almendras");
        aPointOfSale.addProductForSale(aProduct1);
        boolean expected = true;
        boolean result = aPointOfSale.getProductsForSale().contains(aProduct1);
        assertEquals(expected, result);
    }

    /**
     * Test of getProductsForSale method, of class PointOfSale. Case: Test if
     * the list is empty.
     */
    @Test
    public void testIsEmptyProductsForSale() {
        Product aProduct1 = new Product("Uruguay", true, true, 150, "Madera", 2, "Cepillo");
        Product aProduct2 = new Product("Brasil", false, true, 200, "No aplica", 2, "Almendras");
        aPointOfSale.addProductForSale(aProduct1);
        boolean expected = false;
        boolean result = aPointOfSale.getProductsForSale().isEmpty();
        assertEquals(expected, result);
    }

    /**
     * Test of getProductsForSale method, of class PointOfSale. Case: Test if
     * the list is empty.
     */
    @Test
    public void testIsEmptyProductsForSale2() {
        boolean expected = true;
        boolean result = aPointOfSale.getProductsForSale().isEmpty();
        assertEquals(expected, result);
    }

    /**
     * Test of getSales method, of class PointOfSale. Boundary case: Empty list.
     */
    @Test
    public void testGetSales() {
        ArrayList<Sale> expected = new ArrayList<>();
        assertEquals(expected, aPointOfSale.getSales());
    }

    /**
     * Test of getSales method, of class PointOfSale. Boundary case: List with
     * one element.
     */
    @Test
    public void testGetSales2() {
        ArrayList<Sale> expected = new ArrayList<>();
        Sale aSale = new Sale(aPointOfSale, "1", 1200, 1000);
        aPointOfSale.addSale(aSale);
        expected.add(aSale);
        assertEquals(expected, aPointOfSale.getSales());
    }

    /**
     * Test of getSales method, of class PointOfSale. Boundary case: List with
     * two elements.
     */
    @Test
    public void testGetSales3() {
        ArrayList<Sale> expected = new ArrayList<>();
        Sale aSale = new Sale(aPointOfSale, "1", 1200, 1000);
        Sale aSale2 = new Sale(aPointOfSale, "2", 1400, 700);
        aPointOfSale.addSale(aSale);
        aPointOfSale.addSale(aSale2);
        expected.add(aSale);
        expected.add(aSale2);
        assertEquals(expected, aPointOfSale.getSales());
    }

    /**
     * Test of getSales method, of class PointOfSale. Test if sales list
     * contains a certain sale.
     */
    @Test
    public void testContainSales() {
        Sale aSale = new Sale(aPointOfSale, "1", 1200, 1000);
        Sale aSale2 = new Sale(aPointOfSale, "2", 1400, 700);
        aPointOfSale.addSale(aSale);
        boolean expected = false;
        boolean result = aPointOfSale.getSales().contains(aSale2);
        assertEquals(expected, result);
    }

    /**
     * Test of getSales method, of class PointOfSale. Test if sales list
     * contains a certain sale.
     */
    @Test
    public void testContainSales2() {
        Sale aSale = new Sale(aPointOfSale, "1", 1200, 1000);
        Sale aSale2 = new Sale(aPointOfSale, "2", 1400, 700);
        aPointOfSale.addSale(aSale);
        aPointOfSale.addSale(aSale2);
        boolean expected = true;
        boolean result = aPointOfSale.getSales().contains(aSale2);
        assertEquals(expected, result);
    }

    /**
     * Test of getSales method, of class PointOfSale. Test if sales list is
     * empty.
     */
    @Test
    public void testSaleListIsEmpty() {
        boolean expected = true;
        boolean result = aPointOfSale.getSales().isEmpty();
        assertEquals(expected, result);
    }

    /**
     * Test of getSales method, of class PointOfSale. Test if sales list is
     * empty.
     */
    @Test
    public void testSaleListIsEmpty2() {
        boolean expected = false;
        Sale aSale = new Sale(aPointOfSale, "1", 1200, 1000);
        aPointOfSale.addSale(aSale);
        boolean result = aPointOfSale.getSales().isEmpty();
        assertEquals(expected, result);
    }

    /**
     * Test of addSale method, of class PointOfSale.
     */
    @Test
    public void testAddSale() {
        Sale aSale = new Sale(aPointOfSale, "1", 1200, 1000);
        ArrayList<Sale> expected = aPointOfSale.getSales();
        expected.add(aSale);
        aPointOfSale.addSale(aSale);
        assertEquals(expected, aPointOfSale.getSales());
    }

    /**
     * Test of getSelledProducts method, of class PointOfSale. Boundary case:
     * Empty list
     *
     */
    @Test
    public void testGetSelledProducts() {
        ArrayList<Product> expect = new ArrayList<>();
        assertEquals(expect, aPointOfSale.getSelledProducts());
    }

    /**
     * Test of getSelledProducts method, of class PointOfSale. Boundary case:
     * Lis with one element.
     *
     */
    @Test
    public void testGetSelledProducts2() {
        ArrayList<Product> expect = new ArrayList<>();
        Product aProduct = new Product("Brasil", true, true, 130, "No aplica", 1, "Nueces");
        expect.add(aProduct);
        aPointOfSale.addSoldProduct(aProduct);
        assertEquals(expect, aPointOfSale.getSelledProducts());
    }

    /**
     * Test of getSelledProducts method, of class PointOfSale. Test if a list of
     * selled products contain a certain product.
     *
     */
    @Test
    public void testSelledProductsContain() {
        Product aProduct = new Product("Brasil", true, true, 130, "No aplica", 1, "Nueces");
        aPointOfSale.addSoldProduct(aProduct);
        boolean expect = true;
        boolean result = aPointOfSale.getSelledProducts().contains(aProduct);
        assertEquals(expect, result);
    }

    /**
     * Test of getSelledProducts method, of class PointOfSale. Test if a list of
     * selled products contain a certain product.
     *
     */
    @Test
    public void testSelledProductsContain2() {
        Product aProduct = new Product("Brasil", true, true, 130, "No aplica", 1, "Nueces");
        Product aProduct2 = new Product("Uruguay", true, false, 170, "No aplica", 1, "Almendras");
        aPointOfSale.addSoldProduct(aProduct);
        boolean expect = false;
        boolean result = aPointOfSale.getSelledProducts().contains(aProduct2);
        assertEquals(expect, result);
    }

    /**
     * Test of getSelledProducts method, of class PointOfSale. Test if a list is
     * empty.
     *
     */
    @Test
    public void testListOfSelledProductsIsEmpty() {
        boolean expect = true;
        boolean result = aPointOfSale.getSelledProducts().isEmpty();
        assertEquals(expect, result);
    }

    /**
     * Test of getSelledProducts method, of class PointOfSale. Test if a list is
     * empty.
     *
     */
    @Test
    public void testListOfSelledProductsIsEmpty2() {
        boolean expect = false;
        Product aProduct = new Product("Brasil", true, true, 130, "No aplica", 1, "Nueces");
        aPointOfSale.addSoldProduct(aProduct);
        boolean result = aPointOfSale.getSelledProducts().isEmpty();
        assertEquals(expect, result);
    }

    /**
     * Test of addProductForSale method, of class PointOfSale.
     */
    @Test
    public void testAddProductForSale() {
        Product aProduct = new Product("Brasil", true, true, 130, "No aplica", 1, "Nueces");
        ArrayList<Product> expected = aPointOfSale.getProductsForSale();
        aPointOfSale.addProductForSale(aProduct);
        expected.add(aProduct);
        assertEquals(expected, aPointOfSale.getProductsForSale());
    }

    /**
     * Test of addSoldProduct method, of class PointOfSale.
     */
    @Test
    public void testAddSoldProduct() {
        Product aProduct = new Product("Brasil", true, true, 130, "No aplica", 1, "Nueces");
        ArrayList<Product> expected = aPointOfSale.getSelledProducts();
        aPointOfSale.addSoldProduct(aProduct);
        expected.add(aProduct);
        assertEquals(expected, aPointOfSale.getSelledProducts());
    }

    /**
     * Test of toString method, of class PointOfSale.
     */
    @Test
    public void testToString() {
        String expected = "La Molienda";
        aPointOfSale.setName(expected);
        assertEquals(expected, aPointOfSale.toString());
    }

}
