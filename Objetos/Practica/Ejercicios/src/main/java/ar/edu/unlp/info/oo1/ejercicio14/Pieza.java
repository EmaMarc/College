package ar.edu.unlp.info.oo1.ejercicio14;

public abstract class Pieza {
    private String material;
    private String color;

    public Pieza(String material, String color) {
        this.material = material;
        this.color = color;
    }

    public abstract double Volumen();

    public abstract double Superficie();

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }
}
