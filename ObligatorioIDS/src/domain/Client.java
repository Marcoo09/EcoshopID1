/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Agustin Hernandorena
 */
public class Client {

    private String name;
    private String surname;
    private int identifyCard;
    private String phoneNumber;
    private int clientNumber;

    Client(String name, String surname, int identifyCard, String phoneNumber) {
        setName(name);
        setSurname(surname);
        setIdentifyCard(identifyCard);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIdentifyCard() {
        return identifyCard;
    }

    public void setIdentifyCard(int identifyCard) {
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
