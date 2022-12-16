package ar.edu.unlp.info.oo1;

public class Empleado {
	private String nombreCompleto;
	private double valorHora;

	public Empleado (String nombreCompleto, double valorHora) {
		this.nombreCompleto = nombreCompleto;
		this.valorHora = valorHora;
	}

	public double getValorHora() {
		return valorHora;
	}
	
	
}
