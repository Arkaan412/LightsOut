package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controlador.Controlador;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaDeJuego implements ActionListener, ObserverEstadoCelda {

	private JFrame frame;
	private BotonCelda[][] celdas;
	private int tamanio;
	private Controlador controlador;

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

		celdas = new BotonCelda[tamanio][tamanio];

		cargarCeldas();

		sincronizarTableroConVista();
	}

	private void cargarCeldas() {
		for (int fila = 0; fila < celdas.length; fila++) {
			for (int columna = 0; columna < celdas.length; columna++) {
				BotonCelda boton = new BotonCelda(fila, columna);

				boton.setText(fila + " - " + columna); // SACAR

				frame.getContentPane().add(boton);

				boton.addActionListener(this);

				celdas[fila][columna] = boton;
			}
		}
	}

	private void invertirEstadoCelda(BotonCelda celda) {
		celda.invertirEstado();
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

		return celdas[fila];
	}

	public BotonCelda[] obtenerColumna(int columna) {
		validarColumna(columna);

		BotonCelda[] columnaARetornar = new BotonCelda[tamanio];

		for (int fila = 0; fila < celdas.length; fila++) {
			columnaARetornar[fila] = celdas[fila][columna];
		}

		return columnaARetornar;
	}

	public BotonCelda[][] obtenerCeldas() {
		return celdas;
	}

	public void invertirEstadoFila(int fila) {
		BotonCelda[] filaAInvertir = obtenerFila(fila);

		for (int indiceFila = 0; indiceFila < filaAInvertir.length; indiceFila++) {
			invertirEstadoCelda(filaAInvertir[indiceFila]);
		}
	}

	public void invertirEstadoColumna(int columna) {
		BotonCelda[] columnaAInvertir = obtenerColumna(columna);

		for (int indiceColumna = 0; indiceColumna < columnaAInvertir.length; indiceColumna++) {
			invertirEstadoCelda(columnaAInvertir[indiceColumna]);
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

	public void mostrarPantalla() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void invertirEstadoCruz(int fila, int columna) {
		invertirEstadoFila(fila);
		invertirEstadoColumna(columna);
		invertirEstadoCelda(celdas[fila][columna]);
	}

	public void sincronizarTableroConVista() {
		boolean[][] tableroVista = new boolean[tamanio][tamanio];

		for (int fila = 0; fila < tamanio; fila++) {
			for (int columna = 0; columna < tamanio; columna++) {
				tableroVista[fila][columna] = celdas[fila][columna].isSelected();
			}
		}
		
		controlador.sincronizarTableroConVista(tableroVista);
	}
}