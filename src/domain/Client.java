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
    private String clientNumber;

    public Client(String firstName, String lastName, String identifyCard, String phoneNumber, String clientNumber) {
        this.setFirstName(firstName);
        this.setlastName(lastName);
        this.setIdentifyCard(identifyCard);
        this.setPhoneNumber(phoneNumber);
        this.setClientNumber(clientNumber);
    }
    public Client(){
        this.setClientNumber("");
        this.setFirstName("");
        this.setIdentifyCard("");
        this.setPhoneNumber("");
        this.setlastName("");
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

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

}