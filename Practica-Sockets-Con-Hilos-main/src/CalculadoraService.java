import java.util.*;

public class
CalculadoraService {

    public String procesarComando(String input) {
        try {
            String ecuacion = input;

            // Soporte opcional por si alguien sigue enviando el formato RESOLVE "..."
            if (input.contains("\"")) {
                int p1 = input.indexOf('"');
                int p2 = input.lastIndexOf('"');
                ecuacion = input.substring(p1 + 1, p2);
            }

            double resultado = resolverEcuacion(ecuacion);
            return String.valueOf(resultado);
        } catch (Exception e) {
            return "Error al calcular. Asegúrese de ingresar una ecuación válida.";
        }
    }

    private double resolverEcuacion(String ecuacion) {
        List<Double> numeros = new ArrayList<>();
        List<Character> operadores = new ArrayList<>();

        String numero = "";

        for (char c : ecuacion.toCharArray()) {
            if ("+-*/".indexOf(c) >= 0) {
                numeros.add(Double.parseDouble(numero));
                operadores.add(c);
                numero = "";
            } else {
                numero += c;
            }
        }

        numeros.add(Double.parseDouble(numero));

        for (int i = 0; i < operadores.size(); i++) {
            char op = operadores.get(i);

            if (op == '*' || op == '/') {
                double a = numeros.get(i);
                double b = numeros.get(i + 1);

                double resultado = (op == '*') ? a * b : a / b;

                numeros.set(i, resultado);
                numeros.remove(i + 1);
                operadores.remove(i);

                i--;
            }
        }

        double resultadoFinal = numeros.get(0);

        for (int i = 0; i < operadores.size(); i++) {
            if (operadores.get(i) == '+')
                resultadoFinal += numeros.get(i + 1);
            else
                resultadoFinal -= numeros.get(i + 1);
        }

        return resultadoFinal;
    }
}
