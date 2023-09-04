package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Controlador;
import modelo.Tablero;
import vista.BotonCelda;
import vista.PantallaDeJuego;

public class PantallaDeJuegoTests {
	private final int tamanioTablero = 3;

	private Tablero tablero;
	private Controlador controlador;
	private PantallaDeJuego pantalla;

	public PantallaDeJuegoTests() {
		tablero = new Tablero(tamanioTablero);
		controlador = new Controlador(tablero);
		pantalla = new PantallaDeJuego(controlador, tamanioTablero);
	}

	@Test
	public void asignacionCorrectaDeFilaYColumnaEnBotonesTest() {
		int tamanioTablero = 2;

		Tablero tablero = new Tablero(tamanioTablero);
		Controlador controlador = new Controlador(tablero);
		PantallaDeJuego pantallaDeDos = new PantallaDeJuego(controlador, tamanioTablero);

		BotonCelda[][] celdas = pantallaDeDos.obtenerCeldas();

		BotonCelda celda0 = celdas[0][0];
		BotonCelda celda1 = celdas[0][1];
		BotonCelda celda2 = celdas[1][0];
		BotonCelda celda3 = celdas[1][1];

		assertEquals(0, celda0.getFila());
		assertEquals(0, celda0.getColumna());

		assertEquals(0, celda1.getFila());
		assertEquals(1, celda1.getColumna());

		assertEquals(1, celda2.getFila());
		assertEquals(0, celda2.getColumna());

		assertEquals(1, celda3.getFila());
		assertEquals(1, celda3.getColumna());
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void obtenerFilaInvalidaTest() {
		BotonCelda[] fila = pantalla.obtenerFila(3);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void obtenerColumnaInvalidaTest() {
		BotonCelda[] columna = pantalla.obtenerColumna(tamanioTablero);
	}

	@Test
	public void obtenerFila0Test() {
		BotonCelda[] fila = pantalla.obtenerFila(0);

		for (int indiceFila = 0; indiceFila < fila.length; indiceFila++) {
			assertEquals(0, fila[indiceFila].getFila());
		}
	}

	@Test
	public void obtenerFila1Test() {
		BotonCelda[] fila = pantalla.obtenerFila(1);

		for (int indiceFila = 0; indiceFila < fila.length; indiceFila++) {
			assertEquals(1, fila[indiceFila].getFila());
		}
	}

	@Test
	public void obtenerFila2Test() {
		BotonCelda[] fila = pantalla.obtenerFila(2);

		for (int indiceFila = 0; indiceFila < fila.length; indiceFila++) {
			assertEquals(2, fila[indiceFila].getFila());
		}
	}

	@Test
	public void obtenerColumna0Test() {
		BotonCelda[] columna = pantalla.obtenerColumna(0);

		for (int indiceColumna = 0; indiceColumna < columna.length; indiceColumna++) {
			assertEquals(0, columna[indiceColumna].getColumna());
		}
	}

	@Test
	public void obtenerColumna1Test() {
		BotonCelda[] columna = pantalla.obtenerColumna(1);

		for (int indiceColumna = 0; indiceColumna < columna.length; indiceColumna++) {
			assertEquals(1, columna[indiceColumna].getColumna());
		}
	}

	@Test
	public void obtenerColumna2Test() {
		BotonCelda[] columna = pantalla.obtenerColumna(2);

		for (int indiceColumna = 0; indiceColumna < columna.length; indiceColumna++) {
			assertEquals(2, columna[indiceColumna].getColumna());
		}
	}

	@Test
	public void invertirEstadoFilaTest() {
		BotonCelda[] fila = pantalla.obtenerFila(0);

		pantalla.invertirEstadoFila(0);

		for (int indiceFila = 0; indiceFila < fila.length; indiceFila++) {
			assertFalse(fila[indiceFila].isSelected());
		}
	}

	@Test
	public void invertirEstadoColumnaTest() {
		BotonCelda[] columna = pantalla.obtenerColumna(0);

		pantalla.invertirEstadoColumna(0);

		for (int indiceColumna = 0; indiceColumna < columna.length; indiceColumna++) {
			assertFalse(columna[indiceColumna].isSelected());
		}
	}

	@Test
	public void invertirEstadoCruzTest() {
		BotonCelda[] fila = pantalla.obtenerFila(0);
		BotonCelda[] columna = pantalla.obtenerColumna(0);

		pantalla.invertirEstadoCruz(0, 0);

//		assertFalse(fila[0].isSelected());
//		assertFalse(fila[1].isSelected());
//		assertFalse(fila[2].isSelected());
//		
//		assertFalse(columna[0].isSelected());
//		assertFalse(columna[1].isSelected());
//		assertFalse(columna[2].isSelected());
		
		for (int indiceFila = 0; indiceFila < fila.length; indiceFila++) {
			if ((fila[indiceFila].isSelected())) System.out.println(indiceFila);
			assertFalse(fila[indiceFila].isSelected());
		}
		for (int indiceColumna = 0; indiceColumna < columna.length; indiceColumna++) {
			assertFalse(columna[indiceColumna].isSelected());
		}
	}
}