package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario {
	private List<Producto> productosEnVenta;

	public Vendedor(String nombre, String direccion) {
		super(nombre, direccion);
		this.productosEnVenta = new ArrayList<Producto>();
	}
	
	public List<Producto> getProductosEnVenta() {
		return productosEnVenta;
	}

	public Producto agregarProducto(String nombre, String descripcion, double precio, int unidades) {
		Producto producto = new Producto(nombre, descripcion, precio, unidades);
		this.getProductosEnVenta().add(producto);
		return producto;
	}
	
	public Producto buscarProducto(String nombre){
		return this.getProductosEnVenta().stream()
				.filter(producto -> producto.getNombre().equals(nombre))
				.findFirst().orElse(null);
	}
	
	
}
