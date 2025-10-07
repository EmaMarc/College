package ar.edu.unlp.info.oo1.ejercicio7;

public class Circulo implements Figura2D {
    private double radio;

    public Circulo() {}
    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getDiametro() {
        return this.radio * 2;
    }

    public void setDiametro(double diametro) {
        this.radio = diametro / 2.0;
    }

    @Override
    public double getPerimetro() {
        // perímetro = π * diámetro
        return Math.PI * this.getDiametro();
    }

    @Override
    public double getArea() {
        // área = π * r^2
        return Math.PI * this.radio * this.radio;
    }

    @Override
    public String toString() {
        return "Circulo{ radio=" + radio + "}";
    }
}
