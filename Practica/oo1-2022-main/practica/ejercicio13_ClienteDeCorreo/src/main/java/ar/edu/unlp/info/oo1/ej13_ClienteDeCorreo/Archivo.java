package ar.edu.unlp.info.oo1.ej13_ClienteDeCorreo;

public class Archivo {
	private String nombre;
	
	public Archivo (String nombre) {
		this.nombre = nombre;
	}
	public Archivo() {
		
	}
	
	public String getNombre() {
		return nombre;
	}	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/*
	Para simplificar, asuma que el tamaño de un archivo es el largo de su nombre
	*/
	public int tamanio() {
		return this.getNombre().length();
	}
	
}
