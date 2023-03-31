package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class CancelacionFlexible implements Politica{

	@Override
	public double reembolso(LocalDate fechaCancelacion, double precio) {
		return precio;
	}
	
}
