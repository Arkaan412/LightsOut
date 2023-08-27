import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableroTest {
	@Test
	void valorInicialDeMatrizTest() {
		Tablero tablero = new Tablero(3);
		for (int i = 0; i < tablero.tamanio(); i++) {
			for (int j = 0; j < tablero.tamanio(); j++) {
				assertFalse(tablero.obtenerValorCelda(i, j));
			}
		}
	}

	@Test
	void invertirValorCeldaTest() {
		Tablero tablero = new Tablero(3);

		tablero.invertirValorCelda(0, 0);

		assertTrue(tablero.obtenerValorCelda(0, 0));
	}

	@Test
	void invertirValorFilaTest() {
		Tablero tablero = new Tablero(3);
		tablero.invertirValorFila(0);

		for (int i = 0; i < tablero.tamanio(); i++) {
			assertTrue(tablero.obtenerValorCelda(0, i));
		}
	}

	@Test
	void invertirValorColumnaTest() {
		Tablero tablero = new Tablero(3);
		tablero.invertirValorColumna(0);

		for (int i = 0; i < tablero.tamanio(); i++) {
			assertTrue(tablero.obtenerValorCelda(i, 0));
		}
	}
}