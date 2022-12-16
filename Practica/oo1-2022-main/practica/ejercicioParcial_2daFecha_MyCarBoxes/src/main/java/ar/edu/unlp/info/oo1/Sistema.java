package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Orden> ordenes;
	private List<Empleado> empleados;
	private List<Repuesto> repuestos;
	
	public Sistema() {
		this.ordenes = new ArrayList<Orden>();
	}

	public List<Orden> getOredenes() {
		return ordenes;
	}
	
	public Repuesto altaRepuesto(String nombre, LocalDate fechaFabricacion, double costo) {
		Repuesto repuesto = new Repuesto(nombre, fechaFabricacion, costo);
		this.repuestos.add(repuesto);
		return repuesto;
	}
	
	public Empleado altaEmpleado(String nombreCompleto, double valorHora) {
		Empleado empleado = new Empleado(nombreCompleto, valorHora);
		this.empleados.add(empleado);
		return empleado;
	}
	
	public OrdenCompra registrarOrdenDeCompra(String patente, List<Repuesto> repuestos) {
		OrdenCompra orden = new OrdenCompra(patente, repuestos);
		this.ordenes.add(orden);
		return orden;
	}
	
	public OrdenReparacion registrarOrdenDeReparacion(String patente, String descripcion, 
			List<Repuesto> repuestos, List<Empleado> empleados, int cantHoras) {
		OrdenReparacion orden = new OrdenReparacion(patente, descripcion, repuestos, empleados, cantHoras);
		this.ordenes.add(orden);
		return orden;
	}
	
	public List<Factura> facturarOrdenes(){
		List <Factura> facturas = new ArrayList<>();
		for (Orden o : this.ordenes) {
			facturas.add(new Factura(o.getPatente(), o.costo(), this.descuento(o)));
		}
		return facturas;
	}
	
	public boolean descuento(Orden orden) {
		return this.ordenes.stream()
				.anyMatch(o -> o != orden && o.getPatente().equals(orden.getPatente()) && this.esDelUltimoAnio(orden));
	}
	
	public boolean esDelUltimoAnio(Orden orden) {
		return (ChronoUnit.MONTHS.between(orden.getFechaOrden(), LocalDate.now()) >= 12);
		
	}
	
}
