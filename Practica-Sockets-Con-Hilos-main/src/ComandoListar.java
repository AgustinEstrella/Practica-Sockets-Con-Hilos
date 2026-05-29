import java.io.IOException;

public class ComandoListar implements Comando {
    @Override
    public void ejecutar(ServidorHilo cliente) throws IOException {
        StringBuilder lista = new StringBuilder("Clientes conectados:\n");

        for (ServidorHilo c : Servidor.clientes) {
            lista.append("- ").append(c.getNombreCliente()).append("\n");
        }

        cliente.getOut().writeUTF(lista.toString());
    }
}
