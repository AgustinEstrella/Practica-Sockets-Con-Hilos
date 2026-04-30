import javax.swing.*;
import java.awt.*;

public class VentanaBasica extends JFrame{
    public VentanaBasica() {
        super("Mi Primera Ventana Mejorada"); // Título [cite: 52]
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierre [cite: 54]

        // Mejora: Usar un panel principal con un color agradable y un texto centrado
        JPanel panel = new JPanel();
        panel.setBackground(new Color(220, 230, 240)); // Un tono celeste pastel
        panel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100)); // Márgenes

        JLabel etiqueta = new JLabel("¡Ventana inicializada correctamente!");
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(etiqueta);

        setContentPane(panel);
        pack(); // Ajusta el tamaño al contenido
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    public static void main(String[] args) {

    }
}
