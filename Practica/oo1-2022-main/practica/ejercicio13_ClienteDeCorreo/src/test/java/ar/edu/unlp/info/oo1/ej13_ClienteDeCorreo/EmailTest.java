package ar.edu.unlp.info.oo1.ej13_ClienteDeCorreo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailTest {
	Email email;
	Archivo archivo = new Archivo();

	@BeforeEach
	void setUp() throws Exception {
		email = new Email("titulo", "cuerpo");
	}
	
	@Test
	void testTamanioEmail() {
		assertEquals(12, email.tamanioEmail());
		archivo.setNombre("pdf");
		email.agregarAdjunto(archivo);
		assertEquals(15, email.tamanioEmail());
		email.agregarAdjunto(archivo);
		assertEquals(18, email.tamanioEmail());
	}
	
	@Test
	void testContiene() {
		assertTrue(email.contiene("titu"));
	}
	

}
