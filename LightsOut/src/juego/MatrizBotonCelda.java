package juego;

//import java.util.ArrayList;
//import java.util.List;

public class MatrizBotonCelda {
	BotonCelda[][] botones;

	public MatrizBotonCelda(int tamanio) {
		if (tamanio < 2)
			throw new IllegalArgumentException("La matriz debe tener un tamaño de, al menos, 2x2");

		botones = new BotonCelda[tamanio][tamanio];

		for (int fila = 0; fila < tamanio; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				BotonCelda botonNuevo = new BotonCelda(fila, columna);
				botones[fila][columna] = botonNuevo;
			}
		}
	}

	public BotonCelda[][] getBotones() {
		return botones;
	}

	public int tamanio() {
		return botones.length;
	}

	public BotonCelda[] obtenerFila(int fila) {
		validarFila(fila);

		return botones[fila];
	}

	public BotonCelda[] obtenerColumna(int columna) {
		validarColumna(columna);

		BotonCelda[] columnaARetornar = new BotonCelda[tamanio()];

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
		BotonCelda[] filaAInvertir = obtenerFila(fila);

		for (int indiceFila = 0; indiceFila < filaAInvertir.length; indiceFila++) {
			filaAInvertir[indiceFila].invertirEstadoCelda();
		}

	}

	public void invertirEstadoColumna(int columna) {
		BotonCelda[] columnaAInvertir = obtenerColumna(columna);
		
		for (int indiceColumna = 0; indiceColumna < columnaAInvertir.length; indiceColumna++) {
			columnaAInvertir[indiceColumna].invertirEstadoCelda();
		}
	}
}
