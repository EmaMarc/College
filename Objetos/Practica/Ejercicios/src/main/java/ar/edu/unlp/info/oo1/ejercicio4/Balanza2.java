/*package ar.edu.unlp.info.oo1.ejercicio4;

import ar.edu.unlp.info.oo1.ejercicio2.Producto;
import ar.edu.unlp.info.oo1.ejercicio2.Ticket;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Balanza2 {

    private List<Producto2> productos;

    public Balanza2() {
        this.productos = new ArrayList<Producto2>();
    }

    // 👉 Exponer productos sin romper encapsulamiento
    public List<Producto2> getProductos() {
        return List.copyOf(this.productos); // copia inmodificable
    }

    public int getCantidadDeProductos() {
        return this.productos.size();
    }

    public double getPrecioTotal() {
        return this.productos.stream().mapToDouble(Producto2::getPrecio).sum();
    }

    public double getPesoTotal() {
        return this.productos.stream()
                .mapToDouble(Producto2::getPeso)
                .sum();
    }

    public void agregarProducto(Producto2 producto2){
        this.productos.add(producto2);
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
}*/
