package ar.edu.unlp.info.oo1.ej09_CuentaConGanchos;
/*
3_Las cuentas corrientes pueden extraer aún cuando el saldo de la cuenta sea
insuficiente. Sin embargo, no deben superar cierto límite por debajo del saldo. Dicho
límite se conoce como límite de descubierto (algo así como el máximo saldo
negativo permitido). Ese límite es diferente para cada cuenta (lo negocia el cliente
con la gente del banco).
4_Cuando se abre una cuenta corriente, su límite descubierto es 0 (no olvide definir el
constructor por default).
*/
public class CuentaCorriente extends Cuenta{	//para crear test "ctr + 1" en nombre de la clase
	
	private double limiteDescubierto;	//para crear getters and setters "ctr + 1" en nombre de la variable
	
	public CuentaCorriente() {
		super();	//hago referencia al constructor del padre para que quede explícito
		this.setLimiteDescubierto(0);
	}
	
	public double getLimiteDescubierto() {
		return limiteDescubierto;
	}
	public void setLimiteDescubierto(double limiteDescubierto) {
		this.limiteDescubierto = limiteDescubierto;
	}

	@Override
	protected boolean puedeExtraer(double monto) {
		return this.getSaldo() + this.getLimiteDescubierto() >= monto;
	}

	
}
