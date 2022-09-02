package ar.edu.unlp.info.oo1;

public class Balanza {
	private int cantiadadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public void ponerEnCero() {
		this.cantiadadDeProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal = 0;
	}

	public void agregarProducto(Producto producto) {
		this.cantiadadDeProductos++;
		this.precioTotal+= producto.getPrecio();
		this.pesoTotal+= producto.getPeso();
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

	public Ticket emitirTicket() {
		Ticket ticket = new Ticket(this.cantiadadDeProductos, this.pesoTotal, this.precioTotal);
		return ticket;
	}
	
	
	
}
