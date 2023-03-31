package ar.edu.info.oo1.ej4_figuras;

public class Circulo implements Figura{
	private double radio;
	
	public double getDiametro() {
		return this.radio*2;
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public double getRadio() {
		return this.radio;
	}
	
	public double getPerimetro() {
		return Math.PI*this.getDiametro();
	}
	
	public double getArea() {
		return (Math.PI*Math.pow(radio, 2));
	}
}
