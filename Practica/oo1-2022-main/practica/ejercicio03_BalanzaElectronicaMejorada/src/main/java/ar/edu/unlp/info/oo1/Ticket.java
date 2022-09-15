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
	
	//creamos un ArrayList posicion dinámica en memoria que representa una Lista para guardar otras colecciones u objetos
	private List<Producto> productos = new ArrayList<Producto>();
	
	public Ticket(List<Producto> productos) {
		this.fecha = LocalDate.now();
		this.productos = productos;
	}
	
	public double impuesto() {
		return this.getPrecioTotal()*0.21;
	}

	public Object getFecha() {
		return this.fecha;
	}

	public double getPesoTotal() {		//usar los Stream
		double pesoTotal = 0;		//no usar las variables privadas, crear locales
		for (Producto producto: productos) {		//en lo posible no usar foreach
			pesoTotal+= producto.getPeso(); 
		}
		return pesoTotal;
	}

	public double getPrecioTotal() {
		double precioTotal = 0;
		for (Producto producto: productos) {
			precioTotal+= producto.getPrecio(); 
		}
		return precioTotal;
	}

	public int getCantidadDeProductos() {
		return this.productos.size();
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}
}
