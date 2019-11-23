package domain;

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
public class ClientTest {

    private Client aClient;

    public ClientTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        aClient = new Client();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFirstName method, of class Client.
     */
    @Test
    public void testGetFirstName() {
        String expected = "Juan";
        aClient.setFirstName(expected);
        assertEquals(expected, aClient.getFirstName());

    }

    /**
     * Test of setFirstName method, of class Client.
     */
    @Test
    public void testSetFirstName() {
        String expected = "Pedro";
        aClient.setFirstName(expected);
        assertEquals(expected, aClient.getFirstName());
    }

    /**
     * Test of getLastName method, of class Client.
     */
    @Test
    public void testGetLastName() {
        String expected = "Gomez";
        aClient.setlastName(expected);
        assertEquals(expected, aClient.getLastName());

    }

    /**
     * Test of setlastName method, of class Client.
     */
    @Test
    public void testSetlastName() {
        String expected = "Ramirez";
        aClient.setlastName(expected);
        assertEquals(expected, aClient.getLastName());
    }

    /**
     * Test of getIdentifyCard method, of class Client.
     */
    @Test
    public void testGetIdentifyCard() {
        String expected = "14567792";
        aClient.setIdentifyCard(expected);
        assertEquals(expected, aClient.getIdentifyCard());

    }

    /**
     * Test of setIdentifyCard method, of class Client.
     */
    @Test
    public void testSetIdentifyCard() {
        String expected = "48905069";
        aClient.setIdentifyCard(expected);
        assertEquals(expected, aClient.getIdentifyCard());
    }

    /**
     * Test of getPhoneNumber method, of class Client.
     */
    @Test
    public void testGetPhoneNumber() {
        String expected = "091234763";
        aClient.setPhoneNumber(expected);
        assertEquals(expected, aClient.getPhoneNumber());
    }

    /**
     * Test of setPhoneNumber method, of class Client.
     */
    @Test
    public void testSetPhoneNumber() {
        String expected = "093456711";
        aClient.setPhoneNumber(expected);
        assertEquals(expected, aClient.getPhoneNumber());
    }

    /**
     * Test of getClientNumber method, of class Client.
     */
    @Test
    public void testGetClientNumber() {
        String expected = "1";
        aClient.setClientNumber(expected);
        assertEquals(expected, aClient.getClientNumber());
    }

    /**
     * Test of setClientNumber method, of class Client.
     */
    @Test
    public void testSetClientNumber() {
        String expected = "2";
        aClient.setClientNumber(expected);
        assertEquals(expected, aClient.getClientNumber());
    }
    
    @Test
    public void testEquals(){
        Client c2 = new Client();
        c2.setIdentifyCard("3456789");
        aClient.setIdentifyCard("3456789");
        boolean expect = true;
        boolean result = c2.equals(aClient);
        assertEquals(expect, result);
    }
    
    @Test
    public void testEquals2(){
        Client c2 = new Client();
        c2.setIdentifyCard("34567891");
        aClient.setIdentifyCard("3456789");
        boolean expect = false;
        boolean result = c2.equals(aClient);
        assertEquals(expect, result);
    }

}
