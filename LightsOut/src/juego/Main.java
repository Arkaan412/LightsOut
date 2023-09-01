package juego;

public class Main {
	public static void main(String[] args) {
		Tablero tablero = new Tablero(3);
		
		Controlador controlador = new Controlador(tablero);
		
		Vista vista = new Vista();
		
		tablero.registrarObserverEstadoCelda(vista);
		
	}
}
