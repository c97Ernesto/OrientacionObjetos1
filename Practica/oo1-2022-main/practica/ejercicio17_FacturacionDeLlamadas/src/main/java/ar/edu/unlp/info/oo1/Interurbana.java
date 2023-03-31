package ar.edu.unlp.info.oo1;

import java.time.LocalDateTime;

public class Interurbana extends Llamada{
	private double distancia;

	public Interurbana(LocalDateTime fechaYHora, int duracion, String numeroEmisor,
			String numeroReceptor, double distancia) {
		super(fechaYHora, duracion, numeroEmisor, numeroReceptor);
		this.distancia = distancia;
	}
	
	public double getDistancia() {
		return distancia;
	}

	@Override
	public double costo() {
		double monto;
		if (this.distancia < 100) {
			monto = super.precioLlamada(2);
		}
		else if (this.distancia >= 100 && this.distancia <= 500){
			monto = super.precioLlamada(2.5);
		}
		else monto = super.precioLlamada(3);
		return monto + 5;
	}

}
