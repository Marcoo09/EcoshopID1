package domain;

/**
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */

public class Client {

    private String firstName;
    private String lastName;
    private String identifyCard;
    private String phoneNumber;
    private int clientNumber;

    public Client(String firstName, String lastName, String identifyCard, String phoneNumber, int clientNumber) {
        this.setFirstName(firstName);
        this.setlastName(lastName);
        this.setIdentifyCard(identifyCard);
        this.setPhoneNumber(phoneNumber);
        this.setClientNumber(clientNumber);
    }
    public Client(){
        this.setClientNumber(0);
    }
        
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentifyCard() {
        return identifyCard;
    }

    public void setIdentifyCard(String identifyCard) {
        this.identifyCard = identifyCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

}