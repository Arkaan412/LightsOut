package juego;

import java.awt.Color;
import javax.swing.JToggleButton;

public class BotonCelda extends JToggleButton{
	private static final long serialVersionUID = 1L;

	private int fila, columna;
	private boolean estado;
	
	public BotonCelda(int fila, int columna) {
		super();

		this.fila = fila;
		this.columna = columna;
		this.estado = false;

		this.setContentAreaFilled(false);
		this.setOpaque(true);
		this.setBackground(Color.GREEN.darker());
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
