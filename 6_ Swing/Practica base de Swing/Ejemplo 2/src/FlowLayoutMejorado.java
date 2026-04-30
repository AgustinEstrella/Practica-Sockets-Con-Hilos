import javax.swing.*;
import java.awt.*;

public class FlowLayoutMejorado extends JFrame{
    public FlowLayoutMejorado(){
        super("FlowLayout Funcional");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15)); // Mejora: Añadí separación (gaps)

        JLabel etiqueta = new JLabel("Ingresa una palabra: ");
        JTextField texto = new JTextField(15);
        JButton boton = new JButton("Mayúsculas");
        JButton boton2 = new JButton("Minusculas");

        // Mejora: Darle funcionalidad real al botón
        boton.addActionListener(e -> {
            String ingresado = texto.getText();
            if (!ingresado.isEmpty()) {
                texto.setText(ingresado.toUpperCase());
            }
        });

        boton2.addActionListener(e -> {
            String ingresado = texto.getText();
            if (!ingresado.isEmpty()) {
                texto.setText(ingresado.toLowerCase());
            }
        });

        cp.add(etiqueta);
        cp.add(texto);
        cp.add(boton);
        cp.add(boton2);

        pack();
        setLocationRelativeTo(null);
    }
}
