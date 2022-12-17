package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdministracionDeLotes {
	private List<Barrio> barrios;
	
	public AdministracionDeLotes() {
		this.barrios = new ArrayList<Barrio>();
	}

	public List<Barrio> getBarrios() {
		return barrios;
	}
	
	public int lotesAUrbanizar() {
		return this.getBarrios().stream()
				.mapToInt(barrio -> barrio.getCantidadLotes())
				.sum();
	}
	
	public double inversionARealizar() {
		return this.getBarrios().stream()
				.mapToDouble(barrio -> barrio.inversionEnBarrio())
				.sum();
	}
	
	public String preciosPromediosLotes(String ciudad) {
		List<Barrio> barriosDeLaCiudad = this.barrios.stream()
				.filter(barrio -> barrio.getCiudad().equals(ciudad))
				.collect(Collectors.toList());
		
		return imprimirPromedios(this.promedioEnPopular(barriosDeLaCiudad), this.promedioEnUrbanizacion(barriosDeLaCiudad));
	}
	
	public double promedioEnPopular(List<Barrio> barriosDeLaCiudad) {
		List<Barrio> barriosPopulares = new ArrayList<Barrio>();
		barriosDeLaCiudad.stream()
		.forEach(b -> b.agregarAPopular(barriosPopulares));
		return this.calcularPromedio(barriosPopulares);
	}
	
	public double promedioEnUrbanizacion(List<Barrio> barriosDeLaCiudad) {
		List<Barrio> barriosUrbanizados = new ArrayList<Barrio>();
		barriosDeLaCiudad.stream()
		.forEach(b -> b.agregarAUrbano(barriosUrbanizados));
		return this.calcularPromedio(barriosUrbanizados);
	}
	
	private double calcularPromedio(List<Barrio> barrios) {
		return barrios.stream()
				.mapToDouble(b -> b.costoFinalDeLote())
				.average()
				.getAsDouble();
	}
	
	private String imprimirPromedios(double promedioPopular, double promedioUrbano) {
		return "Precio promedio barrio Popular: " + promedioPopular + "- Promedio nueva urbanizacion: "
				+ promedioUrbano;
	}
	
}
