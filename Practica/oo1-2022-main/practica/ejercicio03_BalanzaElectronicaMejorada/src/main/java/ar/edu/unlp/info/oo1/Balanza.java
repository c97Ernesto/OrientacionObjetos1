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
	private int cantiadadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	private List<Producto> productos;
	
	public void ponerEnCero() {
		/*
		  Puedo conseguir pesoTotal, precioTotal y cantidadProductos recorriendo arreglo 
		  o con sus metodos. 
		*/
		this.cantiadadDeProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal = 0;
		this.productos = new ArrayList<Producto>();
	}

	public void agregarProducto(Producto producto) {
		this.cantiadadDeProductos++;
		this.precioTotal+= producto.getPrecio();
		this.pesoTotal+= producto.getPeso();
		this.productos.add(producto);
	}

	public double getPesoTotal() {
		return this.pesoTotal;
	}

	public double getPrecioTotal() {
		return this.precioTotal;
	}

	public int getCantidadDeProductos() {
		return this.cantiadadDeProductos;
	}
	
	//getProductos() : List<Producto>
	public List<Producto> getProductos() {
		return this.productos;
	}

	public Ticket emitirTicket() {
		Ticket ticket = new Ticket(this.getCantidadDeProductos(), this.getPesoTotal(), this.getPrecioTotal());
		return ticket;
	}
	
}
