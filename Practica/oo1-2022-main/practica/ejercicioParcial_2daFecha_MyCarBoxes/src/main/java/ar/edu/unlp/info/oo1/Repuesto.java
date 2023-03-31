package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Repuesto {
	
	private String nombre;
	private LocalDate fechaFabricacion;
	private double costo;

	public Repuesto (String nombre, LocalDate fechaFabricacion, double costo) {
		this.nombre = nombre;
		this.fechaFabricacion = fechaFabricacion;
		this.costo = costo;
	}
	
	private long aniosDelRepuesto() {
		return ChronoUnit.YEARS.between(fechaFabricacion, LocalDate.now());
	}

	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}
	public double getCosto() {
		return costo;
	}
	
	public boolean repuestoViejo() {
		return this.aniosDelRepuesto() > 5;
	}
	
}
