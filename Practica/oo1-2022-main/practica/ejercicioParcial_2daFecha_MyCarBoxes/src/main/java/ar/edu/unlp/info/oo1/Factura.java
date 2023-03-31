package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class Factura {
	
	private LocalDate fecha;
	private boolean descuento;
	private String patente;
	private double costo;
	
	public Factura(String patente, double costo, boolean descuento) {
		this.patente = patente;
		this.costo = costo;
		this.descuento = descuento;
		this.fecha = LocalDate.now();
	}
	
	public double montoFinal() {
		if (descuento) {
			return this.costo*0.95;
		} else
			return costo;
		
	}

	public LocalDate getFecha() {
		return fecha;
	}
	public String getPatente() {
		return patente;
	}
	
}
