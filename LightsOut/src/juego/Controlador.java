package juego;

public class Controlador {
	private Tablero tablero;
	
	public Controlador(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public void invertirValorCelda(int fila, int columna) {
		tablero.invertirValorCelda(fila, columna);
	}
}
