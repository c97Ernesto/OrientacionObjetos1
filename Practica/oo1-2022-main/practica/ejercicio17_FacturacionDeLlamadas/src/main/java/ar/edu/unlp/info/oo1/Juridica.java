package ar.edu.unlp.info.oo1;

public class Juridica extends Persona{
	private String cuit;
	private String tipoJuridica;

	public Juridica(String nombre, String direccion,  String cuit, String tipo) {
		super(nombre, direccion);
		this.cuit = cuit;
		this.tipoJuridica = tipo;
	}
	
	

}
