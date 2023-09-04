package modelo;

public class Celda {
	private int fila, columna;
	private boolean estado;
	
	public Celda(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
		this.estado = true;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public boolean getEstado() {
		return estado;
	}
	
	public void invertirEstadoCelda() {
		estado = !estado;
	}
}
