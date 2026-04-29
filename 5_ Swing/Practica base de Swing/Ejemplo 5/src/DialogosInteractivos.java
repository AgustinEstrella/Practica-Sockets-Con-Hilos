import javax.swing.*;
import java.awt.*;

public class DialogosInteractivos extends JFrame {
    public DialogosInteractivos() {
        super("Manejo de JOptionPane");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnSaludar = new JButton("Ingresar al sistema");
        btnSaludar.setPreferredSize(new Dimension(200, 50));

        btnSaludar.addActionListener(e -> {
            // Diálogo de entrada
            String nombre = JOptionPane.showInputDialog(this,
                    "Por favor, identifíquese ingresando su nombre:",
                    "Control de Acceso", JOptionPane.QUESTION_MESSAGE);

            // Mejora: Lógica condicional basada en la respuesta
            if (nombre == null || nombre.trim().isEmpty()) {
                // Diálogo de advertencia
                JOptionPane.showMessageDialog(this,
                        "No ingresó ningún nombre. Acceso denegado.",
                        "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                // Diálogo de información
                JOptionPane.showMessageDialog(this,
                        "¡Bienvenido al sistema de Ingeniería, " + nombre.trim() + "!",
                        "Acceso Concedido", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        add(btnSaludar);
        setSize(300, 150);
        setLocationRelativeTo(null);
    }
}
