package ar.edu.unlp.info.oo1;

import java.time.LocalDateTime;

public class Internacional extends Llamada{
	private String paisOrigen;
	private String paisDestino;
	
	public Internacional(LocalDateTime fechaYHora, int duracion, String numeroEmisor,
			String numeroReceptor, String origen, String destino) {
		super(fechaYHora, duracion, numeroEmisor, numeroReceptor);
		this.paisOrigen = origen;
		this.paisDestino = destino;
	}


	public String getPaisOrigen() {
		return paisOrigen;
	}
	public String getPaisDestino() {
		return paisDestino;
	}
	
//	Las llamadas internacionales tienen un costo por minuto que depende del
//	país destino y de la hora (el precio diurno de 8:00 a 20:00 es un valor, y
//	precio nocturno de 20:00 a 8:00 es otro). Por ahora utilice $4 como precio
//	diurno para todos los países y $3 como precio nocturno para todos los
//	países.
	@Override
	public double costo() {
		if ((this.getFechaYHora().getHour() >= 8) && (this.getFechaYHora()).getHour() <= 20){
			return super.precioLlamada(4);
		} else {
			return super.precioLlamada(3);
		}
	}
	
}
