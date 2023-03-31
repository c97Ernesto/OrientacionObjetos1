package ar.edu.unlp.info.oo1.ej11_ElInversor;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
	private String nombre;
	private List<Inversion> inversiones;
	
	public Inversor(String nombre) {
		this.nombre = nombre;
		inversiones = new ArrayList<Inversion>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void agregarInversion(Inversion inversion) {
		inversiones.add(inversion);
	}
	
}
