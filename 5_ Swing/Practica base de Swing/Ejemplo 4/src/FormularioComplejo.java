import javax.swing.*;
import java.awt.*;

public class FormularioComplejo extends JFrame {

    public FormularioComplejo() {
        super("Alta de Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel de datos [cite: 346]
        JPanel panelDatos = new JPanel(new GridLayout(3, 2, 5, 10));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Información Personal")); // Mejora visual

        JTextField txtNombre = new JTextField(15);
        JTextField txtDni = new JTextField(15);
        JTextField txtFecha = new JTextField(10);

        panelDatos.add(new JLabel("Nombre Completo:"));
        panelDatos.add(txtNombre);
        panelDatos.add(new JLabel("DNI:"));
        panelDatos.add(txtDni);
        panelDatos.add(new JLabel("Nacimiento (DD/MM/AAAA):"));
        panelDatos.add(txtFecha);

        // Panel de botones [cite: 361]
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAceptar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Limpiar");

        // Acciones mejoradas
        btnAceptar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Usuario guardado:\n" + txtNombre.getText() + " - " + txtDni.getText(),
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
        });

        btnCancelar.addActionListener(e -> {
            txtNombre.setText("");
            txtDni.setText("");
            txtFecha.setText("");
        });

        panelBotones.add(btnCancelar);
        panelBotones.add(btnAceptar);

        // Añadir a la ventana
        add(panelDatos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }
}
