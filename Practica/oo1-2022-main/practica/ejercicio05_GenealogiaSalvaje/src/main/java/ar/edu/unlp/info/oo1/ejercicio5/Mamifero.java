package ar.edu.unlp.info.oo1.ejercicio5;

import java.time.LocalDate;

public class Mamifero {
	private String id;
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero(String id) {
		this.id = id;
	}
	public Mamifero() {
		
	}
	
	public String getIdentificador() {
		return id;
	}
	public void setIdentificador(String id) {
		this.id = id;
	}
	
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	
	public Mamifero getAbueloMaterno() {
		if ((this.getMadre() != null) && (this.getMadre().getPadre()) != null) { //última linea esta de más pensarla
			return(this.getMadre().getPadre());
		} 
		else return null;
	}
	public Mamifero getAbuelaMaterna() {
		if (this.getMadre() != null && this.getMadre().getMadre() != null) {
			return(this.getMadre().getMadre());
		} 
		else return null;
	}
	public Mamifero getAbueloPaterno() {
		if ((this.getPadre() != null) && (this.getPadre().getPadre() != null))
			return(this.getPadre().getPadre());
		else return null;
	}
	public Mamifero getAbuelaPaterna() {
		if ((this.getPadre() != null) && (this.getPadre().getMadre() != null))
			return(this.getPadre().getMadre());
		else return null;
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero){
		return 
	}
	//metodos para fijarme por el lado del padre y otro para el de la madre
	
}
