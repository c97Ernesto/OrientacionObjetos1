package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;
	private String dni;
	private String email;
	private String localidad;
	private List<Bien> bienes;

	public Usuario(String nombre, String dni, String email, String localidad) {
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.localidad = localidad;
		this.bienes = new ArrayList<Bien>();
	}
	
	public List<Bien> getBienes() {
		return bienes;
	}
	
	public Inmueble altaInmueble(String numPartida, double valorLote, double valorEdificacion,
			Usuario contribuyente) {
		Inmueble inmueble = new Inmueble(numPartida, valorLote, valorEdificacion, contribuyente);
		this.getBienes().add(inmueble);
		return inmueble;
	}
	
	public Automotor altaAutomor(String patente, LocalDate fechaFabricacion, 
			 double valor, Usuario contribuyente, String marca, String modelo) {
		Automotor automotor = new Automotor(patente, fechaFabricacion, valor, contribuyente, marca, modelo);
		this.getBienes().add(automotor);
		return automotor;
	}
	
	public Embarcacion altaEmbarcacion(String patente, LocalDate fechaFabricacion, double valor, 
			Usuario contribuyente, String nombre) {
		Embarcacion embarcacion = new Embarcacion(patente, fechaFabricacion, valor, contribuyente, nombre);
		this.getBienes().add(embarcacion);
		return embarcacion;
	}
	
	public double calcularImpuesto() {
		return this.getBienes().stream()
				.mapToDouble(bien -> bien.impuesto())
				.sum();
	}

	public String getLocalidad() {
		return localidad;
	}
	
	
}
