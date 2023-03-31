package ar.edu.unlp.info.oo1;

import java.time.LocalDateTime;

public abstract class Llamada {
	private LocalDateTime fechaYHora;
	private int duración;
	private String numeroEmisor;
	private String numeroReceptor;
	
	public Llamada(LocalDateTime fechaYHora, int duracion, String numeroEmisor, String numeroReceptor) {
		this.fechaYHora = fechaYHora; 
		this.duración = duracion;
		this.numeroEmisor = numeroEmisor;
		this.numeroReceptor = numeroReceptor;
	}
	
	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}
	public int getDuración() {
		return duración;
	}
	public String getNumeroEmisor() {
		return numeroEmisor;
	}
	public String getNumeroReceptor() {
		return numeroReceptor;
	}
	
	public boolean periodoFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return this.fechaYHora.isAfter(fechaInicio) && this.fechaYHora.isBefore(fechaFin);
	}
	
	public double precioLlamada(double precio) {
		return this.duración*precio; 
	}
	 
	public abstract double costo();
}
