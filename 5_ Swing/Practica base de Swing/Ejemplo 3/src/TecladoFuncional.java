import javax.swing.*;
import java.awt.*;

public class TecladoFuncional extends JFrame {
    public TecladoFuncional() {
        super("Teclado Numérico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 350);
        setLayout(new BorderLayout()); // Divido la ventana en zonas

        // Mejora: Pantalla superior para ver lo que se teclea
        JTextField pantalla = new JTextField();
        pantalla.setEditable(false); // Solo se escribe tocando los botones
        pantalla.setFont(new Font("Consolas", Font.BOLD, 24));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        add(pantalla, BorderLayout.NORTH);

        // Panel del teclado usando GridLayout del apunte
        JPanel panelTeclas = new JPanel(new GridLayout(4, 3, 5, 5)); // [cite: 240] Con gaps
        panelTeclas.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        String[] botones = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};

        for (String txt : botones) {
            JButton btn = new JButton(txt);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            // Acción: Al pulsar, concatenar el texto en la pantalla
            btn.addActionListener(e -> pantalla.setText(pantalla.getText() + txt));
            panelTeclas.add(btn);
        }

        add(panelTeclas, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }
}
