package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class ContratoDePlanta extends Contrato {
	private double montoPorConyugue;
	private double montoPorHijo;
	private double sueldoMensual;

	public ContratoDePlanta(Empleado empleado, LocalDate fechaInicio, double sueldoMensual, double montoPorConyugue,
		double montoPorHijo) {
		super(empleado, fechaInicio);
		this.sueldoMensual = sueldoMensual;
		this.montoPorHijo = montoPorHijo;
		this.montoPorConyugue = montoPorConyugue;
	}

	public double getMontoPorConyugue() {
		return montoPorConyugue;
	}
	public double getMontoPorHijo() {
		return montoPorHijo;
	}

	@Override
	public boolean vigente() {
		return true;
	}

	//si no hay conyugue ni hijo los montos son 0.
	@Override
	public double montoBasico() {
		return this.montoPorConyugue + this.montoPorHijo + this.sueldoMensual;
	}

}
