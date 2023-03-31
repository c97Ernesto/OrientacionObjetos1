package ar.edu.unlp.info.oo1;

public class Reserva {
	
	private DateLapse periodo;
	private Propiedad propiedad;
	private Usuario inquilino;
	
	public Reserva (Propiedad propiedad, DateLapse periodo, Usuario inquilino) {
		this.propiedad = propiedad;
		this.periodo = periodo;
		this.inquilino = inquilino;
	}
	
	public Propiedad getPropiedad() {
		return propiedad;
	}
	public DateLapse getPeriodo() {
		return periodo;
	}
	
	public boolean perteneceAlPeriodo(DateLapse periodo) {
		return this.getPeriodo().overlaps(periodo);
	}
	
	public double precioDeReserva() {
		return this.getPropiedad().getPrecioNoche() * this.getPeriodo().sizeInDays();
	}
	
	public Usuario getInquilino() {
		return inquilino;
	}
}
