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
    private String identifyCard;
    private String phoneNumber;
    private int clientNumber;

    public Client(String name, String surname, String identifyCard, 
            String phoneNumber, int clientNumber) {
        this.setName(name);
        this.setSurname(surname);
        this.setIdentifyCard(identifyCard);
        this.setPhoneNumber(phoneNumber);
        this.setClientNumber(clientNumber);
    }
    public Client(){
        this.setClientNumber(0);
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