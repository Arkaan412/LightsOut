package controlador;

import modelo.Tablero;

public class Controlador {
	private Tablero tablero;

	public Controlador(Tablero tablero) {
		this.tablero = tablero;
	}

	public void botonApretado(int fila, int columna) {
		tablero.invertirEstadoCruz(fila, columna);

		tablero.verificarVictoria();
	}
}
