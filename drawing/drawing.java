package drawing;
import java.awt.*;
public class drawing {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(400, 200);
        panel.setBackground(Color.LIGHT_GRAY);
        Graphics brush = panel.getGraphics();

        drawVan(brush, 10, 30, 100);
        drawVan(brush, 150, 10, 50);
        for(int i = 0; i < 15; i++){
            
            drawVan(brush, 10 + i * 10, 130, 40);
            panel.sleep(100);
        }
    }

    public static void drawVan(Graphics brush, int x, int y, int size) {
        int s = size/10;
        brush.setColor(Color.BLACK);
        brush.fillRect(x, y, size, size/2);

        brush.setColor(Color.CYAN);
        brush.fillRect(x + s * 7, y + s, s * 3, s * 2);

        brush.setColor(Color.RED);
        brush.fillOval(x + s, y + s * 4, s * 2, s * 2);
        brush.fillOval(x + s * 7, y + s * 4, s * 2, s * 2);
    }
}