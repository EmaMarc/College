package ar.edu.unlp.info.oo1.ejercicio4;

import java.time.LocalDate;
import java.util.List;

//igual que el ejercicio 2
public class Ticket2 {

    private LocalDate fecha;
    private int cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;
    private List<Producto2> productos;

    public Ticket2(LocalDate fecha, int cantidadDeProductos, double pesoTotal, double precioTotal, List<Producto2> productos) {
        this.fecha = fecha;
        this.cantidadDeProductos = cantidadDeProductos;
        this.pesoTotal = pesoTotal;
        this.precioTotal = precioTotal;
        this.productos = List.copyOf(productos);
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
        return this.precioTotal * 0.21;
    }

    public List<Producto2> getProductos() {
        return this.productos;
    }

}
