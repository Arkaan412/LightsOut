package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controlador.Controlador;

public class PantallaFinal extends JDialog {
	private static final long serialVersionUID = 1L;

	private PantallaDeJuego pantallaDeJuego;
	private Controlador controlador;

	public PantallaFinal(PantallaDeJuego pantallaDeJuego, Controlador controlador) {
		this.pantallaDeJuego = pantallaDeJuego;
		this.controlador = controlador;

		setBounds(100, 100, 300, 200);
		getContentPane().setLayout(null);

		setAlwaysOnTop(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JLabel lblGanaste = new JLabel("¡Ganaste!");
		lblGanaste.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanaste.setBounds(80, 11, 103, 33);
		lblGanaste.setFont(new Font("Verdana", Font.PLAIN, 20));

		getContentPane().add(lblGanaste);

		JLabel lblJugarDeNuevo = new JLabel("¿Querés jugar de nuevo?");
		lblJugarDeNuevo.setBounds(37, 55, 205, 28);
		lblJugarDeNuevo.setFont(new Font("Verdana", Font.PLAIN, 16));

		getContentPane().add(lblJugarDeNuevo);

		JButton btnSi = new JButton("Sí");
		btnSi.setBounds(37, 100, 89, 23);
		btnSi.setFont(new Font("Verdana", Font.PLAIN, 14));

		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugarDeNuevo();
			}
		});

		getContentPane().add(btnSi);

		JButton btnNo = new JButton("No");
		btnNo.setBounds(153, 100, 89, 23);
		btnNo.setFont(new Font("Verdana", Font.PLAIN, 14));

		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarJuego();
			}
		});

		getContentPane().add(btnNo);
	}

	public void jugarDeNuevo() {
		controlador.jugarDeNuevo();
		dispose();
	}

	public void cerrarJuego() {
		pantallaDeJuego.getFrame().dispose();
		dispose();
	}
}
