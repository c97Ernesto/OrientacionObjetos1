package ar.edu.unlp.info.oo1.ej12_VolYSupeDeSolidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReporteDeConstruccionTest {
	
	private ReporteDeConstruccion reporte;
	private Pieza cilindro;
	private Pieza esfera;
	private Pieza prisma;
	private Pieza prisma2;
	
	@BeforeEach
	void setUp() throws Exception {
		cilindro = new Cilindro ("Vidrio", "Azul", 3, 9);
		esfera = new Esfera("Cartón", "Naranja", 10);
		prisma = new PrismaRectangular("Madera", "Marron", 2, 4, 2);
		prisma2 = new PrismaRectangular("Madera", "Marron", 4, 8, 4);
		
		reporte = new ReporteDeConstruccion();
		reporte.agregarPieza(cilindro);
		reporte.agregarPieza(esfera);
		reporte.agregarPieza(prisma);
		reporte.agregarPieza(prisma2);
		
		
	}

	@Test
	void testVolumenDeMaterialVidrio() {
		assertEquals(cilindro.volumen(), reporte.volumenDeMaterial("Vidrio"));
	}
	
	@Test
	void testVolumenDeMaterialMadera() {
		assertEquals(prisma.volumen() + prisma2.volumen(), reporte.volumenDeMaterial("Madera"));
	}
	
	@Test
	void testSuperficieDeColorNaranja() {
		reporte.agregarPieza(esfera);
		reporte.agregarPieza(esfera);
		reporte.agregarPieza(esfera);
		reporte.agregarPieza(esfera);
		assertEquals(5*esfera.superficie(), reporte.superficieDeColor("Naranja"));
	}
	
}
