package modelo;

import java.util.ArrayList;

import vista.ObserverEstadoCelda;

public class Tablero {
	Celda[][] botones;
	ArrayList<ObserverEstadoCelda> observers;

	public Tablero(int tamanio) {
		if (tamanio < 2)
			throw new IllegalArgumentException("La matriz debe tener un tamaño de, al menos, 2x2");

		botones = new Celda[tamanio][tamanio];

		for (int fila = 0; fila < tamanio; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				Celda botonNuevo = new Celda(fila, columna);
				botones[fila][columna] = botonNuevo;
			}
		}

		observers = new ArrayList<ObserverEstadoCelda>();
	}

	public Celda[][] getBotones() {
		return botones;
	}

	public int tamanio() {
		return botones.length;
	}

	public Celda[] obtenerFila(int fila) {
		validarFila(fila);

		return botones[fila];
	}

	public Celda[] obtenerColumna(int columna) {
		validarColumna(columna);

		Celda[] columnaARetornar = new Celda[tamanio()];

		for (int fila = 0; fila < botones.length; fila++) {
			columnaARetornar[fila] = botones[fila][columna];
		}

		return columnaARetornar;
	}

	private void validarFila(int fila) {
		if (fila < 0 || fila >= tamanio())
			throw new IllegalArgumentException("La fila indicada no es válida: " + fila);
	}

	private void validarColumna(int columna) {
		if (columna < 0 || columna >= tamanio())
			throw new IllegalArgumentException("La columna indicada no es válida: " + columna);
	}

	public void invertirEstadoFila(int fila) {
		Celda[] filaAInvertir = obtenerFila(fila);

		for (int indiceFila = 0; indiceFila < filaAInvertir.length; indiceFila++) {
			filaAInvertir[indiceFila].invertirEstadoCelda();
		}

	}

	public void invertirEstadoColumna(int columna) {
		Celda[] columnaAInvertir = obtenerColumna(columna);

		for (int indiceColumna = 0; indiceColumna < columnaAInvertir.length; indiceColumna++) {
			columnaAInvertir[indiceColumna].invertirEstadoCelda();
		}
	}

	public void invertirEstadoCruz(int fila, int columna) {
		invertirEstadoFila(fila);
		invertirEstadoColumna(columna);
		botones[fila][columna].invertirEstadoCelda();
		
		notificarObservadores(fila, columna);
	}

	public void registrarObserver(ObserverEstadoCelda observer) {
		observers.add(observer);
	}

	private void notificarObservadores(int fila, int columna) {
		for (ObserverEstadoCelda observer : observers) {
			observer.actualizar(fila, columna);
		}
	}

	public boolean verificarVictoria() {
		for (int fila = 0; fila < botones.length; fila++) {
			for (int columna = 0; columna < botones.length; columna++) {
				if (botones[fila][columna].getEstado() == true) {
					return false;
				}
			}
		}
		System.out.println("Victoria!");
		return true;
	}
}
