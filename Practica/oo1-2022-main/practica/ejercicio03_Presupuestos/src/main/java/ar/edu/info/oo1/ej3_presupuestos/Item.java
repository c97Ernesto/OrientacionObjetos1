package ar.edu.info.oo1.ej3_presupuestos;

public class Item {
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	
	public double costo() {
		return (this.cantidad * this.costoUnitario);
	}
	
	public Item detalle(String string) {
		this.detalle = string;
		return this;
	}
	public Item costoUnitario(int i) {
		this.costoUnitario = i;
		return this;
	}
	public Item cantidad(int i) {
		this.cantidad = i;
		return this;
	}
	
	public double getCostoUnitario() {
		return this.costoUnitario;
	}
}
