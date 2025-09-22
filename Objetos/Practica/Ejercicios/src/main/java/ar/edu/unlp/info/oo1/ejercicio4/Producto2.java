package ar.edu.unlp.info.oo1.ejercicio4;


//igual que el ejercicio 2
public class Producto2 {

    private String descripcion;
    private double peso;
    private double precioPorKilo;


    public Producto2(String descripcion, double peso, double precioPorKilo) {
        this.descripcion = descripcion;
        this.peso = peso;
        this.precioPorKilo = precioPorKilo;

    }

    public Producto2() {
    }

    public double getPrecioPorKilo() {
        return precioPorKilo;
    }

    public void setPrecioPorKilo(double precioPorKilo) {
        this.precioPorKilo = precioPorKilo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPeso() {
        return this.peso;
    }

    public double getPrecio(){
        return this.peso * this.precioPorKilo;
    }


}
