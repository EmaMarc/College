package ar.edu.unlp.info.oo1.ejercicio14;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
    private List<Pieza> piezas;

    public ReporteDeConstruccion() {
        this.piezas = new ArrayList<>();
    }

    public double VolumenDeMaterial(String material){
        return this.piezas.stream()
                .filter(p -> p.getMaterial().equals(material))
                .mapToDouble(Pieza::Volumen)
                .sum();
    }

    public double SuperficieDeColor(String color) {
        return this.piezas.stream().filter(p -> p.getColor().equals(color)).mapToDouble(Pieza::Superficie).sum();
    }

    public void AgregarPieza(Pieza p){
        if (p != null)
            this.piezas.add(p);
    }
}
