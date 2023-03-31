package ar.edu.unlp.info.oo1;

import java.util.List;

public class OrdenReparacion extends Orden{

	private String descripcion;
	private List<Empleado> empleados;
	private int cantHoras;

	public OrdenReparacion(String patente, String descripcion, List<Repuesto> repuestos, List<Empleado> empleados,
			int cantHoras) {
		super(patente, repuestos);
		this.descripcion = descripcion;
		this.empleados = empleados;
		this.cantHoras = cantHoras;		
	}

	@Override
	public double costo() {
		return (this.precioDeRepuestos() + this.costoEmpleado()) * 1.1;
	}
	
	public double costoEmpleado() {
		return this.empleados.stream()
				.mapToDouble(empleado -> empleado.getValorHora()*cantHoras)
				.sum();
	}

}
