package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public abstract class Barrio {
	private String ciudad;
	private int cantidadLotes;
	private List<MejoraDeUrbanizacion> mejoras;
	
	public Barrio(String ciudad, int cantidadDeLotes) {
		this.ciudad = ciudad;
		this.cantidadLotes = cantidadDeLotes;
		this.mejoras = new ArrayList<MejoraDeUrbanizacion>();
	}

	public String getCiudad() {
		return ciudad;
	}
	public int getCantidadLotes() {
		return cantidadLotes;
	}
	public List<MejoraDeUrbanizacion> getMejoras() {
		return mejoras;
	}
	public void agregarMejora(MejoraDeUrbanizacion mejora) {
		this.getMejoras().add(mejora);
	}
	
	protected double costoTotalDeMejoras() {
		return this.getMejoras().stream()
				.mapToDouble(mejora -> mejora.getCosto())
				.sum();
	}
	
	
	public abstract double costoFinalDeLote();
	
	protected abstract double inversionEnBarrio();
	
	protected void agregarAUrbano(List<Barrio> barriosUrbanos) {} 
	
	protected void agregarAPopular(List<Barrio> barriosPopulares) {}

	
}
