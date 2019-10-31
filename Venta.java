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
public class Venta {

    ArrayList<Articulo> articulosAdquiridos;
    PuntoVenta lugarDeCompra;
    int precioTotal;
    String numeroDeTicket;
    String fechaDeCompra;
    String horaDeCompra;
    int pagoTotal;
    int cambio;
    ArrayList<Envase> envasesUtilizados;

    //Constructor vacio
    public Venta() {
        articulosAdquiridos = new ArrayList<>();
        envasesUtilizados = new ArrayList<>();
    }

    //Constructor con parametros
    public Venta(PuntoVenta unLugarDeCompra, int precioTotal,
            String numeroDeTicket, String fechaDeCompra, String horaDeCompra,
            int pagoTotal, int cambio) {
        articulosAdquiridos = new ArrayList<>();
        envasesUtilizados = new ArrayList<>();
        setLugarDeCompra(unLugarDeCompra);
        setPrecioTotal(precioTotal);
        setNumeroDeTicket(numeroDeTicket);
        setFechaDeCompra(fechaDeCompra);
        setHoraDeCompra(horaDeCompra);
        setPagoTotal(pagoTotal);
        setCambio(cambio);
    }

    public ArrayList<Articulo> getArticulosAdquiridos() {
        return articulosAdquiridos;
    }

    public void agregarArticuloAdquirido(Articulo unArticulo) {
        articulosAdquiridos.add(unArticulo);
    }

    public PuntoVenta getLugarDeCompra() {
        return lugarDeCompra;
    }

    public void setLugarDeCompra(PuntoVenta lugarDeCompra) {
        this.lugarDeCompra = lugarDeCompra;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getNumeroDeTicket() {
        return numeroDeTicket;
    }

    public void setNumeroDeTicket(String numeroDeTicket) {
        this.numeroDeTicket = numeroDeTicket;
    }

    public String getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(String fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public String getHoraDeCompra() {
        return horaDeCompra;
    }

    public void setHoraDeCompra(String horaDeCompra) {
        this.horaDeCompra = horaDeCompra;
    }

    public int getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(int pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public int getCambio() {
        return cambio;
    }

    public void setCambio(int cambio) {
        this.cambio = cambio;
    }

    public ArrayList<Envase> getEnvasesUtilizados() {
        return envasesUtilizados;
    }

    public void agregarEnvaseUtilizado(Envase unEnvase) {
        envasesUtilizados.add(unEnvase);
    }

}
