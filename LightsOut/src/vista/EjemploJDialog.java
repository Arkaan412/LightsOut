package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


// AQU� EMPIEZA LA CLASE
public class EjemploJDialog extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private final JPanel contentPanel = new JPanel();

    /* ESTO LO GENERA ECLIPSE PARA PROBAR MIENTRAS CONSTRUIMOS
     * EL DIALOGO, LO PODEMOS DESCOMENTAR PARA
     * PROBAR EL DI�LOGO SIN PROBAR TODA LA APLICACI�N COMPLETA 
    public static void main(String[] args) {
        try {
            EjemploJDialog dialog = new EjemploJDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    // CONSTRUCTOR DE LA CLASE
    // crea la ventana, con los bordes, botones,
    // y todos los componentes internos para hacer lo que
    // se pretenda con �ste di�logo.
    public EjemploJDialog() {
        // evita cambio de tama�o
        setResizable(false);
        // t�tulo del di�olog
        setTitle("u00C9sto es una ventana de diu00E1logo");
        // dimensiones que ocupa en la pantalla
        setBounds(100, 100, 450, 229);
        // capa que contendr� todo
        getContentPane().setLayout(new BorderLayout());
        // borde de la ventan
//        getContentPane().setBorder(new EmptyBorder(5, 5, 5, 5));
        // pone el panel centrado
//        getContentPane().add(getContentPane(), BorderLayout.CENTER);
        // sin capas para poder posicionar los elementos por coordenadas 
        getContentPane().setLayout(null);
        {
            // aqu� se pone el JTextArea dentro de un JScrollPane 
            // para que tenga barras de desplazamiento
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(10, 11, 424, 146);
            getContentPane().add(scrollPane);
            {
                JTextArea txtrstoEsUn = new JTextArea();
                txtrstoEsUn.setText("u00C9sto es un JTextArea, aquu00ED podemos poner un texto de varias lu00EDneas.rn1rn2rn3rn..rnrnObserva que no se ve en la barra de tareas que exista u00E9sta ventana.  Si fuera un JFrame su00ED que se veru00EDa en la barra de tareas con el texto  del tu00EDtulo de la ventana...rnrnEl componente JTextArea estu00E1 dentro de un JScrollPane para que se  visualizen las barras de scroll cuando sea necesario.rnrnLa ventana tiene el atributo 'resizable' a 'false' para evitar que se pueda cambiar el tamau00F1o.rnrnrnrnrnrnFin del texto.");
                txtrstoEsUn.setLineWrap(true);
                txtrstoEsUn.setAutoscrolls(true);
                scrollPane.setViewportView(txtrstoEsUn);
            }
        }
        {
            // a continuaci�n tenemos los botones cl�sicos 'Vale' y 'Cancela'
            // �ste c�digo lo ha generado Eclipse...
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("Vale");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // aqu� van las acciones al hacer click en Vale
                        // env�a el di�logo al recolector de basura de Java
                        dispose();
                    }
                });
                okButton.setActionCommand("Vale");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancelar");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        // aqu� van las acciones al hacer click en Vale
                        // env�a el di�logo al recolector de basura de Java
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancelar");
                buttonPane.add(cancelButton);
            }
        }
    }
}
