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
public class PuntoVenta {
    String direccion;
    String nombre;
    String descripcion;
    ArrayList<Articulo> articulosALaVenta;
    ArrayList<Articulo> articulosPreVenta;
    
    //Constructor vacio
    public PuntoVenta(){
        setDireccion("");
        setNombre("");
        setDescripcion("");
        articulosALaVenta = new ArrayList<Articulo>();
        articulosPreVenta = new ArrayList<Articulo>();
    }
  
    //Constructor con parametros
    public PuntoVenta(String unaDireccion, String unNombre, String unaDescripcion){
        setDireccion(unaDireccion);
        setNombre(unNombre);
        setDescripcion(unaDescripcion);
        articulosALaVenta = new ArrayList<Articulo>();
        articulosPreVenta = new ArrayList<Articulo>();
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String unaDireccion) {
        this.direccion = unaDireccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String unaDescripcion) {
        this.descripcion = unaDescripcion;
    }

    public ArrayList<Articulo> getArticulosALaVenta() {
        return articulosALaVenta;
    }

    public void agregarArticuloALaVenta(Articulo unArticulo) {
        articulosALaVenta.add(unArticulo);
    }

    public ArrayList<Articulo> getArticulosPreVenta() {
        return articulosPreVenta;
    }

    public void agregarArticuloPreVenta(Articulo unArticulo) {
        articulosPreVenta.add(unArticulo);
    }
    
}
