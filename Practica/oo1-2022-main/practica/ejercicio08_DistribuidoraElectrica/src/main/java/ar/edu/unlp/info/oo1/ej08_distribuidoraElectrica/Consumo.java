package ar.edu.unlp.info.oo1.ej08_distribuidoraElectrica;

import java.time.LocalDate;
/*
 * El sistema permite registrar los consumos para los usuarios. Los consumos que se
registran para los usuarios tienen dos componentes, el consumo de energía activa y el
consumo de energía reactiva.
*/
public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo(LocalDate fecha, double consumoEnergiaActiva, double consumoEnergiaReactiva ) {
		this.fecha = fecha;
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
	}
	public double getConsumoEnergiaActiva() {
		return consumoEnergiaActiva;
	}
	public double getConsumoEnergiaReactiva() {
		return consumoEnergiaReactiva;
	}
	
	public double costoEnBaseA(double precioKWh) {
		return (this.getConsumoEnergiaActiva() * precioKWh);
	}
	
	public double factorDePotencia() {
		return (this.getConsumoEnergiaActiva()/(Math.sqrt(Math.pow(this.getConsumoEnergiaActiva(), 2)+Math.pow(this.getConsumoEnergiaReactiva(), 2))));
	}

	public LocalDate getFecha() {
		return fecha;
	}
}
