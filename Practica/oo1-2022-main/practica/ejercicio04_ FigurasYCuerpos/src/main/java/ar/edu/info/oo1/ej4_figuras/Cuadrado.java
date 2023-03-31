package ar.edu.info.oo1.ej4_figuras;

public class Cuadrado implements Figura{
	private double lado;
	
	public void setLado(double lado) {
		this.lado = lado;
	}
	public double getLado() {
		return this.lado;
	}
	
	public double getPerimetro() {
		return this.lado*4;
	}
	
	public double getArea() {
		return this.lado*this.lado;
	}
	
}
