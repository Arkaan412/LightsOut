package modelo;

import java.util.ArrayList;

import observers.ObserverEstadoCeldas;
import observers.ObserverEstadoJuego;

public class Tablero {
	Celda[][] celdas;
	ArrayList<ObserverEstadoCeldas> observersEstadoCeldas;
	ArrayList<ObserverEstadoJuego> observersEstadoJuego;

	public Tablero(int tamanio) {
		if (tamanio < 2)
			throw new IllegalArgumentException("La matriz debe tener un tamaño de, al menos, 2x2");

		celdas = new Celda[tamanio][tamanio];

		inicializarTablero();

		observersEstadoCeldas = new ArrayList<ObserverEstadoCeldas>();
		observersEstadoJuego = new ArrayList<ObserverEstadoJuego>();
	}

	private void inicializarTablero() {
		for (int fila = 0; fila < tamanio(); fila++) {
			for (int columna = 0; columna < tamanio(); columna++) {
				Celda celdaNueva = new Celda(fila, columna);
				celdas[fila][columna] = celdaNueva;
			}
		}
	}

	public Celda[][] getCeldas() {
		return celdas;
	}

	public int tamanio() {
		return celdas.length;
	}

	public Celda[] obtenerFila(int fila) {
		validarFila(fila);

		return celdas[fila];
	}

	public Celda[] obtenerColumna(int columna) {
		validarColumna(columna);

		Celda[] columnaARetornar = new Celda[tamanio()];

		for (int fila = 0; fila < celdas.length; fila++) {
			columnaARetornar[fila] = celdas[fila][columna];
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
		celdas[fila][columna].invertirEstadoCelda();

		notificarObservadoresEstadoCeldas(fila, columna);
	}

	public void registrarObserverEstadoCelda(ObserverEstadoCeldas observer) {
		observersEstadoCeldas.add(observer);
	}

	private void notificarObservadoresEstadoCeldas(int fila, int columna) {
		for (ObserverEstadoCeldas observer : observersEstadoCeldas) {
			observer.actualizar(fila, columna);
		}
	}

	public void registrarObserverEstadoJuego(ObserverEstadoJuego observer) {
		observersEstadoJuego.add(observer);
	}

	private void notificarObservadoresEstadoJuego() {
		for (ObserverEstadoJuego observer : observersEstadoJuego) {
			observer.notificar();
		}
	}

	public void verificarVictoria() {
		for (int fila = 0; fila < celdas.length; fila++) {
			for (int columna = 0; columna < celdas.length; columna++) {
				if (celdas[fila][columna].getEstado() == true) {
					return;
				}
			}
		}
		notificarObservadoresEstadoJuego();
	}

	public void sincronizarTableroConVista() {
		int tamanioTablero = celdas.length;

		boolean[][] valoresDelTablero = new boolean[tamanioTablero][tamanioTablero];

		for (int fila = 0; fila < celdas.length; fila++) {
			for (int columna = 0; columna < celdas.length; columna++) {
				boolean estado = celdas[fila][columna].getEstado();

				valoresDelTablero[fila][columna] = estado;
			}
		}

		for (ObserverEstadoCeldas observer : observersEstadoCeldas) {
			observer.actualizar(valoresDelTablero);
		}
	}

	public void jugarDeNuevo() {
		inicializarTablero();
		sincronizarTableroConVista();
	}
}
