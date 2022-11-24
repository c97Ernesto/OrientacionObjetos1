package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

//Se indica el empleado, la fecha de inicio del contrato,
//la fecha de fin (si corresponde) y algunos valores adicionales dependiendo del tipo de
//contrato. Hay dos tipos de contratos.
public abstract class Contrato {
	
	private Empleado empleado;
	private LocalDate fechaInicio;

	public Contrato(Empleado empleado, LocalDate fechaInicio) {
		this.empleado = empleado;
		this.fechaInicio = fechaInicio;
		
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public abstract boolean vigente();
	public abstract double montoBasico();
}
