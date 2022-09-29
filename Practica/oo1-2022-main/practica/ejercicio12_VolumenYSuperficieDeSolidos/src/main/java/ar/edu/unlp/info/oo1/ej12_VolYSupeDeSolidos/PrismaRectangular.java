package ar.edu.unlp.info.oo1.ej12_VolYSupeDeSolidos;

public class PrismaRectangular extends Pieza {
	private int ladoMayor;
	private int ladoMenor;
	private int altura;
	
	public PrismaRectangular(String material, String color, int ladoMayor, int ladoMenor, int altura) {
		super(material, color);
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
	}
	
	public int getLadoMayor() {
		return ladoMayor;
	}

	public int getLadoMenor() {
		return ladoMenor;
	}

	public int getAltura() {
		return altura;
	}
	
	public double volumen() {
		return this.getLadoMayor()*this.ladoMenor*this.altura;
	}
	public double superficie() {
		return 2*(this.ladoMayor*this.ladoMenor + this.ladoMenor*this.altura + this.ladoMayor*this.altura);
	}
}
