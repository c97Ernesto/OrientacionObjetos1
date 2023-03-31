package ar.edu.unlp.info.oo1.ej11_ElInversor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InversionEnAccionesTest {
	
	private InversionEnAcciones accion;
	
	@BeforeEach
	void setUp() throws Exception {
		accion = new InversionEnAcciones("nombreAccion", 7, 10);
	}

	@Test
	void testValorActual() {
		assertEquals(70, accion.valorActual());
		assertNotEquals(69, accion.valorActual());
	}

}
