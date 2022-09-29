package ar.edu.unlp.info.oo1.ej12_VolYSupeDeSolidos;

public class Cilindro extends Pieza{
	private int radio;
	private int altura;
	
	public Cilindro(String material, String color, int radio, int altura) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}
	
	public int getRadio() {
		return radio;
	}
	public int getAltura() {
		return altura;
	}
	
	public double volumen() {
		return Math.PI * Math.pow(radio, 2) * this.getAltura();
	}
	
	public double superficie() {
		return 2 * Math.PI * this.radio * this.altura + 2 * Math.PI * Math.pow(radio, 2);
	}
}
