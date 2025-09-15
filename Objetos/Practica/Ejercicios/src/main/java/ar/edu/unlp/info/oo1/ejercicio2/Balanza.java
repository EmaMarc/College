package ar.edu.unlp.info.oo1.ejercicio2;

import java.time.LocalDate;

public class Balanza {

    private int cantidadDeProductos;
    private double precioTotal;
    private double pesoTotal;

    public Balanza(int cantidadDeProductos, double precioTotal, double pesoTotal) {
        this.cantidadDeProductos = cantidadDeProductos;
        this.precioTotal = precioTotal;
        this.pesoTotal = pesoTotal;
    }

    public Balanza() {
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void agregarProducto(Producto producto){
        this.cantidadDeProductos++;
        this.pesoTotal =+ producto.getPeso();
        this.precioTotal =+ producto.getPrecio();
    }

    public Ticket emitirTicket(){
        return new Ticket(LocalDate.now(), this.cantidadDeProductos, this.pesoTotal, this.precioTotal);
    }

    public void ponerEnCero(){
        this.cantidadDeProductos = 0;
        this.precioTotal = 0;
        this.pesoTotal = 0;
    }
    @Override
    public String toString() {
        return "balanzaElectronica{" +
                "cantidadDeProductos=" + cantidadDeProductos +
                ", precioTotal=" + precioTotal +
                ", pesoTotal=" + pesoTotal +
                '}';
    }
}
