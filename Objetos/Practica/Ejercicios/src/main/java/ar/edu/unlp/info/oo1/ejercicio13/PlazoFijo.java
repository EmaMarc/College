package ar.edu.unlp.info.oo1.ejercicio13;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class PlazoFijo implements Inversion {
    private LocalDate fecha;
    private double montoDepositado;
    private double intereses;

    public PlazoFijo() {}

    public PlazoFijo(LocalDate fecha, double montoDepositado, double intereses) {
        this.fecha = fecha;
        this.montoDepositado = montoDepositado;
        this.intereses = intereses;
    }

    @Override
    public double valorActual() {
        long dias = ChronoUnit.DAYS.between(LocalDate.now(), this.fecha);
        return this.montoDepositado * ( dias  * intereses);
    }
}
