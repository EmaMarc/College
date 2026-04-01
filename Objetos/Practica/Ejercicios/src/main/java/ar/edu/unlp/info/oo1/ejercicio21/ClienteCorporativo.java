package ar.edu.unlp.info.oo1.ejercicio21;

public class ClienteCorporativo extends Cliente {
    private String cuit;

    public ClienteCorporativo(String nombre, String direccion, String cuit) {
        super(nombre,direccion);
        this.cuit = cuit;
    }

    public String getCuit() {
        return cuit;
    }

    public double descuento(){
        //descuento del 0%
        return 1;
    }
}
