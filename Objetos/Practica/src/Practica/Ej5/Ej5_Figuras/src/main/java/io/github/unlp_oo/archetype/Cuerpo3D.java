package io.github.unlp_oo.archetype;

public class Cuerpo3D extends Object {
	private double radio;
	private double altura;
	private double caraBasal;
	
	public Cuerpo3D(double radio, double altura, double caraBasal) {
		super();
		this.radio = radio;
		this.altura = altura;
		this.caraBasal = caraBasal;
	}
	
	

	public Cuerpo3D() {
		super();
	}



	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void setCaraBasal(double cara) {
		this.caraBasal = cara;
	}
	
	public double getSuperficie() {
		return (2*this.caraBasal) + (2*this.radio)*this.altura; 
	}
	
	public double getVolumen() {
		return this.caraBasal*this.altura ;
	}



		
	}
}
