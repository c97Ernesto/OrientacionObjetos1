package ar.edu.unlp.info.oo1;

import java.util.List;

public abstract class Persona {
	private String nombre;
	private String direccion;
	private NumeroTelefonico numero;
	
	
	public Persona(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		
	}

	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public NumeroTelefonico getNumero() {
		return numero;
	}
	public void setNumero(NumeroTelefonico numero) {
		this.numero = numero;
	}
	
	public List<Llamada> registroDeLlamadas(){
		return this.getNumero().getRegistroDeLlamadas();
	}
	

}
