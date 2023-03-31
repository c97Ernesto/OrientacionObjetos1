package ar.edu.unlp.info.oo1;

import java.util.List;

public class BarrioPopular extends Barrio {
	
	private final int GASTO_FIJO_LOTE = 30000;
	private double costoDelAgrimensor;

	public BarrioPopular(String ciudad, int cantidadDeLotes) {
		super(ciudad, cantidadDeLotes);
	}
	
	public double getCostoDelAgrimensor() {
		return costoDelAgrimensor;
	}
	public void setCostoDelAgrimensor(double costoDelAgrimensor) {
		this.costoDelAgrimensor = costoDelAgrimensor;
	}
	
	private double gastosDeRegistros() {
		return this.GASTO_FIJO_LOTE + (this.getCostoDelAgrimensor() / this.getCantidadLotes());
	}

	@Override
	public double costoFinalDeLote() {
		return this.costoTotalDeMejoras() / this.getCantidadLotes() 
				+ this.gastosDeRegistros();
	}

	
	@Override
	protected double inversionEnBarrio() {
		return this.costoTotalDeMejoras();
	}



	@Override
	protected void agregarAPopular(List<Barrio> barriosPopulares) {
		barriosPopulares.add(this);	
	}
	
	
	
}
