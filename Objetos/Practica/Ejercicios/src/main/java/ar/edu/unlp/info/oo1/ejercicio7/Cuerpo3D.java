package ar.edu.unlp.info.oo1.ejercicio7;

public class Cuerpo3D {
    private double altura;
    private Figura2D caraBasal;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setCaraBasal(Figura2D cara){
        this.caraBasal = cara;
    }

    public double getVolumen(){
        return caraBasal.getArea() * this.altura;
    }

    public double getSuperficieExterior(){
        return 2 * caraBasal.getArea() + caraBasal.getPerimetro() * this.altura;
    }
}
