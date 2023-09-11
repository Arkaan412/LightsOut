package controlador;

import modelo.Tablero;

public class Controlador {
	private Tablero tablero;

	public Controlador(Tablero tablero) {
		this.tablero = tablero;
	}

	public void sincronizarTableroConVista() {
		tablero.sincronizarTableroConVista();
	}

	public void botonApretado(int fila, int columna) {
		tablero.invertirEstadoCruz(fila, columna);

		tablero.verificarVictoria();
	}

	public void jugarDeNuevo() {
		tablero.jugarDeNuevo();
	}
}
