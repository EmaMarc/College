package ar.edu.unlp.info.oo1.ejercicio2;

import java.time.LocalDate;

public class Ticket {

    private LocalDate fecha;
    private int cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;

    public Ticket(LocalDate fecha, int cantidadDeProductos, double pesoTotal, double precioTotal) {
        this.fecha = fecha;
        this.cantidadDeProductos = cantidadDeProductos;
        this.pesoTotal = pesoTotal;
        this.precioTotal = precioTotal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    //21%
    public double impuesto(){
        return this.precioTotal * 1.21;
    }

}
