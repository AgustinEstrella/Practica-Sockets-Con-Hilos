import java.io.*;
import java.net.Socket;
import java.util.*;

public class ServidorHilo extends Thread {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String nombreCliente;
    private final Map<Integer, Comando> comandos = new HashMap<>();

    public ServidorHilo(Socket socket, DataInputStream in, DataOutputStream out, String nombreCliente) {
        this.socket = socket;
        this.in = in;
        this.out = out;
        this.nombreCliente = nombreCliente;
        inicializarComandos();
    }

    private void inicializarComandos() {
        comandos.put(1, new ComandoHora());
        comandos.put(2, new ComandoResolver());
        comandos.put(3, new ComandoListar());
        comandos.put(4, new ComandoMensaje());
    }

    @Override
    public void run() {
        try {
            while (true) {
                int opcion = in.readInt();
                Comando comando = comandos.get(opcion);

                if (comando != null) {
                    comando.ejecutar(this);
                } else {
                    out.writeUTF("Opción inválida");
                }
            }
        } catch (IOException e) {
            System.out.println(nombreCliente + " se desconectó.");
            Servidor.clientes.remove(this);
        }
    }

    // Getters para permitir que los Comandos accedan a los recursos
    public DataInputStream getIn() { return in; }
    public DataOutputStream getOut() { return out; }
    public String getNombreCliente() { return nombreCliente; }
}
