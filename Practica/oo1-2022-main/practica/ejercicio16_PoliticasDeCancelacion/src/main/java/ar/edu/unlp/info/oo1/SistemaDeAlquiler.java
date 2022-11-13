package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaDeAlquiler {
	private List<Usuario> usuarios;
	
	public SistemaDeAlquiler() {
		this.setUsuarios(new ArrayList<Usuario>());
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
	/*Registrar usuarios: Se provee nombre, dirección, dni. El sistema da de alta el usuario. El
	sistema retorna el Usuario. El usuario no tiene propiedades en alquiler. El usuario no tiene
	ninguna reserva de propiedad. El usuario no ha alquilado nunca una propiedad.*/
	public Usuario registrarUsuario(String nombre, String direccion, String dni) {
		Usuario usuario = new Usuario(nombre, direccion, dni);
		this.getUsuarios().add(usuario);
		return usuario;
	}

//	Registrar una propiedad en alquiler: Se provee nombre, descripción, precio por noche, y
//	dirección. Adicionalmente se indica la política de cancelación. El sistema da de alta la
//	propiedad y la retorna. La propiedad no tiene ninguna fecha ocupada.
//	La política de cancelación puede ser una de tres: flexible, moderada, o estricta
	public Propiedad registrarPropiedad(String nombre, String descripcion, double precioNoche, String direccion, Usuario propietario, Politica politica) {
		//el usuario conoce las propiedades, él las da de alta.
		return propietario.registrarPropiedad(nombre, descripcion, precioNoche, direccion, politica);
	}
	
	// la coleccion tiene que ser instanciada por el objeto que lo necesita, no por otra clase, se podría llegar a obviar la lista de listas
	
	/*
	Buscar propiedades disponibles en un período: Se indica el período (fecha de inicio y
	fecha de fin). Retorna todas las propiedades que se encuentran disponibles desde la fecha
	de inicio (inclusive) hasta el día de fin (inclusive)
	*/
	public List<Propiedad> propiedadesDisponibles(LocalDate fechaInicio, LocalDate fechaFin) {
		return this.getUsuarios().stream()
				.map(usuario -> usuario.propiedadesDisponibles(new DateLapse (fechaInicio, fechaFin))) //lista de listas, de reservas
				.flatMap(list -> list.stream())	
				.collect(Collectors.toList());
	}
	
	
	/*Hacer una reserva: Se indica la propiedad, el período y el usuario para quien se hace la
	reserva (el inquilino). Si la propiedad está libre, se genera la reserva (que queda registrada
	en el sistema). La propiedad pasa a estar ocupada en esas fechas. Si la propiedad no está
	libre no hace nada y retorna null. Ver notas al final de este ejercicio sobre cómo podría
	resolver este punto.*/
	public void hacerReserva(Propiedad propiedad, DateLapse periodo, Usuario inquilino) {
		if (propiedad.disponible(periodo)) {
			Reserva reserva = new Reserva(propiedad, periodo, inquilino);
			propiedad.agregarReserva(reserva);
		}
	}
	
	/*Calcular el precio de una reserva: dada una reserva, obtener el precio a partir del precio
	por noche de la propiedad y la cantidad de noches de la reserva.*/
	public double calcularPrecioDeReserva(Reserva reserva) {
		return reserva.precioDeReserva();
	}
	
	/*Eliminar reserva: Dada una reserva, si la fecha de inicio de la reserva es posterior a la
	fecha actual se elimina la reserva. La propiedad pasa a estar disponible en esas fechas.*/
	public void eliminarReserva(Reserva reserva) {		
		if (reserva.getPeriodo().getFrom().isAfter(LocalDate.now())) {
			reserva = null;
		}
	}
	
	/*Obtener las reservas de un usuario: dado un usuario, obtener todas las reservas que ha
	efectuado (pasadas o futuras).*/
	public List<Reserva> reservasDeUsuario(Usuario cliente) {
		return this.usuarios.stream()
				.map(usuario -> usuario.reservasDelInquilino(cliente))	//lista de listas, de reservas del inquilino
				.flatMap(list -> list.stream())	//lista de reservas del inquilino
				.collect(Collectors.toList());
	}
	
	
	/*Calcular los ingresos de un propietario: dado un usuario, y dos fechas, obtener el monto
	total que conseguirá por todas las reservas, de todas sus propiedades, entre las fechas
	indicadas.*/
	public double ingresosDePropietario(Usuario propietario, LocalDate fecha1, LocalDate fecha2) {
		return propietario.ingresos(new DateLapse(fecha1, fecha2));
	}
	
	public double calcularReembolso(Reserva reserva, LocalDate fechaCancelacion) {
		return reserva.reembolsoDeReserva(fechaCancelacion);
	}

}
