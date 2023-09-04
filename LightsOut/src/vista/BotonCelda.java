package vista;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;

public class BotonCelda extends JButton{
	private static final long serialVersionUID = 1L;

	private int fila, columna;
	
	public BotonCelda(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;

		this.randomizarEstadoInicial();
//		this.setSelectedTrue();
	}

	private void randomizarEstadoInicial() {
		double random = Math.random();
		
		random = random * 10.0;
		
		if (random > 5)
			setSelectedFalse();
		else
			setSelectedTrue();
		
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
		this.setBackground(Color.YELLOW);
	}

	private void setSelectedFalse() {
		this.setSelected(false);
		this.setBackground(Color.GRAY.darker());
	}
}
