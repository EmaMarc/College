package io.github.unlp_oo.archetype;

public class Circulo extends Object{
	
	private double radio;

	public Circulo(double radio) {
		this.radio = radio;
	}
	
	public Circulo() {
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getDiametro() {
		return radio*2;
	}
	
	public void setDiametro(double diametro) {
		this.radio = diametro/2;
	}
	
	public double getPerimetro() {
		return (this.radio*2) * Math.PI;
	}
	
	public double getArea() {
		return Math.PI * (this.radio * this.radio);
	}

	@Override
	public String toString() {
		return "circulo [radio=" + radio + ", getRadio()=" + getRadio() + ", getDiametro()=" + getDiametro()
				+ ", getPerimetro()=" + getPerimetro() + ", getArea()=" + getArea() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
 }
