package io.github.unlp_oo.archetype;

public class Cuadrado extends Object{
	
	private double lado;

	public Cuadrado(double lado) {
		super();
		this.lado = lado;
	}

	public Cuadrado() {
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	
	public double getPerimetro() {
		return lado*4;
	}
	
	public double getArea() {
		return lado*lado;
	}

	@Override
	public String toString() {
		return "cuadrado [lado=" + lado + ", getLado()=" + getLado() + ", getPerimetro()=" + getPerimetro()
				+ ", getArea()=" + getArea() + "]";
	}

	
	
	
}
