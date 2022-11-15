package ar.edu.unlp.info.oo1;

public class SeisCuotas implements OpcionDePago {

	@Override
	public double calcularPago(double precio) {
		return precio*0.2;
	}

}
