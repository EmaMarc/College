package ar.edu.unlp.info.oo1.ejercicio14;

public class Esfera extends Pieza{
    private double radio;

    public Esfera(String material, String color, double radio) {
        super(material, color);
        this.radio = radio;
    }

    public double Volumen(){
        // ⁴⁄₃ * π * radio ³
        return (4.0 / 3.0) * Math.PI * Math.pow(this.radio,3);
    }

    public double Superficie(){
        //4 * π * radio 2
        return 4 * Math.PI * Math.pow(this.radio,2);
    }
}
