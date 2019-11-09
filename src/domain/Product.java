/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Agustin Hernandorena
 */
public class Product {

    private String countryOfOrigin;
    private boolean Organic;
    private boolean formedFromRecycledMaterials;
    private int price;
    private String material;
    private int identifier;
    private ArrayList<Package> listOfAvailablePackages;

    public Product() {
        setCountryOfOrigin("");
        setOrganic(false);
        setFormedFromRecycledMaterials(false);
        setPrice(0);
        setMaterial("");
        setIdentifier(0);
        listOfAvailablePackages = new ArrayList<>();
    }

    public Product(String countryOfOrigin, boolean organic,
            boolean formedFromRecycledMaterials, int price,
            String material, int identifier) {
        setCountryOfOrigin(countryOfOrigin);
        setOrganic(organic);
        setFormedFromRecycledMaterials(formedFromRecycledMaterials);
        setPrice(price);
        setMaterial(material);
        setIdentifier(identifier);
        listOfAvailablePackages = new ArrayList<>();
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public boolean isOrganic() {
        return Organic;
    }

    public void setOrganic(boolean Organic) {
        this.Organic = Organic;
    }

    public boolean isFormedFromRecycledMaterials() {
        return formedFromRecycledMaterials;
    }

    public void setFormedFromRecycledMaterials(boolean formedFromRecycledMaterials) {
        this.formedFromRecycledMaterials = formedFromRecycledMaterials;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public ArrayList<Package> getListOfAvailablePackages() {
        return listOfAvailablePackages;
    }

    public void addPackage(Package aPackage) {
        listOfAvailablePackages.add(aPackage);
    }
}