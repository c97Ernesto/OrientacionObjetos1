package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Vehiculo implements Bien{

	private String patente;
	private LocalDate fechaFabricacion;
	private double valor;
	private Usuario contribuyente;

	public Vehiculo(String patente, LocalDate fechaFabricacion, double valor, Usuario contribuyente) {
		this.patente = patente;
		this.fechaFabricacion = fechaFabricacion;
		this.valor = valor;
		this.contribuyente = contribuyente;
	}
	
	protected double getValor() {
		return valor;
	}
	
	private double aniosVehiculo() {
		return ChronoUnit.YEARS.between(this.fechaFabricacion, LocalDate.now());
	}
	
	protected boolean masDeDiezAnios() {
		return this.aniosVehiculo() > 10;
	}
	
	public abstract double impuesto();
}
