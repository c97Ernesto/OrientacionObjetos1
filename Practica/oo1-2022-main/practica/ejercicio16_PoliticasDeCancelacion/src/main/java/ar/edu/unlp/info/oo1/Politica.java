package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public interface Politica {
	double reembolso(LocalDate fechaCancelacion, double precio);
}
