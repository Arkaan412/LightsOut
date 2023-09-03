package juego;

public class Main {
	public static void main(String[] args) {
		MatrizBotonCelda tablero = new MatrizBotonCelda(3);
		
		Controlador controlador = new Controlador(tablero);
		
		Vista vista = new Vista();
		
//		tablero.registrarObserverEstadoCelda(vista);
		
	}
}
