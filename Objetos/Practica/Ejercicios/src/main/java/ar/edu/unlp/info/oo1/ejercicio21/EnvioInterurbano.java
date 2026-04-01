package ar.edu.unlp.info.oo1.ejercicio21;

public class EnvioInterurbano extends Envio{
    private double distanciaKm;

    public EnvioInterurbano(Cliente cliente, String direccionOrigen, String direccionDestino, double pesoGr, double distanciaKm) {
        super(cliente, direccionOrigen, direccionDestino, pesoGr);
        this.distanciaKm = distanciaKm;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    @Override
    public double costo(){
        if (distanciaKm < 100)
            return 20 * this.getPesoGr();
        else if (distanciaKm <= 500)
            return 25 * this.getPesoGr();
        else
            return 30 * this.getPesoGr();
    }
}
