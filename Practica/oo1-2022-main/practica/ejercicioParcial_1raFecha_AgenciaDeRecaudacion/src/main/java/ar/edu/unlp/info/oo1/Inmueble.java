package ar.edu.unlp.info.oo1;

public class Inmueble implements Bien{

	private String numPartida;
	private double valorLote;
	private double valorEdificacion;
	private Usuario contribuyente;

	public Inmueble(String numPartida, double valorLote, double valorEdificacion, Usuario contribuyente) {
		this.numPartida = numPartida;
		this.valorLote = valorLote;
		this.valorEdificacion = valorEdificacion;
		this.contribuyente = contribuyente;
	}
	
	public double valorInmueble() {
		return this.valorLote + this.valorEdificacion;
	}
	
	public double impuesto() {
		return this.valorInmueble()*0.01;
	}

}
