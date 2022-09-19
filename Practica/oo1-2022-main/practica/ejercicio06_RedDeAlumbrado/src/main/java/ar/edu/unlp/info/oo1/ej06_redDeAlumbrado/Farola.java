package ar.edu.unlp.info.oo1.ej06_redDeAlumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private Boolean estado;
	private List<Farola> neighbors;
	/*
	* Crear una farola. Debe inicializarla como apagada
	*/
	public Farola () {
		this.estado = false;
		this.neighbors = new ArrayList<Farola>();
	}
	
	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos
	entre las farolas es recíproca, es decir el receptor del mensaje será vecino
	de otraFarola, al igual que otraFarola también se convertirá en vecina del
	receptor del mensaje.
	La colección de una va a estar metida en la otra
	*/
	public void pairWithNeighbor( Farola otraFarola ) {
		this.neighbors.add(otraFarola);		
		otraFarola.getNeighbors().add(this);
	}
	
	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors (){
		return this.neighbors;
	}
	
	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if (!this.estado) {
			this.estado = true;
			this.getNeighbors().forEach(farola -> farola.turnOn());
		}
		
	}
	
	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
		if (this.estado) {
			this.estado = false;
			this.getNeighbors().forEach(farola -> farola.turnOff());
		}
	}

	public boolean isOn() {
		return this.estado;
	}
}
