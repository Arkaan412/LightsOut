package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import juego.BotonCelda;
import juego.MatrizBotonCelda;

public class MatrizBotonCeldaTest {
	@Test
	public void asignacionCorrectaDeFilaYColumnaEnBotonesTest() {
		MatrizBotonCelda matriz = new MatrizBotonCelda(2);
		BotonCelda[][] botones = matriz.getBotones();
		
		BotonCelda boton0 = botones[0][0];
		BotonCelda boton1 = botones[0][1];
		BotonCelda boton2 = botones[1][0];
		BotonCelda boton3 = botones[1][1];
		
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
		MatrizBotonCelda matriz = new MatrizBotonCelda(1);
	}

	@Test
	public void tamanioTest() {
		MatrizBotonCelda matriz = new MatrizBotonCelda(3);
		assertEquals(3, matriz.tamanio());
	}
	
	@SuppressWarnings("unused")
	@Test (expected= IllegalArgumentException.class)
	public void obtenerFilaInvalidaTest() {
		MatrizBotonCelda matriz = new MatrizBotonCelda(3);
		BotonCelda[] filaBotones3 = matriz.obtenerFila(3);
	}
	
	@Test
	public void obtenerFilaTest() {
		MatrizBotonCelda matriz = new MatrizBotonCelda(2);
		BotonCelda[] filaBotones0 = matriz.obtenerFila(0);
		
		BotonCelda boton0 = filaBotones0[0];
		BotonCelda boton1 = filaBotones0[1];
		
		assertEquals(0, boton0.getFila());
		assertEquals(0, boton1.getFila());
	}
	
	@SuppressWarnings("unused")
	@Test (expected= IllegalArgumentException.class)
	public void obtenerColumnaInvalidaTest() {
		MatrizBotonCelda matriz = new MatrizBotonCelda(3);
		BotonCelda[] columnaBotones3 = matriz.obtenerColumna(3);
	}

	@Test
	public void obtenerColumnaTest() {
		MatrizBotonCelda matriz = new MatrizBotonCelda(2);
		BotonCelda[] columnaBotones0 = matriz.obtenerColumna(0);
		
		BotonCelda boton0 = columnaBotones0[0];
		BotonCelda boton1 = columnaBotones0[1];
		
		assertEquals(0, boton0.getColumna());
		assertEquals(0, boton1.getColumna());
	}
	
	@Test
	public void invertirEstadoFilaTest() {
		MatrizBotonCelda matriz = new MatrizBotonCelda(2);
		BotonCelda[] filaBotones0 = matriz.obtenerFila(0);
		
		matriz.invertirEstadoFila(0);
		
		BotonCelda boton0 = filaBotones0[0];
		BotonCelda boton1 = filaBotones0[1];
		
		assertTrue(boton0.getEstado());
		assertTrue(boton1.getEstado());
	}
	
	@Test
	public void invertirEstadoColumnaTest() {
		MatrizBotonCelda matriz = new MatrizBotonCelda(2);
		BotonCelda[] columnaBotones0 = matriz.obtenerColumna(0);
		
		matriz.invertirEstadoColumna(0);
		
		BotonCelda boton0 = columnaBotones0[0];
		BotonCelda boton1 = columnaBotones0[1];
		
		assertTrue(boton0.getEstado());
		assertTrue(boton1.getEstado());
	}
	
	@Test
	public void invertirEstadoFilaYColumnaTest() {
		MatrizBotonCelda matriz = new MatrizBotonCelda(2);
		BotonCelda[] filaBotones0 = matriz.obtenerFila(0);
		BotonCelda[] columnaBotones0 = matriz.obtenerColumna(0);
		
		matriz.invertirEstadoFila(0);		
		matriz.invertirEstadoColumna(0);
		
		BotonCelda boton0Fila0 = filaBotones0[0];
		BotonCelda boton1Fila0 = filaBotones0[1];
		BotonCelda boton0Columna0 = columnaBotones0[0];
		BotonCelda boton1Columna0 = columnaBotones0[1];
		
		assertFalse(boton0Fila0.getEstado());
		assertTrue(boton1Fila0.getEstado());
		assertFalse(boton0Columna0.getEstado());
		assertTrue(boton1Columna0.getEstado());
	}
}
