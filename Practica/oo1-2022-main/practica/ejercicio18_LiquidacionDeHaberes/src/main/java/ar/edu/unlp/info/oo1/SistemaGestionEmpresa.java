package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaGestionEmpresa {
	private List<Empleado> empleados;
	
	public SistemaGestionEmpresa() {
		this.empleados = new ArrayList<Empleado>(); 
	}
	
	public List<Empleado> getEmpleados(){
		return this.empleados;
	}
//	Dar de alta un empleado: Se indica el nombre, apellido, cuil, y fecha de nacimiento. Se
//	indica si tiene cónyuge a cargo. Se indica si tiene hijos a cargo. El sistema agrega el
//	empleado a la nómina de la empresa. Se registra la fecha actual como fecha de inicio de la
//	relación laboral del empleado.
	public void altaEmpleado(String nombre, String apellido, String cuil, LocalDate fechaNacimiento, 
			boolean conyugueACargo, boolean hijosACargo) {
		Empleado empleado = new Empleado(nombre, apellido, cuil, fechaNacimiento, conyugueACargo, hijosACargo);
		this.getEmpleados().add(empleado);
	}
	
//	Buscar un empleado: Se indica el CUIL del empleado. El sistema retorna al empleado con
//	ese CUIL o null si no existe.
	public Empleado buscarEmpleado(String cuil) {
		return this.getEmpleados().stream()
				.filter(empleado -> empleado.getCuil().equals(cuil))
				.findAny().orElse(null);
	}
	
//	Dar de baja un empleado: Se indica el empleado a dar de baja. El sistema lo quita de la
//	nómina de la empresa.
	public void bajaEmpleado(Empleado empleado) {
		this.getEmpleados().remove(empleado);
	}
	
//	Obtener empleados con contratos vencidos. El sistema devuelve la lista de todos
//	aquellos empleados cuyos contrato actual se encuentre vencido. Si para un empleado
//	existiese más de un contrato, el contrato con fecha de inicio más reciente es el considerado
//	actual, dicho contrato puede estar vigente (si no tiene fecha de fin o si la fecha de fin es
//	posterior a la fecha actual), o vencido (para los que tienen de fecha fin, cuando dicha fecha
//	es inferior o igual a la fecha actual)
	public List<Empleado> contratosVencidos(){
		return this.getEmpleados().stream()
				.filter(empleado -> empleado.contratoVencido())
				.collect(Collectors.toList());
	}
	
//	Generar recibos de cobro. Por cada empleado (con contrato activo, es decir sin vencer) el
//	sistema genera un recibo de sueldo. El sistema devuelve los recibos de sueldo. De un
//	recibo de sueldo puede obtenerse la siguiente información: el nombre, apellido, CUIL y
//	antigüedad en la empresa del empleado al que pertenece el recibo; la fecha en la que fue
//	generado el recibo y el monto total que le corresponde cobrar al empleado.
	public List<ReciboDeSueldo> recibosDeCobro() {
		return this.empleadosActivos().stream()
				.map(empleado -> empleado.generarRecibo())
				.collect(Collectors.toList());
	}
	
	public List<Empleado> empleadosActivos(){
		return this.empleados.stream()
				.filter(empleado -> empleado.contratoActivo())
				.collect(Collectors.toList());
	}
}
 