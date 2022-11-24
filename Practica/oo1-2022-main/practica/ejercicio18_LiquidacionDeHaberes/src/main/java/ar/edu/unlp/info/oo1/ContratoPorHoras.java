package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class ContratoPorHoras extends Contrato{

	private double horasPorMes;
	private LocalDate fechaFin;
	private double valorHora;

	public ContratoPorHoras(Empleado empleado, LocalDate fechaInicio, double valorHora, double horasPorMes, 
			LocalDate fechaFin) {
		super(empleado, fechaInicio);
		this.valorHora = valorHora;
		this.horasPorMes = horasPorMes;
		this.fechaFin = fechaFin;
		
	}
	
	@Override
	public boolean vigente() {
		return this.fechaFin.isBefore(LocalDate.now());
	}

	@Override
	public double montoBasico() {
		return this.horasPorMes*this.valorHora;
	}
}
