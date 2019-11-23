package domain;

import java.util.ArrayList;
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
public class ProductTest {

    private Product aProduct;

    public ProductTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        aProduct = new Product();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Product.
     */
    @Test
    public void testGetName() {
        String expect = "Nueces";
        aProduct.setName(expect);
        assertEquals(expect, aProduct.getName());
    }

    /**
     * Test of setName method, of class Product.
     */
    @Test
    public void testSetName() {
        String expect = "Almendras";
        aProduct.setName(expect);
        assertEquals(expect, aProduct.getName());
    }

    /**
     * Test of getCountryOfOrigin method, of class Product.
     */
    @Test
    public void testGetCountryOfOrigin() {
        String expect = "Uruguay";
        aProduct.setCountryOfOrigin(expect);
        assertEquals(expect, aProduct.getCountryOfOrigin());

    }

    /**
     * Test of setCountryOfOrigin method, of class Product.
     */
    @Test
    public void testSetCountryOfOrigin() {
        String expect = "Brasil";
        aProduct.setCountryOfOrigin(expect);
        assertEquals(expect, aProduct.getCountryOfOrigin());
    }

    /**
     * Test of isOrganic method, of class Product.
     */
    @Test
    public void testIsOrganic() {
        boolean expect = true;
        aProduct.setOrganic(expect);
        assertEquals(expect, aProduct.isOrganic());
    }

    /**
     * Test of isOrganic method, of class Product.
     */
    @Test
    public void testIsOrganic2() {
        boolean expect = false;
        aProduct.setOrganic(expect);
        assertEquals(expect, aProduct.isOrganic());
    }

    /**
     * Test of setOrganic method, of class Product.
     */
    @Test
    public void testSetOrganic() {
        boolean expect = true;
        aProduct.setOrganic(expect);
        assertEquals(expect, aProduct.isOrganic());
    }

    /**
     * Test of setOrganic method, of class Product.
     */
    @Test
    public void testSetOrganic2() {
        boolean expect = false;
        aProduct.setOrganic(expect);
        assertEquals(expect, aProduct.isOrganic());
    }

    /**
     * Test of isFormedFromRecycledMaterials method, of class Product.
     */
    @Test
    public void testIsFormedFromRecycledMaterials() {
        boolean expect = true;
        aProduct.setFormedFromRecycledMaterials(expect);
        assertEquals(expect, aProduct.isFormedFromRecycledMaterials());
    }

    /**
     * Test of isFormedFromRecycledMaterials method, of class Product.
     */
    @Test
    public void testIsFormedFromRecycledMaterials2() {
        boolean expect = false;
        aProduct.setFormedFromRecycledMaterials(expect);
        assertEquals(expect, aProduct.isFormedFromRecycledMaterials());
    }

    /**
     * Test of setFormedFromRecycledMaterials method, of class Product.
     */
    @Test
    public void testSetFormedFromRecycledMaterials() {
        boolean expect = true;
        aProduct.setFormedFromRecycledMaterials(expect);
        assertEquals(expect, aProduct.isFormedFromRecycledMaterials());
    }

    /**
     * Test of setFormedFromRecycledMaterials method, of class Product.
     */
    @Test
    public void testSetFormedFromRecycledMaterials2() {
        boolean expect = false;
        aProduct.setFormedFromRecycledMaterials(expect);
        assertEquals(expect, aProduct.isFormedFromRecycledMaterials());
    }

    /**
     * Test of getPrice method, of class Product.
     */
    @Test
    public void testGetPrice() {
        int expect = 1000;
        aProduct.setPrice(expect);
        assertEquals(expect, aProduct.getPrice());
    }

    /**
     * Test of setPrice method, of class Product.
     */
    @Test
    public void testSetPrice() {
        int expect = 500;
        aProduct.setPrice(expect);
        assertEquals(expect, aProduct.getPrice());
    }

    /**
     * Test of getMaterial method, of class Product.
     */
    @Test
    public void testGetMaterial() {
        String expect = "Madera";
        aProduct.setMaterial(expect);
        assertEquals(expect, aProduct.getMaterial());
    }

    /**
     * Test of setMaterial method, of class Product.
     */
    @Test
    public void testSetMaterial() {
        String expect = "Plastico";
        aProduct.setMaterial(expect);
        assertEquals(expect, aProduct.getMaterial());
    }

    /**
     * Test of getIdentifier method, of class Product.
     */
    @Test
    public void testGetIdentifier() {
        int expected = 3;
        aProduct.setIdentifier(expected);
        assertEquals(expected, aProduct.getIdentifier());
    }

    /**
     * Test of setIdentifier method, of class Product.
     */
    @Test
    public void testSetIdentifier() {
        int expected = 3;
        aProduct.setIdentifier(expected);
        assertEquals(expected, aProduct.getIdentifier());
    }

    /**
     * Test of getListOfAvailablePackages method, of class Product. Borderline
     * case: Empty list.
     *
     */
    @Test
    public void testGetListOfAvailablePackages() {
        ArrayList<domain.Package> expected = new ArrayList<>();
        assertEquals(expected, aProduct.getListOfAvailablePackages());
    }

    /**
     * Test of getListOfAvailablePackages method, of class Product. Borderline
     * case: List with one element.
     *
     */
    @Test
    public void testGetListOfAvailablePackages2() {
        ArrayList<domain.Package> expected = new ArrayList<>();
        domain.Package aPackage = new domain.Package("Tupper", "Plastico", 250);
        expected.add(aPackage);
        aProduct.addPackage(aPackage);
        assertEquals(expected, aProduct.getListOfAvailablePackages());
    }

    /**
     * Test of addPackage method, of class Product.
     */
    @Test
    public void testAddPackage() {
        domain.Package aPackage = new domain.Package("Tupper", "Plastico", 250);
        ArrayList<domain.Package> expected = aProduct.getListOfAvailablePackages();
        aProduct.addPackage(aPackage);
        expected.add(aPackage);
        assertEquals(expected, aProduct.getListOfAvailablePackages());
    }

    /**
     * Test of toString method with an organic product, of class Product.
     */
    @Test
    public void testToString() {
        aProduct.setMaterial("Madera");
        aProduct.setOrganic(true);
        aProduct.setCountryOfOrigin("Brasil");
        String expect = "El material es: " + aProduct.getMaterial() + "\n" + (aProduct.isOrganic() ? "Es organico\n" : "No es Organico\n")
                + "Proviene de " + aProduct.getCountryOfOrigin() + "\n";
        assertEquals(expect, aProduct.toString());
    }

    /**
     * Test of toString method with a not organic product, of class Product.
     */
    @Test
    public void testToString2() {
        aProduct.setMaterial("Madera");
        aProduct.setOrganic(false);
        aProduct.setCountryOfOrigin("Brasil");
        String expect = "El material es: " + aProduct.getMaterial() + "\n" + (aProduct.isOrganic() ? "Es organico\n" : "No es Organico\n")
                + "Proviene de " + aProduct.getCountryOfOrigin() + "\n";
        assertEquals(expect, aProduct.toString());
    }
    
}
