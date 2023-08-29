package juego;

import java.util.ArrayList;

public class Tablero {
	private boolean[][] tablero;
	private ArrayList<ObserverEstadoCelda> observersEstadoCelda;

	public Tablero(int tamanioTablero) {
		if (tamanioTablero <= 0)
			throw new IllegalArgumentException("El tablero debe al menos uina celda!");

		tablero = new boolean[tamanioTablero][tamanioTablero];
		observersEstadoCelda = new ArrayList<ObserverEstadoCelda>();

		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero[fila].length; columna++) {
				tablero[fila][columna] = false;
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
		validarNroFilaYColumna(fila, columna);

		boolean valorActualCelda = obtenerValorCelda(fila, columna);
		boolean nuevoValor = !valorActualCelda;

		tablero[fila][columna] = nuevoValor;
		notificarObserversEstadoCelda(fila, columna);
	}

	private void validarNroFilaYColumna(int fila, int columna) {
		if (fila < 0 || fila > this.tamanio() - 1)
			throw new IndexOutOfBoundsException();

		if (columna < 0 || columna > this.tamanio() - 1)
			throw new IndexOutOfBoundsException();
	}

	public void invertirValorFila(int fila) {
		for (int columna = 0; columna < tablero.length; columna++) {
			invertirValorCelda(fila, columna);
		}
	}

	public void invertirValorColumna(int columna) {
		for (int fila = 0; fila < tablero.length; fila++) {
			invertirValorCelda(fila, columna);
		}
	}

	public void registrarObserverEstadoCelda(ObserverEstadoCelda observer) {
		observersEstadoCelda.add(observer);
	}

	private void notificarObserversEstadoCelda(int fila, int columna) {
		for (ObserverEstadoCelda observer : observersEstadoCelda) {
			observer.actualizar(fila, columna);
		}
	}

//	@Override
//	public String toString() {
//		String cadena = "";
//		for (int fila = 0; fila < tablero.length; fila++) {
//			for (int columna = 0; columna < tablero.length; columna++) {
//				cadena += tablero[fila][columna];
//				cadena += ", ";
//			}
//			cadena += "\n";
//		}
//		return cadena;
//	}

//	public static void main(String[] args) {
//		Tablero tablero = new Tablero(3);
//
//		System.out.println(tablero.toString());
//	}
}