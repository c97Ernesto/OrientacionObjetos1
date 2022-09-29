package ar.edu.unlp.info.oo1.ej12_VolYSupeDeSolidos;

public class Esfera extends Pieza{
	private int radio;
	
	public Esfera(String material, String color, int radio) {
		super(material, color);
		this.radio = radio;
	}

	public int getRadio() {
		return radio;
	}
	
	public double volumen() {
		return ((4/3)*Math.PI*(Math.pow(radio, 3)));
	}
	
	public double superficie() {
		return (4*Math.PI*Math.pow(radio, 2));
	}
}
