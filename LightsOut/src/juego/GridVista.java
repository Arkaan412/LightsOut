package juego;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

public class GridVista {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GridVista window = new GridVista();
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
	public GridVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 447, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 4, 0, 0));

//		JButton button1 = new JButton("1");
//		button1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				button1.setContentAreaFilled(false);
//				button1.setOpaque(true); //Reset the opacity.
//				button1.setBackground(Color.GREEN); //Set your desired color as the background.
//			}
//		});
		JToggleButton button1 = new JToggleButton("1");
		button1.setContentAreaFilled(false);
		button1.setOpaque(true);
		button1.setBackground(Color.GREEN);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button1.isSelected()) {
//					button1.setContentAreaFilled(false);
//					button1.setOpaque(true);
					button1.setBackground(Color.GREEN.darker());
				} else {
//					button1.setContentAreaFilled(false);
//					button1.setOpaque(true);
					button1.setBackground(Color.GREEN);
					
				}
			}
		});
		frame.getContentPane().add(button1);
		JButton button2 = new JButton("2");
		button2.setContentAreaFilled(false);
		button2.setOpaque(true);

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button2.isSelected()) {
//					button1.setContentAreaFilled(false);
//					button1.setOpaque(true);
					button2.setBackground(Color.GREEN.darker());
				} else {
//					button1.setContentAreaFilled(false);
//					button1.setOpaque(true);
					button2.setBackground(Color.GREEN);
					
				}
			}
		});
		frame.getContentPane().add(button2);
		JButton button3 = new JButton("3");
		frame.getContentPane().add(button3);
		JButton button4 = new JButton("4");
		frame.getContentPane().add(button4);
		JButton button5 = new JButton("5");
		frame.getContentPane().add(button5);
		JButton button6 = new JButton("6");
		frame.getContentPane().add(button6);
		JButton button7 = new JButton("7");
		frame.getContentPane().add(button7);
		JButton button8 = new JButton("8");
		frame.getContentPane().add(button8);
		JButton button9 = new JButton("9");
		frame.getContentPane().add(button9);
		JButton button10 = new JButton("10");
		frame.getContentPane().add(button10);
		JButton button11 = new JButton("11");
		frame.getContentPane().add(button11);
		JButton button12 = new JButton("12");
		frame.getContentPane().add(button12);
		JButton button13 = new JButton("13");
		frame.getContentPane().add(button13);
		JButton button14 = new JButton("14");
		frame.getContentPane().add(button14);
		JButton button15 = new JButton("15");
		frame.getContentPane().add(button15);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.RED);
		frame.getContentPane().add(lblNewLabel);
//		JButton button16 = new JButton("16");
//		frame.getContentPane().add(button16);
	}
}
