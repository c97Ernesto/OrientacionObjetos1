package ar.edu.unlp.info.oo1.ej09_CuentaConGanchos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaCorrienteTest {
	private CuentaCorriente cuentaCorriente;
	
	@BeforeEach //instanciamos.
	void setUp() throws Exception {
		cuentaCorriente = new CuentaCorriente();
	}
	/*
	 LOS TEST SON IDEPENDIENTES 
	 */
	@Test
	void testCreacion() {
		//una vez instanciada la clase, verificamos que hayamos seteado el saldo correspondiente (0).
		assertEquals(0, cuentaCorriente.getSaldo());
		assertEquals(0, cuentaCorriente.getLimiteDescubierto());
	}
	
	@Test
	void testDepositar() {
		cuentaCorriente.depositar(100);
		//verificamos que estén los 100 depositados.
		assertEquals(100, cuentaCorriente.getSaldo());	
	}
	
	@Test
	void testExtraer() {
		//intentamos extraer, igualamos con falso (nunca depositamos) para pasar el tet.
		assertFalse(cuentaCorriente.extraer(100));
		cuentaCorriente.depositar(100);
		cuentaCorriente.setLimiteDescubierto(400);
		assertTrue(cuentaCorriente.extraer(500));
		assertEquals(-400, cuentaCorriente.getSaldo());
	}
	
	@Test
	void testTransferir() {
		cuentaCorriente.depositar(13);
		cuentaCorriente.setLimiteDescubierto(1);
		assertFalse(cuentaCorriente.transferirACuenta(15, cuentaCorriente));
	}
	
	@Test
	void testPruebaGeneral() {
		cuentaCorriente.depositar(700);
		cuentaCorriente.setLimiteDescubierto(1000);
		assertEquals(1700, cuentaCorriente.getSaldo() + cuentaCorriente.getLimiteDescubierto());
		assertTrue(cuentaCorriente.extraer(1200));
		assertFalse(cuentaCorriente.extraer(501));
		cuentaCorriente.depositar(700);
		assertTrue(cuentaCorriente.transferirACuenta(1200, cuentaCorriente));
	}

}
