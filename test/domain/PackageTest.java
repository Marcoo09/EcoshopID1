package domain;

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
public class PackageTest {


    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    private domain.Package aPackage;
    public PackageTest() {
    }

    @Before
    public void setUp() {
        aPackage = new domain.Package();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Package.
     */
    @Test
    public void testGetName() {
        String expected = "Tupper";
        aPackage.setName(expected);
        assertEquals(expected, aPackage.getName());
    }

    /**
     * Test of setName method, of class Package.
     */
    @Test
    public void testSetName() {
        String expected = "Bolsa Ziploc";
        aPackage.setName(expected);
        assertEquals(expected, aPackage.getName());
    }

    /**
     * Test of getMaterial method, of class Package.
     */
    @Test
    public void testGetMaterial() {
        String expected = "Plastico";
        aPackage.setMaterial(expected);
        assertEquals(expected, aPackage.getMaterial());

    }

    /**
     * Test of setMaterial method, of class Package.
     */
    @Test
    public void testSetMaterial() {
        String expected = "Vidrio";
        aPackage.setMaterial(expected);
        assertEquals(expected, aPackage.getMaterial());
    }

    /**
     * Test of getCapacity method, of class Package.
     */
    @Test
    public void testGetCapacity() {
        int expected = 150;
        aPackage.setCapacity(expected);
        assertEquals(expected, aPackage.getCapacity());
    }

    /**
     * Test of setCapacity method, of class Package.
     */
    @Test
    public void testSetCapacity() {
        int expected = 170;
        aPackage.setCapacity(expected);
        assertEquals(expected, aPackage.getCapacity());
    }

    /**
     * Test of toString method, of class Package.
     */
    @Test
    public void testToString() {
        aPackage.setName("Bolsa");
        aPackage.setMaterial("Plastico");
        aPackage.setCapacity(120);
        String expected = aPackage.getName();
        assertEquals(expected, aPackage.toString());
    }

}
