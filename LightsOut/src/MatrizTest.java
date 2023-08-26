import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatrizTest {
	@Test
	void valorInicialDeMatrizTest() {
		Matriz matriz = new Matriz(3);
		for (int i = 0; i < matriz.tamanio(); i++) {
			for (int j = 0; j < matriz.tamanio(); j++) {
				assertFalse(matriz.obtenerValorCelda(i, j));				
			}
		}
	}

	@Test
	void cambiarValorCeldaTest() {
		Matriz matriz = new Matriz(3);
		
		matriz.cambiarValorCelda(0, 0);
		
		assertTrue(matriz.obtenerValorCelda(0,0));
	}
	
	@Test
	void cambiarValorFilaTest() {
		Matriz matriz = new Matriz(3);
		matriz.cambiarValorFila(0);
		
		for (int i = 0; i < matriz.tamanio(); i++) {
			assertTrue(matriz.obtenerValorCelda(0, i));
		}
	}
	
	@Test
	void cambiarValorColumnaTest() {
		Matriz matriz = new Matriz(3);
		matriz.cambiarValorColumna(0);

		for (int i = 0; i < matriz.tamanio(); i++) {
			assertTrue(matriz.obtenerValorCelda(i, 0));
		}
	}
}