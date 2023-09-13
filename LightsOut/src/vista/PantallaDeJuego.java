package vista;

import javax.swing.JFrame;

import controlador.Controlador;
import observers.ObserverEstadoCeldas;
import observers.ObserverEstadoJuego;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaDeJuego implements ActionListener, ObserverEstadoCeldas, ObserverEstadoJuego {

	private JFrame frame;
	private Controlador controlador;

	private BotonCelda[][] botones;
	private int tamanio;;

	public PantallaDeJuego(Controlador controlador, int tamanio) {
		this.controlador = controlador;
		this.tamanio = tamanio;

		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(new GridLayout(tamanio, tamanio, 0, 0));

		botones = new BotonCelda[tamanio][tamanio];

		inicializarYCargarBotones();
	}

	private void inicializarYCargarBotones() {
		for (int fila = 0; fila < botones.length; fila++) {
			for (int columna = 0; columna < botones.length; columna++) {
				BotonCelda boton = new BotonCelda(fila, columna);

//				boton.setText(fila + " - " + columna);

				frame.getContentPane().add(boton);

				boton.addActionListener(this);

				botones[fila][columna] = boton;
			}
		}
	}

	public void mostrarPantalla() {
		frame.setVisible(true);
	}

	private void invertirEstadoBoton(BotonCelda boton) {
		boton.invertirEstado();
	}

	private void validarFila(int fila) {
		if (fila < 0 || fila >= tamanio)
			throw new IllegalArgumentException("La fila indicada no es válida: " + fila);
	}

	private void validarColumna(int columna) {
		if (columna < 0 || columna >= tamanio)
			throw new IllegalArgumentException("La columna indicada no es válida: " + columna);
	}

	public BotonCelda[] obtenerFila(int fila) {
		validarFila(fila);

		return botones[fila];
	}

	public BotonCelda[] obtenerColumna(int columna) {
		validarColumna(columna);

		BotonCelda[] columnaARetornar = new BotonCelda[tamanio];

		for (int fila = 0; fila < botones.length; fila++) {
			columnaARetornar[fila] = botones[fila][columna];
		}

		return columnaARetornar;
	}

	public BotonCelda[][] obtenerCeldas() {
		return botones;
	}

	public void invertirEstadoFila(int fila) {
		BotonCelda[] filaAInvertir = obtenerFila(fila);

		for (int indiceFila = 0; indiceFila < filaAInvertir.length; indiceFila++) {
			invertirEstadoBoton(filaAInvertir[indiceFila]);
		}
	}

	public void invertirEstadoColumna(int columna) {
		BotonCelda[] columnaAInvertir = obtenerColumna(columna);

		for (int indiceColumna = 0; indiceColumna < columnaAInvertir.length; indiceColumna++) {
			invertirEstadoBoton(columnaAInvertir[indiceColumna]);
		}
	}

	public void invertirEstadoCruz(int fila, int columna) {
		invertirEstadoFila(fila);
		invertirEstadoColumna(columna);
		invertirEstadoBoton(botones[fila][columna]);
	}

	public void sincronizarTableroConVista() {
		controlador.sincronizarTableroConVista();
	}

	@Override
	public void actualizar(boolean[][] valoresDelTablero) {
		boolean[][] matriz = new boolean[tamanio][tamanio];

		for (int fila = 0; fila < botones.length; fila++) {
			for (int columna = 0; columna < botones.length; columna++) {
				boolean estadoActualizado = valoresDelTablero[fila][columna];
				matriz[fila][columna] = valoresDelTablero[fila][columna];
				botones[fila][columna].setEstado(estadoActualizado);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		BotonCelda boton = (BotonCelda) evento.getSource();

		controlador.botonApretado(boton.getFila(), boton.getColumna());
	}

	@Override
	public void actualizar(int fila, int columna) {
		invertirEstadoCruz(fila, columna);
	}

	@Override
	public void notificar() {
		victoria();
	}

	public void victoria() {
		PantallaFinal pantallaFinal;
		pantallaFinal = new PantallaFinal(this, controlador);

		pantallaFinal.setLocationRelativeTo(frame);
		pantallaFinal.setModal(true);
		pantallaFinal.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}
}