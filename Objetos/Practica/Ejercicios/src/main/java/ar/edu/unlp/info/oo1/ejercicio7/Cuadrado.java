package ar.edu.unlp.info.oo1.ejercicio7;

public class Cuadrado implements Figura2D{
    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getPerimetro(){
        return this.lado * 4;
    }

    public double getArea(){
        return this.lado * this.lado;
    }

    @Override
    public String toString() {
        return "Cuadrado{" +
                "lado=" + lado +
                '}';
    }
}
