package ar.edu.unlp.info.oo1.ej13_ClienteDeCorreo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArchivoTest {
	
	private Archivo archivo;

	@BeforeEach
	void setUp() throws Exception {
		archivo = new Archivo("pdf");
	}

	@Test
	void testNombre() {
		assertEquals("pdf", archivo.getNombre());
		archivo.setNombre("doc");
		assertEquals("doc", archivo.getNombre());
	}
	
	@Test
	void testTamanio() {
		assertEquals(3, archivo.tamanio());
	}
}
