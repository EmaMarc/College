package ar.edu.unlp.info.oo1.ejercicio8;

import java.util.Date;

public class Mamifero {
    private String identificador;
    private String especie;
    private Date fechaNacimiento;
    private Mamifero padre;
    private Mamifero madre;

    public Mamifero() {}
    public Mamifero(String id) {
        this.identificador = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Mamifero getPadre() {
        return this.padre;
    }

    public void setPadre(Mamifero padre) {
        this.padre = padre;
    }

    public Mamifero getMadre() {
        return this.madre;
    }

    public void setMadre(Mamifero madre) {
        this.madre = madre;
    }

    // ABUELOS MATERNOS
    public Mamifero getAbueloMaterno() {
        return (this.madre != null) ? this.madre.getPadre() : null;
    }
    public Mamifero getAbuelaMaterna() {
        return (this.madre != null) ? this.madre.getMadre() : null;
    }

    // ABUELOS PATERNOS
    public Mamifero getAbueloPaterno() {
        return (this.padre != null) ? this.padre.getPadre() : null;
    }
    public Mamifero getAbuelaPaterna() {
        return (this.padre != null) ? this.padre.getMadre() : null;
    }

    //_----------------------------------------_
    private boolean esAncestro(Mamifero actual, Mamifero buscado){
        if (actual == null) return false;       // llegue al fin de la rama
        if (actual == buscado) return true;     // si estoy parado en el que busco = true

        // sigo subiendo por la rama materna y paterna del nodo actual
        return esAncestro(actual.getMadre(), buscado) ||
                esAncestro(actual.getPadre(), buscado);
    }

    public boolean tieneComoAncestroA(Mamifero unMamifero){
        if (unMamifero == null) return false;


        // Busco primero en toda la rama de la madre, y luego voy hacia los padres segun retorna false
        return esAncestro(this.madre, unMamifero) || esAncestro(this.padre, unMamifero);
    }
}
