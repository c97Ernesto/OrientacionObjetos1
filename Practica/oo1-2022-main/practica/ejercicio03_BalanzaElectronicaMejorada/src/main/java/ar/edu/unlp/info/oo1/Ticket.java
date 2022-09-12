package ar.edu.unlp.info.oo1;

/*Importamos clase LocalDate: LocalDate es un objeto de fecha y hora inmutable que representa una 
 * fecha, a menudo vista como año-mes-día. También se puede acceder a otros campos de fecha, como 
 * día del año, día de la semana y semana del año. Por ejemplo, el valor "2 de octubre de 2007" 
 * se puede almacenar en LocalDate.*/
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/*
Tarea 2
Con esta nueva funcionalidad, podemos enriquecer al Ticket, haciendo que él también
conozca a los productos (a futuro podríamos imprimir el detalle). Ticket también debería
entender el mensaje getProductos():List<Producto> .
¿Qué cambios cree necesarios en Ticket para que pueda conocer a los productos?
*/
public class Ticket {
	private LocalDate fecha;
	private int candidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	private List<Producto> productos = new ArrayList<Producto>();
	
	
	public Ticket(int cantProd, double pesoTotal, double precioTotal) {
		this.candidadDeProductos = cantProd;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal + this.impuesto();
		this.fecha = LocalDate.now();
	}
	
	public Ticket(List<Producto> productos) {
		this.candidadDeProductos = productos.size();
		this.fecha = LocalDate.now();
		
		for(Producto i: productos) {
			this.productos.add(i);
			this.pesoTotal+= i.getPeso();
			this.precioTotal+= i.getPrecio();
		}
	}
	
	public double impuesto() {
		return this.getPrecioTotal()*0.21;
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
	
	public List<Producto> getProductos(){
		return this.productos;
	}
}
