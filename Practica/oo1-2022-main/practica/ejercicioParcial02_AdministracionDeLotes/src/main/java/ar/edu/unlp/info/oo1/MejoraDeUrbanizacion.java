package ar.edu.unlp.info.oo1;

public class MejoraDeUrbanizacion {
	private double costo;
	private String descripcion;
	
	public MejoraDeUrbanizacion(double costo, String descripcion) {
		this.costo = costo;
		this.descripcion = descripcion;
	}

	public double getCosto() {
		return costo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
}
