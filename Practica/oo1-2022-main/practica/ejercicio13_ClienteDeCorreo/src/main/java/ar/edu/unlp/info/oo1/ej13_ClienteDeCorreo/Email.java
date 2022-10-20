package ar.edu.unlp.info.oo1.ej13_ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<Archivo>();
	}
	
	public void agregarAdjunto(Archivo archivo) {
		this.adjuntos.add(archivo);
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	public String getCuerpo() {
		return this.cuerpo;
	}
	
	public List<Archivo> getAdjuntos(){
		return this.adjuntos;
	}
	
	/*
	El tamaño de un email es la suma del largo del título, el largo del cuerpo, y del
	tamaño de sus adjuntos.
	*/
	public int tamanioEmail() {
		return this.titulo.length() +
				this.cuerpo.length() +
				this.tamanioAdjuntos();
	}
	private int tamanioAdjuntos() {
		return this.adjuntos.stream()
				.mapToInt(archivo -> archivo.tamanio())
				.sum();
	}
	
	public boolean contiene(String texto) {
		return (this.getCuerpo() + this.getTitulo()).contains(texto);
	}
	
}
