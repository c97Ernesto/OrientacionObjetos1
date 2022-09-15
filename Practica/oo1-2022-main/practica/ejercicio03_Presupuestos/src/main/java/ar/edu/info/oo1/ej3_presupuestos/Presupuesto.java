package ar.edu.info.oo1.ej3_presupuestos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	/*una instancia de java.util.ArrayList constituye una colección lineal ordenada, que crece 
	 * dinámicamente y puede contener elementos duplicados. Ofrece acceso posicional en tiempo 
	 * constante. Está indexada comenzando desde 0*/
	private List<Item> items= new ArrayList<Item>(); //<T>, indica el nombre de una clase o interfaz.
	
	public double calcularTotal() {
		double total = 0;
		for (Item item: items) {
			total+= item.costo();
		}
		
		return total;
	}

	public void agregarItem(Item item) {
		this.items.add(item);	//add(<T> object), agrega el objeto “object” , de tipo “T”, a la última posición de la lista.
	}

	public Presupuesto cliente(String string) {
		this.cliente = string;
		return this;
	}
	
	
	
}
