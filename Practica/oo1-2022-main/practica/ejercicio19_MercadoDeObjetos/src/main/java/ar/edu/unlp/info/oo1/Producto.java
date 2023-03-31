package ar.edu.unlp.info.oo1;

public class Producto {
	private String nombre;
	private String descripcion;
	private double precio;
	private int unidadesDisponibles;

	public Producto (String nombre, String descripcion, double precio, int unidadesDisponibles) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.setUnidadesDisponibles(unidadesDisponibles);
	}

	/*GETTERS Y SETTERS*/
	public String getNombre() {
		return nombre;
	}
	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}
	public void setUnidadesDisponibles(int unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}
	public double getPrecio() {
		return precio;
	}
	/**/

	public boolean hayStock(int cantidadPedida) {
		return this.getUnidadesDisponibles() > cantidadPedida;
	}

	public void actualizarStock(int cantidad) {
		this.setUnidadesDisponibles(Math.max(0, this.getUnidadesDisponibles() - cantidad));
	}
	
	
	
	
}
