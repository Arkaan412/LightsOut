package juego;

public class Controlador {
	private static Tablero tablero;
	
	public Controlador(Tablero t) {
		tablero = t;
	}
	
	public static void botonApretado(int fila, int columna) {
		tablero.invertirValorCelda(fila, columna);
	}
}
