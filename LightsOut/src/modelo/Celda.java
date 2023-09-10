package modelo;

public class Celda {
	private int fila, columna;
	private boolean estado;

	public Celda(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;

		randomizarEstadoInicial();

//		this.estado = false;
//		this.estado = true;
	}

	private void randomizarEstadoInicial() {
		double random = Math.random();

		random = random * 10.0;

		if (random > 5)
			setEstado(false);
		else
			setEstado(true);

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

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
