package Practica1.Ejercicio7;

import Practica1.Ejercicio3.Persona;

public class Estudiante extends Persona {
    private String comision;
    private String direccion;

    public Estudiante(String nombre, String apellido, String email, String comision, String direccion) {
        super(nombre, apellido, email);
        this.comision = comision;
        this.direccion = direccion;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String toString(){
        return super.tusDatos() + "Comision: " + getComision() + ". Direccion " + getDireccion() + ". ";
    }
}
