import javax.swing.*;
import java.awt.*;

public class Formulario extends JFrame {

    private JTextField txtNombre, txtApellido, txtDni, txtPasaporte, txtTelefono, txtCodigoPostal, txtDomicilio;
    private JButton btnValidar, btnLimpiar, btnCerrar;

    public Formulario() {
        // Configuración de la ventana principal
        setTitle("Carga de contacto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 15));
        setResizable(false);

        // --- Título Superior ---
        JLabel lblTitulo = new JLabel("Carga de contacto", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        add(lblTitulo, BorderLayout.NORTH);

        // --- Panel Central (Formulario) ---
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Inicializar campos de texto
        txtNombre = new JTextField(15);
        txtApellido = new JTextField(15);
        txtDni = new JTextField(15);
        txtPasaporte = new JTextField(15);
        txtTelefono = new JTextField(15);
        txtCodigoPostal = new JTextField(15);
        txtDomicilio = new JTextField(15);

        // Agregar filas al formulario (Etiqueta, Campo, Regla)
        agregarFila(panelFormulario, gbc, 0, "Nombre:", txtNombre, "(máximo 20 caracteres)");
        agregarFila(panelFormulario, gbc, 1, "Apellido:", txtApellido, "(máximo 20 caracteres)");
        agregarFila(panelFormulario, gbc, 2, "Dni:", txtDni, "( 8 dígitos numéricos, entre 10.000.000 y 60.000.000 )");
        agregarFila(panelFormulario, gbc, 3, "Pasaporte:", txtPasaporte, "( 1 dígito Alfabético A-Z y 8 numéricos entre 10.000.000 y 60.000.000 ) ej: N39392288");
        agregarFila(panelFormulario, gbc, 4, "Teléfono:", txtTelefono, "( > 6 dígitos numéricos y \"+()-\" ) ej:+54 9 (261)-5-012345");
        agregarFila(panelFormulario, gbc, 5, "Código Postal:", txtCodigoPostal, "( 4 dígitos numéricos )");
        agregarFila(panelFormulario, gbc, 6, "Domicilio:", txtDomicilio, "( máximo 50 chr )");

        add(panelFormulario, BorderLayout.CENTER);

        // --- Panel Inferior (Botones) ---
        JPanel panelBotonesPrincipal = new JPanel(new GridLayout(2, 1, 0, 5));
        panelBotonesPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JPanel panelBotonesArriba = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));

        btnValidar = new JButton("Validar");
        btnLimpiar = new JButton("Limpiar");

        panelBotonesArriba.add(btnValidar);
        panelBotonesArriba.add(btnLimpiar);

        JPanel panelBotonesAbajo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCerrar = new JButton("Cerrar");
        panelBotonesAbajo.add(btnCerrar);

        panelBotonesPrincipal.add(panelBotonesArriba);
        panelBotonesPrincipal.add(panelBotonesAbajo);

        add(panelBotonesPrincipal, BorderLayout.SOUTH);

        // Ajustar tamaño al contenido
        pack();
        setLocationRelativeTo(null); // Centrar en la pantalla

    }

    // Método auxiliar para construir el GridBagLayout de forma más limpia
    private void agregarFila(JPanel panel, GridBagConstraints gbc, int fila, String etiqueta, JTextField campo, String regla) {
        gbc.gridy = fila;

        // Columna 0: Etiqueta
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel(etiqueta), gbc);

        // Columna 1: Campo de texto
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(campo, gbc);

        // Columna 2: Texto de la regla
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel(regla), gbc);
    }


    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtApellido() { return txtApellido; }
    public JTextField getTxtDni() { return txtDni; }
    public JTextField getTxtPasaporte() { return txtPasaporte; }
    public JTextField getTxtTelefono() { return txtTelefono; }
    public JTextField getTxtCodigoPostal() { return txtCodigoPostal; }
    public JTextField getTxtDomicilio() { return txtDomicilio; }

    public JButton getBtnValidar() { return btnValidar; }
    public JButton getBtnLimpiar() { return btnLimpiar; }
    public JButton getBtnCerrar() { return btnCerrar; }

}