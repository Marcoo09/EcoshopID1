/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Agustin Hernandorena
 */
public class Envase {
    String nombre;
    String material;
    int capacidad;
    
    //Constructor vacio
    public Envase(){
       this.setNombre("");
       this.setMaterial("");
       this.setCapacidad(0);
    }
    
    //Constructor con parametros
    public Envase(String unNombre, String unMaterial, int unaCapacidad){
        this.setNombre(unNombre);
        this.setMaterial(unMaterial);
        this.setCapacidad(unaCapacidad);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public String getMaterial() {
        return material;
    }
    

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
}
