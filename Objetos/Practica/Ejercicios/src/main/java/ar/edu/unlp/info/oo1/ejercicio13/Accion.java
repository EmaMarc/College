package ar.edu.unlp.info.oo1.ejercicio13;

public class Accion implements Inversion{
    private String nombre;
    private double valor;
    private int cantidad;

    public Accion() {}

    public Accion(String nombre, double valor, int cantidad) {
        this.nombre = nombre;
        this.valor = valor;
        this.cantidad = cantidad;
    }

    @Override
    public double valorActual() {
        return this.cantidad * this.valor;
    }
}
