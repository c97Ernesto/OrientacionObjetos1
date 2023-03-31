package ar.edu.unlp.info.oo1;

import java.util.List;

public class NuevasUrbanizaciones extends Barrio {
	
	private double precioDelTerreno;

	public NuevasUrbanizaciones(String ciudad, int cantidadDeLotes, double precioDelTerreno) {
		super(ciudad, cantidadDeLotes);
		this.precioDelTerreno = precioDelTerreno;
	}

	public double getPrecioDelTerreno() {
		return precioDelTerreno;
	}
	
	@Override
	public double costoFinalDeLote() {
		return (this.costoTotalDeMejoras() + this.getPrecioDelTerreno())
				/ this.getCantidadLotes();
	}

	@Override
	protected double inversionEnBarrio() {
		return this.costoTotalDeMejoras() + this.getPrecioDelTerreno();
	}
	
	@Override
	protected void agregarAUrbano(List<Barrio> barrio) {
		barrio.add(this);
	}
	
}
