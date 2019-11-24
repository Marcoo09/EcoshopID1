package domain;

/**
 * This class defines a client who can purchase products in the system.
 *
 * @author Agustin Hernandorena and Marco Fiorito
 */
public final class Client {

    private String firstName;
    private String lastName;
    private String identifyCard;
    private String phoneNumber;
    private String clientNumber;

    /**
     * Constructor with parameters.
     *
     * @param firstName Is the name of the client.
     * @param lastName Is the surname of the client.
     * @param identifyCard Is the identify card of the client.
     * @param phoneNumber Is the phone number of the client.
     * @param clientNumber Is the client numer.
     */
    public Client(String firstName, String lastName, String identifyCard, String phoneNumber, String clientNumber) {
        this.setFirstName(firstName);
        this.setlastName(lastName);
        this.setIdentifyCard(identifyCard);
        this.setPhoneNumber(phoneNumber);
        this.setClientNumber(clientNumber);
    }

    public Client() {
        this.setClientNumber("");
        this.setFirstName("");
        this.setIdentifyCard("");
        this.setPhoneNumber("");
        this.setlastName("");
    }

    /**
     *
     * Method that returns the name of the client.
     *
     * @return Client name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method that sets the name of the client.
     *
     * @param firstName Client name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method that returns the surname of the client.
     *
     * @return Client last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method that sets the last name of the client.
     *
     * @param lastName Client last name.
     */
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method that returns the identify card of the client.
     *
     * @return Identify card of the client.
     */
    public String getIdentifyCard() {
        return identifyCard;
    }

    /**
     * Method that sets the identify card of the client.
     *
     * @param identifyCard Identify card of the client.
     */
    public void setIdentifyCard(String identifyCard) {
        this.identifyCard = identifyCard;
    }

    /**
     * Method that returns the phone number of the client.
     *
     * @return Phone nunber of the client.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method that sets the phone number of the client.
     *
     * @param phoneNumber Phone number of the client.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method that returns the client number.
     *
     * @return Client numer.
     */
    public String getClientNumber() {
        return clientNumber;
    }

    /**
     * Method that sets the client numer.
     *
     * @param clientNumber client number.
     */
    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    /**
     *
     * Equals method to compare two clients.
     *
     * @param o It is the object to compare.
     * @return Returns true if both clients have the same identity card.
     */
    @Override
    public boolean equals(Object o) {
        Client aClient = (Client) o;
        return this.getIdentifyCard().equals(aClient.getIdentifyCard());
    }

}
