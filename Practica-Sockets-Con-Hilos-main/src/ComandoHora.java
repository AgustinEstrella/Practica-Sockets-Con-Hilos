import java.io.IOException;
import java.time.LocalDateTime;

public class ComandoHora implements Comando {
    @Override
    public void ejecutar(ServidorHilo cliente) throws IOException {
        String hora = LocalDateTime.now().toString();
        cliente.getOut().writeUTF(hora);
    }
}
