package ar.edu.unlp.info.oo1.ej11_ElInversor;
/*
el valor actual de una InversionEnAcciones se calcula multiplicando 
el número de acciones por el valor actual de las mismas.
*/

public class InversionEnAcciones implements Inversion{
	private String nombre;
	private int cantidad;
	private double valorUnitario;
	
	public InversionEnAcciones(String nombre, int cantidad, double valorUnitario) {
		this.nombre = nombre;
		this.setCantidad(cantidad);
		this.setValorUnitario(valorUnitario);
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public double valorActual() {
		return this.getValorUnitario()*this.getCantidad();
	}
	
}
