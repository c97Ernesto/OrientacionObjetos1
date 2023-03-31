package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class ReciboDeSueldo {

	private String nombre;
	private String apellido;
	private String cuil;
	private double aniosAntiguedad;
	private LocalDate now;
	private double montoACobrar;

	public ReciboDeSueldo(String nombre, String apellido, String cuil, double aniosAntiguedad, LocalDate now,
			double montoACobrar) {
				this.nombre = nombre;
				this.apellido = apellido;
				this.cuil = cuil;
				this.aniosAntiguedad = aniosAntiguedad;
				this.now = now;
				this.montoACobrar = montoACobrar;
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCuil() {
		return cuil;
	}

	public double getAniosAntiguedad() {
		return aniosAntiguedad;
	}

	public LocalDate getNow() {
		return now;
	}

	public double getMontoACobrar() {
		return montoACobrar;
	}

	
	
}
