package ar.edu.unlp.info.oo1;

import java.util.List;

public class OrdenCompra extends Orden{


	public OrdenCompra(String patente, List<Repuesto> repuestos) {
		super(patente, repuestos);
	}

	@Override
	public double costo() {
		if (this.hayRepuestoViejo()) {
			return this.precioDeRepuestos()*1.08;
		} else {
			return this.precioDeRepuestos()*1.15;
		}
	}
	
	
}
