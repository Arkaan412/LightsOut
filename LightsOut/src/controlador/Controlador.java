package controlador;

import modelo.Tablero;

public class Controlador {
	private Tablero tablero;

	public Controlador(Tablero tablero) {
		this.tablero = tablero;
	}

	public void sincronizarTableroConVista(boolean[][] tableroVista) {
		tablero.sincronizarTableroConVista(tableroVista);
	}

	public void botonApretado(int fila, int columna) {
		tablero.invertirEstadoCruz(fila, columna);

		tablero.verificarVictoria();
	}
}
