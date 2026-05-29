import java.io.IOException;

public class ComandoResolver implements Comando {
    private final CalculadoraService calculadora = new CalculadoraService();

    @Override
    public void ejecutar(ServidorHilo cliente) throws IOException {
        String funcion = cliente.getIn().readUTF();
        String resultado = calculadora.procesarComando(funcion);
        cliente.getOut().writeUTF("Resultado: " + resultado);
    }
}
