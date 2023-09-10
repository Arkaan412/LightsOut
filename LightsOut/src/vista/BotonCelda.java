package vista;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;

public class BotonCelda extends JButton {
	private static final long serialVersionUID = 1L;

	private int fila, columna;

	public BotonCelda(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;

		this.setSelectedFalse();
//		this.setSelectedTrue();
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public void dibujar(Container container) {
		container.add(this);
	}

	public void invertirEstado() {
		if (this.isSelected()) {
			setSelectedFalse();
		} else {
			setSelectedTrue();
		}
	}

	public void setEstado(boolean estado) {
		if (estado) {
			this.setSelectedTrue();
		} else {
			setSelectedFalse();
		}
	}

	private void setSelectedTrue() {
		this.setSelected(true);
		this.setBackground(Color.YELLOW);
	}

	private void setSelectedFalse() {
		this.setSelected(false);
		this.setBackground(Color.GRAY.darker());
	}
}
