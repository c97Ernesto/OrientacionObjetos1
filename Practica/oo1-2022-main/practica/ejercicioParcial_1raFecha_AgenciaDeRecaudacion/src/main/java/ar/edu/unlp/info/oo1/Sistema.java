package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	private List<Usuario> contribuyentes;
	
	public Sistema() {
		this.contribuyentes = new ArrayList<Usuario>();
	}

	public List<Usuario> getContribuyentes() {
		return contribuyentes;
	}
	
	public Usuario altaContribuyente(String nombre, String dni, String email, String localidad){
		Usuario contribuyente = new Usuario(nombre, dni, email, localidad);
		this.getContribuyentes().add(contribuyente);
		return contribuyente;
	}
	
	public double impuestoDelContribuyente(Usuario contribuyente) {
		return contribuyente.calcularImpuesto();	
	}
	
	public List<Usuario> contribuyentesQuePaganMás(String localidad, int numeroN) {
		return this.getContribuyentes().stream()
				.filter(user -> user.getLocalidad().equals(localidad))
				.sorted((user1, user2) -> Double.compare(user2.calcularImpuesto(), user1.calcularImpuesto()))
				.limit(numeroN)
				.collect(Collectors.toList());
		
	}
}
