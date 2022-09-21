package ar.edu.unlp.info.oo1.ej09_CuentaConGanchos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaDeAhorroTest {
	
	private CajaDeAhorro cajaDeAhorro;
	
	@BeforeEach
	void setUp() throws Exception {
		cajaDeAhorro = new CajaDeAhorro();
	}

	@Test
	void testSaldo() {
		assertEquals(0, cajaDeAhorro.getSaldo());
		cajaDeAhorro.depositar(300);
		assertEquals(300-(300*0.02), cajaDeAhorro.getSaldo());
	}
	
	@Test
	void testExtraer() {
		cajaDeAhorro.depositar(1231);
		assertFalse(cajaDeAhorro.extraer(1231));
		assertTrue(cajaDeAhorro.extraer(1231-(1231*0.02)));
	}
	
	@Test
	void testTransferir() {
		cajaDeAhorro.depositar(100);
		assertFalse(cajaDeAhorro.transferirACuenta(100, cajaDeAhorro));
		assertFalse(cajaDeAhorro.transferirACuenta(99, cajaDeAhorro));
		assertTrue(cajaDeAhorro.transferirACuenta(98, cajaDeAhorro));
	}

}
