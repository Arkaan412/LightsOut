package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import juego.Tablero;

public class TableroTest {

	@Test(expected = IllegalArgumentException.class)
	public void tableroVacioTest() {
		@SuppressWarnings("unused")
		Tablero tablero = new Tablero(0);
	}

	@Test
	public void tableroDeUnaCeldaTest() {
		Tablero tablero = new Tablero(1);
		assertFalse(tablero.obtenerValorCelda(0, 0));
	}

	@Test
	public void valoresInicialesDelTableroTest() {
		Tablero tablero = new Tablero(3);

		assertTodasLasCeldasEnFalse(tablero);
	}

	private void assertTodasLasCeldasEnFalse(Tablero tablero) {
		for (int fila = 0; fila < tablero.tamanio(); fila++) {
			for (int columna = 0; columna < tablero.tamanio(); columna++) {
				assertFalse(tablero.obtenerValorCelda(fila, columna));
			}
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void nroFilaNegativoTest() {
		Tablero tablero = new Tablero(3);
		tablero.invertirValorCelda(-1, 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void nroFilaExcedidoTest() {
		Tablero tablero = new Tablero(3);
		tablero.invertirValorCelda(3, 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void nroColumnaNegativoTest() {
		Tablero tablero = new Tablero(3);
		tablero.invertirValorCelda(0, -1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void nroColumnaExcedidoTest() {
		Tablero tablero = new Tablero(3);
		tablero.invertirValorCelda(0, 3);
	}

	@Test
	public void invertirValorCeldaTest() {
		Tablero tablero = new Tablero(3);
		tablero.invertirValorCelda(0, 0);
		
		assertTrue(tablero.obtenerValorCelda(0, 0));
	}
	
	@Test
	public void invertirValorCeldaDosVecesTest() {
		Tablero tablero = new Tablero(3);
		tablero.invertirValorCelda(0, 0);
		tablero.invertirValorCelda(0, 0);

		assertFalse(tablero.obtenerValorCelda(0, 0));
	}

	@Test
	public void invertirValorFilaTest() {
		Tablero tablero = new Tablero(3);
		tablero.invertirValorFila(0);

		assertTrue(tablero.obtenerValorCelda(0, 0));
		assertTrue(tablero.obtenerValorCelda(0, 1));
		assertTrue(tablero.obtenerValorCelda(0, 2));
	}

	@Test
	public void invertirValorColumnaTest() {
		Tablero tablero = new Tablero(3);
		tablero.invertirValorColumna(0);

		assertTrue(tablero.obtenerValorCelda(0, 0));
		assertTrue(tablero.obtenerValorCelda(1, 0));
		assertTrue(tablero.obtenerValorCelda(2, 0));
	}
}