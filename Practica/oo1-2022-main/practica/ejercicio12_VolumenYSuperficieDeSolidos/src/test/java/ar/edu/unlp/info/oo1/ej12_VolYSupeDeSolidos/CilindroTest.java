package ar.edu.unlp.info.oo1.ej12_VolYSupeDeSolidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CilindroTest {
	
	private Cilindro cilindro;
	
	@BeforeEach
	void setUp() throws Exception {
		cilindro = new Cilindro ("Vidrio", "Azul", 3, 9);
		
	}

	@Test
	void testInstanciacion() {
		assertEquals("Vidrio", cilindro.getMaterial());
	}
	
	@Test
	void testVolumen() {
		assertEquals(Math.PI * Math.pow(3, 2) * 9, cilindro.volumen());
	}
	
	@Test
	void testSuperficie() {
		assertEquals(2 * Math.PI * 3 * 9 + 2 * Math.PI * Math.pow(3, 2), cilindro.superficie());
	} 

}
