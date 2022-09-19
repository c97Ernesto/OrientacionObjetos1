package ar.edu.info.oo1.ej4_figuras;

/*
 Crear interfaz para las figuras.
 */
public class Cuerpo3D {
	private double altura;
	private Figura caraBasal;
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getAltura(){
		return this.altura;
	}
	
	//Seteamos la figura recibida como parametro para utilizar sus metodos
	public void setCaraBasal(Figura caraBasal) { 
		this.caraBasal = caraBasal;
	}
	
	public double getVolumen() {
		return this.caraBasal.getArea() * altura;
	}
	public double getSuperficieExterior() { //area
		return ((2*this.caraBasal.getArea()) + (this.caraBasal.getPerimetro()*this.altura));
	}
	
}
