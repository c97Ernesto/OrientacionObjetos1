package ar.edu.unlp.info.oo1.ej09_CuentaConGanchos;
/*
 * */
public class CajaDeAhorro extends Cuenta {
	
	public CajaDeAhorro() {
		super();
	}
	
	private double montoTotal(double monto) {
		return monto - (monto*0.02);
	}
	
	public void depositar(double monto) {
		super.depositar(this.montoTotal(monto));
	}

	@Override
	protected boolean puedeExtraer(double monto) {
		return this.montoTotal(this.getSaldo() - monto) >= 0;
	}
}
