package ar.edu.unlp.info.oo1.ejercicio21;

public class PersonaFisica extends Cliente{
    private String dni;

    public PersonaFisica(String nombre, String direccion, String dni) {
        super(nombre, direccion);
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public double descuento(){
        //descuento del 10%
        return 0.90;
    }
}
