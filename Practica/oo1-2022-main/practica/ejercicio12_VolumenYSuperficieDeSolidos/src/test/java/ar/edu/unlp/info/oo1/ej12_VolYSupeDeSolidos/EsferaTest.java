package ar.edu.unlp.info.oo1.ej12_VolYSupeDeSolidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EsferaTest {
	
	private Esfera esfera;
	
	@BeforeEach
	void setUp() throws Exception {
		esfera = new Esfera("Cartón", "Naranja", 10);
	}

	@Test
	void testInstanciacion() {
		assertEquals("Cartón", esfera.getMaterial());
		assertNotEquals("Carton", esfera.getMaterial());
		assertEquals("Naranja", esfera.getColor());
	}
	
	@Test
	void testVolumen() {
		assertEquals((4/3)*Math.PI*(Math.pow(10, 3)), esfera.volumen());
	}
	
	@Test
	void testSuperficie() {
		assertEquals(4*Math.PI*Math.pow(10, 2), esfera.superficie());
	}

}
