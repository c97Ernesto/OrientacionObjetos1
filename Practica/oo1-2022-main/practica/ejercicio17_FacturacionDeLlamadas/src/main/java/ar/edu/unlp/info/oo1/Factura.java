package ar.edu.unlp.info.oo1;

import java.time.LocalDateTime;

public class Factura {
	private Persona cliente;
	private LocalDateTime fechaFacturacion;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private double montoTotal;
	
	public Factura (Persona cliente, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		this.cliente = cliente;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaFacturacion = LocalDateTime.now();
		this.montoTotal = 0;
	}

	public Persona getCliente() {
		return cliente;
	}
	public LocalDateTime getFechaFacturacion() {
		return fechaFacturacion;
	}
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	public LocalDateTime getFechaFin() {
		return fechaFin;
	}
	public void setMontoTotal() {
		this.montoTotal = this.facturar(this.fechaInicio, this.fechaFin);
	}
	public double getMontoTotal() {
		return this.montoTotal;
	}
	
	public double facturar(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return this.getCliente().registroDeLlamadas().stream()
				.filter(llamada -> llamada.periodoFecha(fechaInicio, fechaFin))
				.mapToDouble(llamada -> llamada.costo())
				.sum();
	}
}
