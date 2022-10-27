package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
	
	private String nombre;
	private String direccion;
	private String dni;
	
	private List<Propiedad> propiedades;
//	private List<Reserva> reservas;
	
	public Usuario (String nombre, String direccion, String dni){
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		setPropiedades(new ArrayList<Propiedad>());
//		reservas = new ArrayList<Reserva>();	
	}
	
	public void setPropiedades(List<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}
	public List<Propiedad> getPropiedades() {
		return propiedades;
	}
	public void agregarPropiedad(Propiedad propiedad) {
		this.getPropiedades().add(propiedad);
	}
	
	public List<Propiedad> propiedadesDisponibles(DateLapse periodo) {
		return this.getPropiedades().stream()
				.filter(propiedad -> propiedad.disponible(periodo))
				.collect(Collectors.toList());
	}

//	public List<Reserva> getReservas() {
//		return reservas;
//	}	
//	public void agregarReserva(Reserva reserva) {
//		this.getReservas().add(reserva);
//	}
	
	//me quedo con las reservas de las propiedades del usuario según el inquilino
	public List<Reserva> reservasDelInquilino(Usuario inquilino) {
		return this.getPropiedades().stream()
				.map(propiedad -> propiedad.reservasDe(inquilino))	//las reservas del inquilino en las propiedades
				.flatMap(list -> list.stream())
				.filter(reserva -> reserva != null)
				.collect(Collectors.toList());
	}
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, double precioNoche, String direccion) {
		Propiedad propiedad = new Propiedad (nombre, descripcion, precioNoche, direccion);
		this.agregarPropiedad(propiedad);
		return propiedad;
	}
	
	 public double ingresos(DateLapse periodo) {
		return this.propiedades.stream()
				.mapToDouble(propiedad -> propiedad.ingresosDePropiedad(periodo))
				.sum();
	}
}
