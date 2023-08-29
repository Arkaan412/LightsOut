package juego;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Vista implements ObserverEstadoCelda {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 372, 323);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JToggleButton tglbtn_00 = new JToggleButton();
		tglbtn_00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				botonApretado.(tglbtn_00);
			}
		});
		tglbtn_00.setBounds(0, 0, 121, 96);
		frame.getContentPane().add(tglbtn_00);

		JToggleButton tglbtn_01 = new JToggleButton();
		tglbtn_01.setBounds(123, 0, 121, 96);
		frame.getContentPane().add(tglbtn_01);

		JToggleButton tglbtn_02 = new JToggleButton();
		tglbtn_02.setBounds(241, 0, 121, 96);
		frame.getContentPane().add(tglbtn_02);

		JToggleButton tglbtn_10 = new JToggleButton();
		tglbtn_10.setBounds(0, 96, 121, 96);
		frame.getContentPane().add(tglbtn_10);

		JToggleButton tglbtn_11 = new JToggleButton();
		tglbtn_11.setBounds(123, 96, 121, 96);
		frame.getContentPane().add(tglbtn_11);

		JToggleButton tglbtn_12 = new JToggleButton();
		tglbtn_12.setBounds(241, 96, 121, 96);
		frame.getContentPane().add(tglbtn_12);

		JToggleButton tglbtn_20 = new JToggleButton();
		tglbtn_20.setBounds(0, 191, 121, 96);
		frame.getContentPane().add(tglbtn_20);

		JToggleButton tglbtn_21 = new JToggleButton();
		tglbtn_21.setBounds(123, 191, 121, 96);
		frame.getContentPane().add(tglbtn_21);

		JToggleButton tglbtn_22 = new JToggleButton();
		tglbtn_22.setBounds(241, 191, 121, 96);
		frame.getContentPane().add(tglbtn_22);

	}

	@Override
	public void actualizar(int fila, int columna) {

	}
}
