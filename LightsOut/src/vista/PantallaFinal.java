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
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		setAlwaysOnTop(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JLabel lblGanaste = new JLabel("¡Ganaste!");
		lblGanaste.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblGanaste.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanaste.setBounds(164, 11, 103, 33);
		getContentPane().add(lblGanaste);

		JLabel lblJugarDeNuevo = new JLabel("¿Querés jugar de nuevo?");
		lblJugarDeNuevo.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblJugarDeNuevo.setBounds(110, 55, 217, 28);
		getContentPane().add(lblJugarDeNuevo);

		JButton btnSi = new JButton("Sí");
		btnSi.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Piola");
				jugarDeNuevo();
			}
		});
		btnSi.setBounds(110, 112, 89, 23);
		getContentPane().add(btnSi);

		JButton btnNo = new JButton("No");
		btnNo.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Mal ahí");
				cerrarJuego();
			}
		});
		btnNo.setBounds(238, 112, 89, 23);
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
