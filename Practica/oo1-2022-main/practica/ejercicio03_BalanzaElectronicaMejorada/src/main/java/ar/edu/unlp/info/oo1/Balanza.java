package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

/*
Tarea 1:
Mejorar la balanza para que recuerde los productos ingresados (los mantenga en una
colección). Analice de qué forma puede realizarse este nuevo requerimiento e implemente
el mensaje " getProductos() : List<Producto> " que retorna todos los productos ingresados 
a la balanza (en la compra actual, es decir, desde la última vez que se la puso a cero).
*/
public class Balanza {
	private List<Producto> productos;
	
	public Balanza() {		//agregamos contructor nulo para poner en cero la balanza
		this.ponerEnCero();
	}
	
	/* Puedo conseguir pesoTotal, precioTotal y cantidadProductos recorriendo arreglo 
	 * o con sus metodos. */
	public void ponerEnCero() {
		this.productos = new ArrayList<Producto>();
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}

	public double getPesoTotal() {		//usar los Stream
		double pesoTotal = 0;		//no usar las variables privadas, crear locales
		for (Producto producto: productos) {
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
	
	//getProductos() : List<Producto>
	public List<Producto> getProductos() {
		return this.productos;
	}

	public Ticket emitirTicket() {
		Ticket ticket = new Ticket(this.getProductos());
		return ticket;
	}
	
}
