package ar.edu.unlp.info.oo1.ej13_ClienteDeCorreo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarpetaTest {
	Carpeta carpeta;
	Email email, email1;
	Archivo archivo = new Archivo();

	@BeforeEach
	void setUp() throws Exception {
		carpeta = new Carpeta("Servicios");
		email = new Email("titulo", "cuerpo");
//		email1 = email;		referencia al mismo objeto
		email1 = new Email("titulo", "cuerpo");
		archivo = new Archivo("pdf");
	}

	@Test
	void testGetters() {
		assertEquals("Servicios", carpeta.getNombre());
		
	}
	
	@Test
	void testTamanioCarpeta() {
		assertEquals(0, carpeta.tamanioCarpeta());
		
		carpeta.agregarEmail(email);
		assertEquals(12, carpeta.tamanioCarpeta());
		
		carpeta.agregarEmail(email1);
		assertEquals(24, carpeta.tamanioCarpeta());
		
		email1.agregarAdjunto(archivo);
		assertEquals(27, carpeta.tamanioCarpeta());
		
		email1.agregarAdjunto(archivo);
		assertEquals(30, carpeta.tamanioCarpeta());
		
	}
	
	@Test
	void testBusquedaEmail() {
		carpeta.agregarEmail(email);
		assertEquals(email, carpeta.busquedaEmail("titulo"));
	}
	
}
