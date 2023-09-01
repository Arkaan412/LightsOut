package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import juego.BotonCelda;
import juego.MatrizBotonCelda;

public class MatrizBotonCeldaTest {

	@Test(expected = IllegalArgumentException.class)
	public void tamanioInvalidoTest() {
		@SuppressWarnings("unused")
		MatrizBotonCelda matriz = new MatrizBotonCelda(1);
	}

	@Test
	public void tamanioCorrectoTest() {
		MatrizBotonCelda matriz = new MatrizBotonCelda(3);
		assertEquals(9, matriz.getTamanio());
	}
	
	@Test
	public void asignacionFilaColumnaBotonesTest() {
		MatrizBotonCelda matriz = new MatrizBotonCelda(2);
		ArrayList<BotonCelda> botones = (ArrayList<BotonCelda>) matriz.getBotones();
		
		BotonCelda boton0 = botones.get(0);
		BotonCelda boton1 = botones.get(1);
		BotonCelda boton2 = botones.get(2);
		BotonCelda boton3 = botones.get(3);
		
		assertEquals(0, boton0.getFila());
		assertEquals(0, boton0.getColumna());
		
		assertEquals(0, boton1.getFila());
		assertEquals(1, boton1.getColumna());
		
		assertEquals(1, boton2.getFila());
		assertEquals(0, boton2.getColumna());
		
		assertEquals(1, boton3.getFila());
		assertEquals(1, boton3.getColumna()); 
	}
}
