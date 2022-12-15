package ar.edu.unlp.info.oo1.ej08_distribuidoraElectrica;

import java.util.ArrayList;
import java.util.List;

/*
 * El sistema permite registrar usuarios, para los cuales se indica nombre y dirección. Por
simplificación, un usuario puede estar relacionado con un solo domicilio (para el que se
registran los consumos).
*/

public class Usuario {
	private String domicilio;
	private String nombre;
	private List<Factura> facturas;
	private List<Consumo> consumos;
	
	public Usuario(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.consumos = new ArrayList<Consumo>();
		this.facturas = new ArrayList<Factura>();
	}
	
	public void agregarMedicion(Consumo medicion) {
		this.consumos.add(medicion);
	}
	
	public Consumo ultimoConsumoActiva() {
		return this.consumos.stream()
				.max((consumo1, consumo2) -> consumo1.getFecha().compareTo(consumo2.getFecha()))
				.orElse(null);
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		Consumo consumo = this.ultimoConsumoActiva();
		if (consumo.factorDePotencia() > 0.8) {
			Factura factura = new Factura(consumo.getConsumoEnergiaActiva(), consumo.costoEnBaseA(precioKWh)*0.10, this);
			this.facturas.add(factura);
			return factura;
		} else {
			Factura factura = new Factura(consumo.getConsumoEnergiaActiva(), 0, this);
			this.facturas.add(factura);
			return factura;
		}
	}
	
	public List<Factura> facturas() {
		return this.facturas;
	}
	
}
