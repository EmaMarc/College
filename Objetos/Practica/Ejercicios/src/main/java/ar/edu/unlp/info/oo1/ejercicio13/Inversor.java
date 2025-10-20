package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
    private List<Inversion> inversiones;

    public Inversor() {
        this.inversiones = new ArrayList<>();
    }

    public void agregarInversion(Inversion i){
        this.inversiones.add(i);

    }

    public void quitarInversion(Inversion i){
        this.inversiones.remove(i);

    }

    public double valorTotal(){
                        //filter buena practica para evitar NullPointerException
        return this.inversiones.stream().filter(inv -> inv != null)
                .mapToDouble(Inversion::valorActual)
                .sum();
    }
}
