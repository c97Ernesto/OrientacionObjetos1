package ar.edu.unlp.info.oo1.ej12_VolYSupeDeSolidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrismaRectangularTest {
	PrismaRectangular prisma;

	@BeforeEach
	void setUp() throws Exception {
		prisma = new PrismaRectangular("Madera", "Marron", 2, 4, 2);
	}
	
	@Test
	void testInstanciacion() {
		assertEquals("Madera", prisma.getMaterial());
		assertEquals("Marron", prisma.getColor());
	}

	@Test
	void testVolumen() {
		assertEquals(2*4*2, prisma.volumen());
	}
	
	@Test
	void testSuperficie() {
		assertEquals(2*(2*4+4*2+2*2), prisma.superficie());
	}

}
