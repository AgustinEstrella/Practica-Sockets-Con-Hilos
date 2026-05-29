import java.io.IOException;

public interface Comando {
    void ejecutar(ServidorHilo cliente) throws IOException;
}
