package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class CancelacionModerada implements Politica{
	
	@Override
	public double reembolso(LocalDate fechaCancelacion, double precio) {
		DateLapse periodo = new DateLapse(fechaCancelacion, LocalDate.now()); 
		if (periodo.sizeInDays() > 7) {
			return precio;
		} else if (periodo.sizeInDays() < 2){
			return precio*0.5;
		}
		return 0;
	}

}
