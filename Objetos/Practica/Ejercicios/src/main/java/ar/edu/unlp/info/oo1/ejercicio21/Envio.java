package ar.edu.unlp.info.oo1.ejercicio21;

import java.time.LocalDate;

public abstract class Envio {
    private Cliente cliente;
    private LocalDate fechaDespacho;
    private String direccionOrigen;
    private String direccionDestino;
    private double pesoGr;

    public Envio(Cliente cliente, String direccionOrigen, String direccionDestino, double pesoGr) {
        this.cliente = cliente;
        this.fechaDespacho = LocalDate.now();
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.pesoGr = pesoGr;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaDespacho() {
        return fechaDespacho;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public double getPesoGr() {
        return pesoGr;
    }

    public abstract double costo();

}
