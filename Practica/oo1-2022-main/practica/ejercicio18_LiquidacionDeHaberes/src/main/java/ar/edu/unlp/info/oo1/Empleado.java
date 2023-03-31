package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String nombre;
	private String apellido;
	private String cuil;
	private LocalDate fechaNacimiento;
	private boolean hijosACargo;
	private boolean conyugueACargo;
	//fecha de inicio de la reclación laboral del empleado
	private LocalDate fechaInicio;
	private List<Contrato> contratos;

	public Empleado(String nombre, String apellido, String cuil, LocalDate fechaNacimiento, boolean hijosACargo, boolean conyugueACargo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.fechaNacimiento = fechaNacimiento;
		this.hijosACargo = hijosACargo;
		this.conyugueACargo = conyugueACargo;
		this.fechaInicio = LocalDate.now();
		this.contratos = new ArrayList<Contrato>();
	}

	public String getCuil() {
		return cuil;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public List<Contrato> getContratos() {
		return contratos;
	}
	
	
//Cargar el contrato de un empleado: Se indica el empleado, la fecha de inicio del contrato,
//la fecha de fin (si corresponde) y algunos valores adicionales dependiendo del tipo de
//contrato. Hay dos tipos de contratos:
	
//	1. Si el contrato es "por horas", se indica el valor-hora acordado, y el número de horas
//	que trabajará por mes. También se indica la fecha de fin del contrato.
	public void cargarContratoPorHoras(LocalDate inicioContrato, LocalDate fechaFin,
			double valorHora, int horasPorMes) {
		ContratoPorHoras contrato = new ContratoPorHoras(this, inicioContrato, horasPorMes, valorHora, fechaFin);
		this.getContratos().add(contrato);
	}
//	2. Si el contrato es "de planta", se indica el sueldo mensual acordado, el monto
//	acordado por tener cónyuge a cargo, y el monto acordado por tener hijos a cargo.
//	Estos contratos no tienen fecha de fin (nunca se vencen).
	public void cargarContratoDePlanta(LocalDate inicioContrato, double sueldoMensual,
			 double montoPorConyugue, double montoPorHijo) {
		ContratoDePlanta contrato = new ContratoDePlanta(this, inicioContrato, montoPorHijo, montoPorHijo, montoPorHijo);
		this.getContratos().add(contrato);
	}
	
	private Contrato contratoActual() {
		return this.getContratos().stream()
				.max((contratoX, contratoY) -> contratoX.getFechaInicio().compareTo(contratoY.getFechaInicio()))
				.orElse(null);
	}

	public boolean contratoVencido() {
		return !this.contratoActual().vigente();
	}
	
	public boolean contratoActivo() {
		return !this.contratoVencido();
	}
	
	public ReciboDeSueldo generarRecibo() {
		ReciboDeSueldo recibo = new ReciboDeSueldo(this.nombre, this.apellido, this.cuil, this.aniosAntiguedad(), 
				LocalDate.now(), montoACobrar());
		return recibo;
	}
	
	public double aniosAntiguedad() {
		return this.fechaInicio.getYear();
	}
	
	public double montoBasicoContrato() {
		return this.contratoActual().montoBasico();
	}
	
	public double montoACobrar() {
		if (this.aniosAntiguedad() > 5)
			return this.montoBasicoContrato()*1.3;
		else if (this.aniosAntiguedad() > 10) 
			return this.montoBasicoContrato()*1.5;
		else if (this.aniosAntiguedad() > 15)
			return this.montoBasicoContrato()*1.7;
		else if (this.aniosAntiguedad() > 20)
			return this.montoBasicoContrato()*2;
		else
			return 0;
	}
	
}
