import java.util.ArrayList;

public class Tablero {
	private boolean[][] tablero;
	private ArrayList<ObserverEstadoCelda> observersEstadoCelda;
	
	public Tablero(int tamanioMatriz) {
		tablero = new boolean[tamanioMatriz][tamanioMatriz];

		inicializarMatriz();
		observersEstadoCelda = new ArrayList<ObserverEstadoCelda>();
	}

	private void inicializarMatriz() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = false;
			}
		}
	}
	
	public int tamanio() {
		return tablero.length;
	}

	public boolean obtenerValorCelda(int fila, int columna) {
		return tablero[fila][columna];
	}

	public boolean[] obtenerFila(int fila) {
		return tablero[fila];
	}

	public boolean[] obtenerColumna(int columna) {
		return tablero[columna];
	}


	public void invertirValorCelda(int fila, int columna) {
		boolean valorActualCelda = obtenerValorCelda(fila, columna);
		boolean nuevoValor = !valorActualCelda;

		tablero[fila][columna] = nuevoValor;
		notificarObserversEstadoCelda();
	}

	private void notificarObserversEstadoCelda() {
		for(ObserverEstadoCelda observer: observersEstadoCelda) {
			observer.notificar();
		}
	}

	public void invertirValorFila(int fila) {
		for (int i = 0; i < tablero.length; i++) {
			invertirValorCelda(fila, i);
		}
	}

	public void invertirValorColumna(int columna) {
		for (int i = 0; i < tablero.length; i++) {
			invertirValorCelda(i, columna);
		}
	}

	@Override
	public String toString() {
		String cadena = "";
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				cadena += tablero[i][j];
				cadena += ", ";
			}
			cadena += "\n";
		}
		return cadena;
	}
	
	public void registrarObserverEstadoCelda(ObserverEstadoCelda observer) {
		observersEstadoCelda.add(observer);
	}

	public static void main(String[] args) {
		Tablero tablero = new Tablero(3);
		
		System.out.println(tablero.toString());
	}
}