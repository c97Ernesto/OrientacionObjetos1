package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	private List<Vendedor> vendedores;
	private List<Cliente> clientes;
	
	/**/
	public Sistema() {
		this.clientes = new ArrayList<Cliente>();
		this.vendedores = new ArrayList<Vendedor>();
	}
	/**/
	public List<Cliente> getClientes() {
		return clientes;
	}
	public List<Vendedor> getVendedores() {
		return vendedores;
	}
	/**/
	
	public Vendedor registrarVendedor(String nombre, String direccion) {
		Vendedor vendedor = new Vendedor(nombre, direccion);
		this.getVendedores().add(vendedor);
		return vendedor;
	}
	
	public Vendedor buscarVendedor(String nombre) {
		return this.getVendedores().stream()
				.filter(vendedor -> vendedor.getNombre().equals(nombre))
				.findFirst().orElse(null);
	}
	
	public Cliente registrarCliente(String nombre, String direccion) {
		Cliente cliente = new Cliente(nombre, direccion);
		this.getClientes().add(cliente);
		return cliente;
	}
	
	public Cliente buscarCliente(String nombre) {
		return this.getClientes().stream()
				.filter(cliente -> cliente.getNombre().equals(nombre))
				.findFirst().orElse(null);
	}
	
	public Producto PonerEnVenta(String nombre, String descripcion, double precio, 
			int cantidad, Vendedor vendedor) {
		return vendedor.agregarProducto(nombre, descripcion, precio, cantidad);
	}
	public List<Producto> buscarProductos(String nombre){
		return this.getVendedores().stream()
				.map(vendedor -> vendedor.buscarProducto(nombre))
				.collect(Collectors.toList());
	}
	
	public void crearPedido(Cliente cliente, Producto producto, int cantidad, OpcionDePago opcionDePago,
			MecanismoDeEnvio mecanismoDeEnvio) {
		cliente.crearPedido(producto, cantidad, opcionDePago, mecanismoDeEnvio);
	}
	
	public double costoPedido(Pedido pedido) {
		return pedido.calcularCostoTotal();
	}
}

