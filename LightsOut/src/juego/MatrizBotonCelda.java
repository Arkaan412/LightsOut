package juego;

import java.util.ArrayList;
import java.util.List;

public class MatrizBotonCelda {
	ArrayList<BotonCelda> botones;

	public MatrizBotonCelda(int tamanio) {
		if (tamanio < 2)
			throw new IllegalArgumentException("La matriz debe tener un tamaño de, al menos, 2x2");

		botones = new ArrayList<BotonCelda>();

		for (int fila = 0; fila < tamanio; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				BotonCelda botonNuevo = new BotonCelda(fila, columna);
				botones.add(botonNuevo);
			}
		}
	}

	public List<BotonCelda> getBotones() {
		return botones;
	}

	public int getTamanio() {
		return botones.size();
	}
}
