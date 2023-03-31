package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class Embarcacion extends Vehiculo{

	private String nombre;

	public Embarcacion(String patente, LocalDate fechaFabricacion, double valor, Usuario contribuyente, 
			String nombre) {
		super(patente, fechaFabricacion, valor, contribuyente);
		this.nombre = nombre;
	}
	

	@Override
	public double impuesto() {
		if (this.masDeDiezAnios()) {
			return 0;
		} else {
			if (this.getValor() < 1000000) {
				return this.getValor()*0.10;
			} else
				return this.getValor()*0.15;
		}
	}

}
