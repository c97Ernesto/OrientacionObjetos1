package ar.edu.unlp.info.oo1.ej13_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	public Carpeta (String nombre){
		this.nombre = nombre;
		emails = new ArrayList<Email>();
	}
	
	public void agregarEmail(Email email) {
		emails.add(email);
	}
	public void eliminarEmail(Email email) {
		emails.remove(email);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Email busquedaEmail (String texto) {
		return this.emails.stream()
				.filter(email -> email.contiene(texto))
				.findFirst().orElse(null);
	}
	
	public int tamanioCarpeta() {
		return this.emails.stream()
				.mapToInt(email -> email.tamanioEmail())
				.sum();
	}
}
