package ar.edu.unlp.info.oo1.ej11_ElInversor;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlazoFijoTest {
	
	private PlazoFijo plazo;
	private LocalDate fecha;
	private double valorActualTest;

	@BeforeEach
	void setUp() throws Exception {
		fecha = LocalDate.of(2022, 9, 20);		//fecha actual menos alguna cantidad de días
		plazo = new PlazoFijo(fecha, 2000, 10);
		valorActualTest = (8*10)+2000;
	}

	@Test
	void testDiasTranscurridos() {
		System.out.println(plazo.diasTranscurridos());
		assertEquals(8, plazo.diasTranscurridos());
	}
	
	@Test
	void testGetFecha() {
		System.out.println(plazo.getFechaDeConstitucion());
		assertEquals(fecha, plazo.getFechaDeConstitucion());
	}
	
	@Test
	void testValorActual() {
		System.out.println(valorActualTest);
		assertEquals(valorActualTest, plazo.valorActual());
		System.out.println(plazo.valorActual());
	}

}
