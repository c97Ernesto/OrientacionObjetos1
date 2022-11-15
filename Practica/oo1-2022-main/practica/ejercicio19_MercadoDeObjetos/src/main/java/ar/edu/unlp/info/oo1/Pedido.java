package ar.edu.unlp.info.oo1;

public class Pedido {

	private Producto producto;
	private int cantidad;
	private OpcionDePago opcionDePago;
	private MecanismoDeEnvio mecanismoDeEnvio;
	private Cliente cliente;

	public Pedido(Producto producto, int cantidad, OpcionDePago opcionDePago, MecanismoDeEnvio mecanismoDeEnvio,
			Cliente cliente) {
				this.producto = producto;
				this.cantidad = cantidad;
				this.opcionDePago = opcionDePago;
				this.mecanismoDeEnvio = mecanismoDeEnvio;
				this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}
	public OpcionDePago getOpcionDePago() {
		return opcionDePago;
	}
	public int getCantidad() {
		return cantidad;
	}
	public MecanismoDeEnvio getMecanismoDeEnvio() {
		return mecanismoDeEnvio;
	}
	
	public double calcularPrecioProductos() {
		return this.getProducto().getPrecio()*this.getCantidad();
	}
	
	public double calcularCostoTotal() {
		return this.getOpcionDePago().calcularPago(this.calcularPrecioProductos()) 
				+ this.getMecanismoDeEnvio().costoAdicional();
	}
	
	
}

