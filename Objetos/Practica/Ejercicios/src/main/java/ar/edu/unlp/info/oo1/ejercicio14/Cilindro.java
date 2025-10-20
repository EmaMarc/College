package ar.edu.unlp.info.oo1.ejercicio14;

public class Cilindro extends Pieza{
    private double radio;
    private double altura;

    public Cilindro(String material, String color, double radio, double altura) {
        super(material, color);
        this.radio = radio;
        this.altura = altura;
    }

    public double Volumen(){
        //π * radio 2 * h.
        return Math.PI * Math.pow(this.radio,2) * this.altura;
    }

    public double Superficie(){
        //2 * π * radio  * h + 2 * π * radio 2
        return 2 * Math.PI * this.radio * this.altura + 2 * Math.PI * Math.pow(this.radio,2);
    }
}

