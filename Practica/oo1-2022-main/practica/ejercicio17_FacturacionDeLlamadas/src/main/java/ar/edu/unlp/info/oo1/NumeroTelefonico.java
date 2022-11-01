package ar.edu.unlp.info.oo1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumeroTelefonico {
	private String numero;
	private Persona cliente;
	private List<Llamada> registroDeLlamadas;
	
	public NumeroTelefonico(String numero) {
		this.numero = numero;
		this.registroDeLlamadas = new ArrayList<Llamada>();
	}
	
	public String getNumero() {
		return numero;
	}
	public void setDisponible(Persona cliente) {
		this.cliente = cliente;
	}
	
	public boolean isDisponible() {
		return cliente.equals(null);
	}

	public List<Llamada> getRegistroDeLlamadas() {
		return registroDeLlamadas;
	}
	
	public void agregarRegistro(Llamada llamada) { 
		this.getRegistroDeLlamadas().add(llamada);
	}
	
	public List<Llamada> periodoDeLlamadas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return this.getRegistroDeLlamadas().stream()
				.filter(llamada -> llamada.periodoFecha(fechaInicio, fechaFin))
				.collect(Collectors.toList());
	}
	
}
