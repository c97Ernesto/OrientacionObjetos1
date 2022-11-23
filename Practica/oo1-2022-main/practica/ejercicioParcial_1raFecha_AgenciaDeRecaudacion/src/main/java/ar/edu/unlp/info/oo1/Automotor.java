package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class Automotor extends Vehiculo{

	private String modelo;
	private String marca;

	public Automotor(String patente, LocalDate fechaFabricacion, double valor, Usuario contribuyente, String marca, String modelo) {
		super(patente, fechaFabricacion, valor, contribuyente);
		this.marca = marca;
		this.modelo = modelo;
	}

	@Override
	public double impuesto() {
		return this.getValor()*0.05;
	}
	
	
	
}
