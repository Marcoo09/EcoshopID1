/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author Agustin Hernandorena
 */
public class Articulo {
    String  origenMateriaPrima;
    int precio;
    String material;
    int identificador;
    ArrayList<Envase> listaEnvasesDisponibles;
    
    //Constructor vacio
    public Articulo(){
        setOrigenMateriaPrima("");
        setIdentificador(0);
        setMaterial("");
        setPrecio(0);
        listaEnvasesDisponibles= new ArrayList<Envase>();
    }
    
    //Constructor con parametros
    public Articulo(String origenMateriaPrima, int unPrecio, int identificador, String unMaterial){
        setOrigenMateriaPrima(origenMateriaPrima);
        setPrecio(precio);
        setIdentificador(identificador);
        setMaterial(material);
        listaEnvasesDisponibles = new ArrayList<Envase>();
    }
    public String getOrigenMateriaPrima() {
        return origenMateriaPrima;
    }

    public void setOrigenMateriaPrima(String origenMateriaPrima) {
        this.origenMateriaPrima = origenMateriaPrima;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public ArrayList<Envase> getListaEnvasesDisponibles() {
        return listaEnvasesDisponibles;
    }

    public void agregarEnvase(Envase unEnvase) {
      listaEnvasesDisponibles.add(unEnvase);
    }
    
}
