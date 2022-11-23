package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {

	private Embarcacion bote1;
	private Embarcacion bote2;
	private Embarcacion bote3;
	private Usuario user;

	@BeforeEach
	void setUp() throws Exception {
		user = new Usuario("nombre1", "dni1", "email1", "localidad1");
		
		bote1 = user.altaEmbarcacion("patente1", LocalDate.of(2012, 1, 1), 1000001, user, "barco1");
		bote2 = user.altaEmbarcacion("patente2", LocalDate.of(2013, 1, 1), 999999, user, "barco2");
		bote3 = user.altaEmbarcacion("patente3", LocalDate.of(2011, 1, 1), 1000000, user, "barco3");
	}

	@Test
	void testImpuestosBienes() {
		assertEquals(1000001*0.15, bote1.impuesto());
		assertEquals(999999*0.10, bote2.impuesto());
		assertEquals(0, bote3.impuesto());

	}
	@Test
	void testAnios() {
		assertTrue(bote3.masDeDiezAnios());
	}
	
	@Test
	void testImpuestoUsuario() {
		assertEquals((1000001*0.15)+(999999*0.10), user.calcularImpuesto());
	}

}
