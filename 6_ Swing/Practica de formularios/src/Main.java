import javax.swing.*;

public static void main(String[] args) {

    Formulario ventana = new Formulario();
    Controlador controlador = new Controlador(ventana);
    ventana.setVisible(true);


}
