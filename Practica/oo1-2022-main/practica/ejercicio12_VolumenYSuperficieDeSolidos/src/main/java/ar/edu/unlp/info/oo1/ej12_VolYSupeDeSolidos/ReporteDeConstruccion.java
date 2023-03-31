package ar.edu.unlp.info.oo1.ej12_VolYSupeDeSolidos;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {

	private List<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		piezas = new ArrayList<Pieza>();
	}
	
	public void agregarPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}
	
	/*Recibe como parámetro un nombre de material (un string, por ejemplo 'Hierro').
	Retorna la suma de los volúmenes de todas las piezas hechas en ese materia*/
	public double volumenDeMaterial(String material) {
		return this.piezas.stream()
				.filter(pieza -> pieza.getMaterial().equals(material)) //me quedo con un stream de piezas de dicho material
				.mapToDouble(pieza -> pieza.volumen())	//me quedo con otro stream pero de doubles
				.sum();	//me quedo con la suma del stream anterior
	}
	
	/*Recibe como parámetro un color (un string, por ejemplo 'Rojo'). Retorna la suma de
	las superficies externas de todas las piezas pintadas con ese colo*/
	public double superficieDeColor(String color) {
		return this.piezas.stream()
				.filter(pieza -> pieza.getColor().equals(color))
				.mapToDouble(pieza -> pieza.superficie())
				.sum();
		
	}
	
}
