package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.List;

public abstract class Orden {
	
	private String patente;
	private LocalDate fechaOrden;
	private List<Repuesto> repuestos;

	public Orden (String patente, List<Repuesto> repuestos) {
		this.patente = patente;
		this.repuestos = repuestos;
		this.fechaOrden = LocalDate.now();
	}

	public String getPatente() {
		return patente;
	}
	public LocalDate getFechaOrden() {
		return fechaOrden;
	}
	
	public abstract double costo();
	
	protected double precioDeRepuestos() {
		return this.repuestos.stream()
				.mapToDouble(repuesto -> repuesto.getCosto())
				.sum();
	}
	protected boolean hayRepuestoViejo() {
		return this.repuestos.stream()
				.anyMatch(repuesto -> repuesto.repuestoViejo());
	}	
}
