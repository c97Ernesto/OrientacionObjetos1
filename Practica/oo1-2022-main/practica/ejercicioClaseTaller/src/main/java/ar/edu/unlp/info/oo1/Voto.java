package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Voto {
	private LocalDateTime fecha;
	private Usuario autor;
	private boolean esPositivo;
	
	public Voto(Usuario autor, boolean b) {
		this.autor = autor;
		this.esPositivo = b;
		this.fecha = LocalDateTime.now();
	}

	public boolean esPositivo() {
		return this.esPositivo;
	}
}
