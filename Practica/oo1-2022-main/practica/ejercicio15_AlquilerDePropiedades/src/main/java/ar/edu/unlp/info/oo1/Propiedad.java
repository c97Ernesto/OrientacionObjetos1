package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private double precioNoche;
	private String direccion;
	
	//private Usuario propietario;
	private List<Reserva> reservas;
	
	public Propiedad (String nombre, String descripcion, double precioNoche, String direccion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.setPrecioNoche(precioNoche);
		this.direccion = direccion;
//		this.propietario = propietario;
		this.reservas = new ArrayList<Reserva>();
	}
	
//	public Usuario getPropietario() {
//		return propietario;
//	}
	
	public double getPrecioNoche() {
		return precioNoche;
	}
	public void setPrecioNoche(double precioNoche) {
		this.precioNoche = precioNoche;
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	//retorno true si algún elemento del stream coincide con la función dada o el el stream está vacío.
	public boolean disponible (DateLapse periodo) {
		return this.getReservas().stream()
				.noneMatch(reserva -> !reserva.perteneceAlPeriodo(periodo));
	}
	
	public void agregarReserva(Reserva reserva) {
		this.getReservas().add(reserva);
	}
	
	public List<Reserva> reservasDe(Usuario inquilino) {
		return this.getReservas().stream()
				.filter(reserva -> reserva.getInquilino().equals(inquilino))
				.collect(Collectors.toList());
	}
	
	public double ingresosDePropiedad(DateLapse periodo) {
		return this.getReservas().stream()
				.filter(reserva -> reserva.perteneceAlPeriodo(periodo))
				.mapToDouble(reserva -> reserva.precioDeReserva())
				.sum();
	}
}
