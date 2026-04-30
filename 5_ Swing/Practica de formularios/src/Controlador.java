import javax.swing.JOptionPane;

public class Controlador {

    private Formulario vista;

    public Controlador(Formulario vista) {
        this.vista = vista;
        this.inicializarEventos();
    }

    private void inicializarEventos() {
        // Asignamos las acciones a los botones de la vista
        this.vista.getBtnValidar().addActionListener(e -> procesarFormulario());
        this.vista.getBtnLimpiar().addActionListener(e -> limpiarFormulario());
        this.vista.getBtnCerrar().addActionListener(e -> vista.dispose()); // Cierra la ventana
    }

    private void procesarFormulario() {
        ModeloPersona modelo = new ModeloPersona();
        // StringBuilder nos permite ir "acumulando" los mensajes de error
        StringBuilder errores = new StringBuilder();

        try { modelo.setNombre(vista.getTxtNombre().getText()); }
        catch (IllegalArgumentException ex) { errores.append("- ").append(ex.getMessage()).append("\n"); }

        try { modelo.setApellido(vista.getTxtApellido().getText()); }
        catch (IllegalArgumentException ex) { errores.append("- ").append(ex.getMessage()).append("\n"); }

        try { modelo.setDni(vista.getTxtDni().getText()); }
        catch (IllegalArgumentException ex) { errores.append("- ").append(ex.getMessage()).append("\n"); }

        try { modelo.setPasaporte(vista.getTxtPasaporte().getText()); }
        catch (IllegalArgumentException ex) { errores.append("- ").append(ex.getMessage()).append("\n"); }

        try { modelo.setTelefono(vista.getTxtTelefono().getText()); }
        catch (IllegalArgumentException ex) { errores.append("- ").append(ex.getMessage()).append("\n"); }

        try { modelo.setCp(vista.getTxtCodigoPostal().getText()); }
        catch (IllegalArgumentException ex) { errores.append("- ").append(ex.getMessage()).append("\n"); }

        try { modelo.setDireccion(vista.getTxtDomicilio().getText()); }
        catch (IllegalArgumentException ex) { errores.append("- ").append(ex.getMessage()).append("\n"); }

        // Si la longitud de errores es 0, significa que TODOS los setters funcionaron perfecto
        if (errores.length() == 0) {

            // Evaluamos la regla de negocio final
            if (!modelo.tieneIdentificacion()) {
                JOptionPane.showMessageDialog(vista, "Debe ingresar obligatoriamente un DNI o un Pasaporte.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vista, "¡Contacto validado y guardado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarFormulario(); // Limpiamos para cargar uno nuevo
            }

        } else {
            // Si hubo al menos un error, mostramos la lista completa al usuario
            JOptionPane.showMessageDialog(vista, "Por favor corrija los siguientes errores:\n\n" + errores.toString(), "Errores de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarFormulario() {
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtDni().setText("");
        vista.getTxtPasaporte().setText("");
        vista.getTxtTelefono().setText("");
        vista.getTxtCodigoPostal().setText("");
        vista.getTxtDomicilio().setText("");
    }
}