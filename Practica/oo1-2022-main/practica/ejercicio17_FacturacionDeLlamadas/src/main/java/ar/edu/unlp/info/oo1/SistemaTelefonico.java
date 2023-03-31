package ar.edu.unlp.info.oo1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaTelefonico {
	
	private List<NumeroTelefonico> numerosDisponibles;
	
	public SistemaTelefonico() {
		numerosDisponibles = new ArrayList<NumeroTelefonico>();
	}
	
	public void setNumero(NumeroTelefonico numero) {
		this.numerosDisponibles.add(numero);
	}
	
//	Agregar un número a la lista de números disponibles. Se provee un número de teléfono. El
//	sistema lo agrega a la lista de números telefónicos disponibles. Asuma que el número de
//	teléfono que se provee es nuevo (nunca fue utilizado)
	public void agregarNumero(String num) {		
		NumeroTelefonico numero = new NumeroTelefonico(num);
		this.setNumero(numero);		
	}
	
	private NumeroTelefonico numeroDisponible() {		//return numero libre para asignar
		return this.numerosDisponibles.stream()
				.filter(n -> n.isDisponible())
				.findFirst().orElse(null);
	}
	
	private NumeroTelefonico numeroRegistrado(String numero) {	//return numero que tiene asignado un cliente
		return this.numerosDisponibles.stream()
				.filter(n -> !n.isDisponible() && n.equals(numero))
				.findAny().orElse(null);
	}
	
//	Dar de alta como cliente a una persona física (un individuo). Se provee nombre, dirección,
//	dni. El sistema da de alta el cliente y le asigna un número telefónico de una lista de números de
//	teléfonos disponibles. El número asignado deja de estar disponible. El sistema retorna el cliente
	public Persona altaPersonaFisica(String nombre, String direccion, String numero, String dni) {
		Fisica cliente = new Fisica(nombre, direccion, dni);
		cliente.setNumero(this.numeroDisponible());
		return cliente;		
	}
	
//	Dar de alta como cliente a una persona jurídica (empresa, organismo, asociación, etc,). Se
//	provee nombre, dirección, CUIT y tipo de persona jurídica (por ejemplo Sociedad Anónima,
//	Repartición Provincial, etc.). El sistema da de alta el cliente y le asigna un número telefónico de
//	una lista de números de teléfonos disponibles. El número asignado deja de estar disponible. El
//	sistema retorna el cliente.
	public Persona altaPersonaJuridica(String nombre, String direccion, String cuit, String tipoPersona) {
		Juridica cliente = new Juridica (nombre, direccion, cuit, tipoPersona);
		cliente.setNumero(this.numeroDisponible());
		return cliente;
	}
	
//	Registrar una llamada local. Se provee la fecha y hora de comienzo, la duración en minutos, el
//	número del teléfono que llama y el del teléfono que recibe. El sistema guarda el registro de la
//	llamada. El sistema retorna el registro de la llamada.
	public Local registrarLlamadaLocal(LocalDateTime fechaYHora, int duracion, String emisor, String receptor) {
		Local llamada = new Local(fechaYHora, duracion, emisor, receptor);
	    this.numeroRegistrado(emisor).agregarRegistro(llamada);
		return llamada;
	}

//	Registrar una llamada interurbana. Se provee la fecha y hora de comienzo, la duración en
//	minutos, el número del teléfono que llama y el del teléfono que recibe. Se provee la distancia en
//	kilómetros entre el que llama y el que recibe. El sistema guarda el registro de la llamada. El
//	sistema retorna el registro de la llamada
	public Interurbana registrarLlamadaInterurbana(LocalDateTime fechaYHora, String horaInicio, int duracion, String numeroEmisor, String numeroReceptor, double distancia) {
		Interurbana llamada = new Interurbana(fechaYHora, duracion, numeroEmisor, numeroReceptor, distancia);
		this.numeroRegistrado(numeroEmisor).agregarRegistro(llamada);
		return llamada;
	}
	
//	Registrar una llamada internacional. Se provee la fecha y hora de comienzo, la duración en
//	minutos, el número del teléfono que llama y el del teléfono que recibe. Se provee del país de
//	origen y país destino de la llamada. El sistema guarda el registro de la llamada. El sistema
//	retorna el registro de la llamada.
	public Internacional registrarLlamadaInternacional(LocalDateTime fechaYHora, int duracion, String numeroEmisor, String numeroReceptor, String paisOrigen, String paisDestino) {
		Internacional llamada = new Internacional(fechaYHora, duracion, numeroEmisor, numeroReceptor, paisOrigen, paisDestino);
		this.numeroRegistrado(numeroEmisor).agregarRegistro(llamada);
		return llamada;
	}
	
//	Facturar las llamadas de un cliente. Se indica el cliente para el cual se quiere facturar. Se
//	indican las fechas de inicio y fin del período a considerar. El sistema retorna una factura en la
//	que consta: el cliente al que pertenece, la fecha de facturación, las fechas de inicio y fin del
//	período, y el monto total de todas las llamadas que el cliente hizo, y que iniciaron en ese
//	período.
	public Factura facturar(Persona cliente, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return new Factura(cliente, fechaInicio, fechaFin);
	}
	

}
