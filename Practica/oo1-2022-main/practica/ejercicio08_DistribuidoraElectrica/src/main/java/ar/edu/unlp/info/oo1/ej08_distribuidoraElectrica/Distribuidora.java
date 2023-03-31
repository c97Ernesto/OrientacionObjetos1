package ar.edu.unlp.info.oo1.ej08_distribuidoraElectrica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Distribuidora {
	private double precioKWn;
	private List<Usuario> usuarios;
	
	public Distribuidora() {
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public void registrarUsuario(String nombre, String direccion) {
		Usuario usuario = new Usuario(nombre, direccion);
		this.usuarios.add(usuario);
	}
	
	public List<Factura> facturar() {
		return this.usuarios.stream()
				.map(usuario -> usuario.facturarEnBaseA(this.precioKWn))
				.collect(Collectors.toList());
	}
	
	public double consumoTotalActiva() {
		return this.usuarios.stream()
				.map(usuario -> usuario.ultimoConsumoActiva())
				.mapToDouble(consumo -> consumo.getConsumoEnergiaActiva())
				.sum();
	}
	
	public void precioKWh(double precio) {
		this.precioKWn = precio;
	}
}
