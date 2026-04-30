import javax.swing.*;
import java.awt.*;

public class DibujoPersonalizado extends JFrame {
    public DibujoPersonalizado(){
        super("Dibujo de Gráficos 2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500); // Tamaño fijo para mantener el dibujo
        add(new MiLienzo());
        setLocationRelativeTo(null);
    }
    class MiLienzo extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Siempre llamar al súper

            // Mejora 1: Dibujar un fondo (Cielo)
            g.setColor(new Color(135, 206, 235)); // Azul cielo
            g.fillRect(0, 0, getWidth(), getHeight());

            // Mejora 2: Dibujar pasto en la parte inferior
            g.setColor(new Color(34, 139, 34)); // Verde
            g.fillRect(0, 350, getWidth(), 150);

            // Dibujar el sol del apunte [cite: 921]
            g.setColor(Color.ORANGE);
            int radioSol = 100;
            int centroX = 250;
            int centroY = 150;
            g.fillOval(centroX - radioSol, centroY - radioSol, radioSol * 2, radioSol * 2);

            // Rayos del sol usando matemáticas
            g.setColor(Color.YELLOW);
            for (double d = 0; d < 2 * Math.PI; d += 0.2) { // Rayos más densos
                int xEnd = (int) (centroX + 130 * Math.cos(d));
                int yEnd = (int) (centroY + 130 * Math.sin(d));
                g.drawLine(centroX, centroY, xEnd, yEnd);
            }

            // Re-dibujar el cuerpo del sol por encima de los rayos para que no se crucen
            g.setColor(Color.ORANGE);
            g.fillOval(centroX - radioSol, centroY - radioSol, radioSol * 2, radioSol * 2);
        }
    }
}
