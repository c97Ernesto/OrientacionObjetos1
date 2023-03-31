package ar.edu.unlp.info.oo1.ej11_ElInversor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
El valor actual de un plazo fijo equivale al montoDepositado incrementado
como corresponda por el porcentaje de interés diario, desde la fecha de
constitución a la fecha actual (en la que se hace el cálculo).
*/
public class PlazoFijo {
	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo(LocalDate fecha, double monto, double porcentaje) {
		this.fechaDeConstitucion = fecha;
		this.montoDepositado = monto;
		this.porcentajeDeInteresDiario = porcentaje;
	}
	
	public LocalDate getFechaDeConstitucion() {
		return fechaDeConstitucion;
	}
	
	public double getMontoDepositado() {
		return montoDepositado;
	}
	
	public double getPorcentajeDeInteresDiario() {
		return porcentajeDeInteresDiario;
	}
	
	public long diasTranscurridos() {
		return ChronoUnit.DAYS.between(this.fechaDeConstitucion, LocalDate.now());
	}
	
	
	public double montoInteresAcumulado() {
		return this.diasTranscurridos() * this.getPorcentajeDeInteresDiario();
	}
	
	public double valorActual() {
		return this.montoInteresAcumulado() + this.getMontoDepositado();
	}
	
}
