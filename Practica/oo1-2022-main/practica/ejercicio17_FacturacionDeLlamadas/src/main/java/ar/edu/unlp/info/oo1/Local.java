package ar.edu.unlp.info.oo1;

import java.time.LocalDateTime;

public class Local extends Llamada{

	public Local(LocalDateTime fechaYHora, int duracion, String numeroEmisor, String numeroReceptor) {
		super(fechaYHora, duracion, numeroEmisor, numeroReceptor);
	}

	@Override
	public double costo() {
		return super.precioLlamada(1);
	}
}
