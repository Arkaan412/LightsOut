package vista;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JToggleButton;

public class BotonCelda extends JToggleButton{
	private static final long serialVersionUID = 1L;

	private int fila, columna;
	
	public BotonCelda(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
		
		this.setContentAreaFilled(false);
		this.setOpaque(true);

		this.setSelectedTrue();
		
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

	private void setSelectedTrue() {
		this.setSelected(true);
		this.setBackground(Color.GREEN);
	}

	private void setSelectedFalse() {
		this.setSelected(false);
		this.setBackground(Color.GREEN.darker());
	}
}
