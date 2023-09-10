package vista;
import javax.swing.*;

public class MyDialog extends JDialog {

    public MyDialog(JFrame parent) {
        super(parent, "Mi Diálogo", true);
        
        // El diálogo se muestra vacío inicialmente

        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        // Agregar componentes después de que el diálogo se haya mostrado
        add(new JLabel("Este es un JLabel"));
        
        // Mostrar el diálogo
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ejemplo de JDialog");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);

            JButton showDialogButton = new JButton("Mostrar Diálogo");
            showDialogButton.addActionListener(e -> {
                new MyDialog(frame);
            });

            frame.add(showDialogButton);
            frame.setVisible(true);
        });
    }
}