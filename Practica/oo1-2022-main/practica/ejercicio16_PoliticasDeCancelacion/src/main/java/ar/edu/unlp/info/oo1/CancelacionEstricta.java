package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class CancelacionEstricta implements Politica{

	@Override
	public double reembolso(LocalDate fechaCancelacion, double precio) {
		return 0;
	}

}
