import java.io.IOException;

public class ComandoMensaje implements Comando {
    @Override
    public void ejecutar(ServidorHilo cliente) throws IOException {
        String mensaje = cliente.getIn().readUTF();

        // Guardar el mensaje en la base de datos
        DatabaseManager.saveMessage(cliente.getNombreCliente(), mensaje);

        for (ServidorHilo c : Servidor.clientes) {
            c.getOut().writeUTF(cliente.getNombreCliente() + ": " + mensaje);
            c.getOut().flush();
        }
    }
}
