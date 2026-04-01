package ar.edu.unlp.info.oo1.ejercicio21;

public class EnvioInternacional extends Envio{
    private boolean envioRapido;

    public EnvioInternacional(Cliente cliente, String direccionOrigen, String direccionDestino, double pesoGr, boolean envioRapido) {
        super(cliente, direccionOrigen, direccionDestino, pesoGr);
        this.envioRapido = envioRapido;
    }

    public boolean isEnvioRapido() {
        return envioRapido;
    }
    
    @Override
    public double costo(){
        double costoTotal = 5000;
        if (this.getPesoGr() <= 1000){
            costoTotal += this.getPesoGr() * 10;
        } else {
            costoTotal += this.getPesoGr() * 12;
        }
        if (envioRapido)
            costoTotal += 800;

        return costoTotal;
    }
}
