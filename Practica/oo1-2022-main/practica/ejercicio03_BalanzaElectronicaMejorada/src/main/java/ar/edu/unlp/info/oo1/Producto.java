package ar.edu.unlp.info.oo1;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getPeso() {
		return this.peso;
	}
	
	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}
	public double getPrecioPorKilo() {
		return precioPorKilo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public double getPrecio() {
		return this.precioPorKilo * this.peso;
	}
	
}
