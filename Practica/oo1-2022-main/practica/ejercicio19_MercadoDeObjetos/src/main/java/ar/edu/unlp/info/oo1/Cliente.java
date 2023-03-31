package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

	private List<Pedido> pedidos;

	public Cliente(String nombre, String direccion) {
		super(nombre, direccion);
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void crearPedido(Producto producto, int cantidad, OpcionDePago opcionDePago,
			MecanismoDeEnvio mecanismoDeEnvio) {
		
		if (producto.hayStock(cantidad)) {
			Pedido pedido = new Pedido(producto, cantidad, opcionDePago, mecanismoDeEnvio, this);
			producto.actualizarStock(cantidad);
			this.getPedidos().add(pedido);
		}
	}

	public double CostoTotalDePedido(Pedido pedido) {
		return pedido.calcularCostoTotal();
	}

}
