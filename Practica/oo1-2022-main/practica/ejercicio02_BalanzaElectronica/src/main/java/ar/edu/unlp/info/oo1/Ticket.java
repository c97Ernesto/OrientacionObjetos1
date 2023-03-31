package ar.edu.unlp.info.oo1;

/*Importamos clase LocalDate: LocalDate es un objeto de fecha y hora inmutable que representa una 
 * fecha, a menudo vista como año-mes-día. También se puede acceder a otros campos de fecha, como 
 * día del año, día de la semana y semana del año. Por ejemplo, el valor "2 de octubre de 2007" 
 * se puede almacenar en LocalDate.*/
import java.time.LocalDate;

public class Ticket {
	private LocalDate fecha;
	private int candidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	
	public Ticket(int cantProd, double pesoTotal, double precioTotal) {
		this.candidadDeProductos = cantProd;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal + this.impuesto();
		this.fecha = LocalDate.now();
	}
	
	public double impuesto() {
		return precioTotal*0.21;
	}

	public Object getFecha() {
		return this.fecha;
	}

	public int getCantidadDeProductos() {
		return this.candidadDeProductos;
	}

	public double getPesoTotal() {
		return this.pesoTotal;
	}

	public double getPrecioTotal() {
		return this.precioTotal;
	}
}
