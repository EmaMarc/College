package ar.edu.unlp.info.oo1.ejercicio21;

public class EnvioLocal extends Envio{
    private boolean entregaRapida;

    public EnvioLocal(Cliente cliente, String direccionOrigen, String direccionDestino, double pesoGr, boolean entregaRapida) {
        super(cliente, direccionOrigen, direccionDestino, pesoGr);
        this.entregaRapida = entregaRapida;
    }

    public boolean isEntregaRapida() {
        return entregaRapida;
    }

    @Override
    public double costo() {
        if (entregaRapida)
            return 1500;
        else
            return 1000;
    }
}
