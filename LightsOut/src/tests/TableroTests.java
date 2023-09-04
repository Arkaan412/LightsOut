package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Celda;
import modelo.Tablero;

public class TableroTests {
	@Test
	public void asignacionCorrectaDeFilaYColumnaEnBotonesTest() {
		Tablero matriz = new Tablero(2);
		Celda[][] botones = matriz.getBotones();
		
		Celda boton0 = botones[0][0];
		Celda boton1 = botones[0][1];
		Celda boton2 = botones[1][0];
		Celda boton3 = botones[1][1];
		
		assertEquals(0, boton0.getFila());
		assertEquals(0, boton0.getColumna());
		
		assertEquals(0, boton1.getFila());
		assertEquals(1, boton1.getColumna());
		
		assertEquals(1, boton2.getFila());
		assertEquals(0, boton2.getColumna());
		
		assertEquals(1, boton3.getFila());
		assertEquals(1, boton3.getColumna()); 
	}

	@Test(expected = IllegalArgumentException.class)
	public void tamanioInvalidoTest() {
		@SuppressWarnings("unused")
		Tablero matriz = new Tablero(1);
	}

	@Test
	public void tamanioTest() {
		Tablero matriz = new Tablero(3);
		assertEquals(3, matriz.tamanio());
	}
	
	@SuppressWarnings("unused")
	@Test (expected= IllegalArgumentException.class)
	public void obtenerFilaInvalidaTest() {
		Tablero matriz = new Tablero(3);
		Celda[] filaBotones3 = matriz.obtenerFila(3);
	}
	
	@Test
	public void obtenerFilaTest() {
		Tablero matriz = new Tablero(2);
		Celda[] filaBotones0 = matriz.obtenerFila(0);
		
		Celda boton0 = filaBotones0[0];
		Celda boton1 = filaBotones0[1];
		
		assertEquals(0, boton0.getFila());
		assertEquals(0, boton1.getFila());
	}
	
	@SuppressWarnings("unused")
	@Test (expected= IllegalArgumentException.class)
	public void obtenerColumnaInvalidaTest() {
		Tablero matriz = new Tablero(3);
		Celda[] columnaBotones3 = matriz.obtenerColumna(3);
	}

	@Test
	public void obtenerColumnaTest() {
		Tablero matriz = new Tablero(2);
		Celda[] columnaBotones0 = matriz.obtenerColumna(0);
		
		Celda boton0 = columnaBotones0[0];
		Celda boton1 = columnaBotones0[1];
		
		assertEquals(0, boton0.getColumna());
		assertEquals(0, boton1.getColumna());
	}
	
	@Test
	public void invertirEstadoFilaTest() {
		Tablero matriz = new Tablero(2);
		Celda[] filaBotones0 = matriz.obtenerFila(0);
		
		matriz.invertirEstadoFila(0);
		
		Celda boton0 = filaBotones0[0];
		Celda boton1 = filaBotones0[1];
		
		assertTrue(boton0.getEstado());
		assertTrue(boton1.getEstado());
	}
	
	@Test
	public void invertirEstadoColumnaTest() {
		Tablero matriz = new Tablero(2);
		Celda[] columnaBotones0 = matriz.obtenerColumna(0);
		
		matriz.invertirEstadoColumna(0);
		
		Celda boton0 = columnaBotones0[0];
		Celda boton1 = columnaBotones0[1];
		
		assertTrue(boton0.getEstado());
		assertTrue(boton1.getEstado());
	}
	
	@Test
	public void invertirEstadoFilaYColumnaTest() {
		Tablero matriz = new Tablero(2);
		Celda[] filaBotones0 = matriz.obtenerFila(0);
		Celda[] columnaBotones0 = matriz.obtenerColumna(0);
		
		matriz.invertirEstadoFila(0);		
		matriz.invertirEstadoColumna(0);
		
		Celda boton0Fila0 = filaBotones0[0];
		Celda boton1Fila0 = filaBotones0[1];
		Celda boton0Columna0 = columnaBotones0[0];
		Celda boton1Columna0 = columnaBotones0[1];
		
		assertFalse(boton0Fila0.getEstado());
		assertTrue(boton1Fila0.getEstado());
		assertFalse(boton0Columna0.getEstado());
		assertTrue(boton1Columna0.getEstado());
	}
	
	@Test
	public void invertirEstadoCruzTest() {
		Tablero tablero = new Tablero(3);
		Celda[] fila = tablero.obtenerFila(0);
		Celda[] columna = tablero.obtenerColumna(0);
		
		tablero.invertirEstadoCruz(0, 0);
		
		for (int indiceFila = 0; indiceFila < fila.length; indiceFila++) {
			assertTrue(fila[indiceFila].getEstado());
		}
		for (int indiceColumna = 0; indiceColumna < columna.length; indiceColumna++) {
			assertTrue(columna[indiceColumna].getEstado());
		}
	}
}
