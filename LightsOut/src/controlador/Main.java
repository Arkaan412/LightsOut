package controlador;

import modelo.Tablero;
import vista.PantallaDeJuego;

public class Main {
	public static void main(String[] args) {
		int tamanioTablero = 4;

		Tablero tablero = new Tablero(tamanioTablero);

		Controlador controlador = new Controlador(tablero);

		PantallaDeJuego pantallaDeJuego = new PantallaDeJuego(controlador, tamanioTablero);
		
		tablero.registrarObserverEstadoCelda(pantallaDeJuego);
		tablero.registrarObserverEstadoJuego(pantallaDeJuego);

		pantallaDeJuego.sincronizarTableroConVista();
		pantallaDeJuego.mostrarPantalla();
	}
}
