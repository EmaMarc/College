package ar.edu.unlp.info.oo1.ejercicio21;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    private String nombre;
    private String direccion;
    private List<Envio> envios;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.envios = new ArrayList<Envio>();
    }


    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Envio> getEnvios(){
        return this.envios;
    }

    public void agregarEnvio(Envio e){
        if (e.getCliente() != this) {
            //el envio ya tiene otro cliente
            return;
        }else {
            e.setCliente(this);
            envios.add(e);
        }
    }

    public double montoAPagar(LocalDate inicio, LocalDate fin){
        return this.envios.stream()
                                    //que no este antes del inicio
                .filter(e -> !e.getFechaDespacho().isBefore(inicio) &&
                                    //que no este despues del fin
                                   !e.getFechaDespacho().isAfter(fin))
                .mapToDouble(e -> e.costo())
                .sum() * this.descuento();
    }

    abstract double descuento();
}
