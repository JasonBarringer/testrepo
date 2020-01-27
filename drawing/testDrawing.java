package drawing;

import java.awt.*;

public class testDrawing {
    public static final int DEFAULT_SIZE = 5;
    public static void main(String[] args) {
        DrawingPanel p = new DrawingPanel(700, 500);
        Graphics g = p.getGraphics();
        p.setBackground(Color.CYAN);
        drawSquare(g, 50, 50, 100);
        drawSquare(g, 50, 160, 130);
        drawSquare(g, 200, 50, 300, 37);
    }

    public static void drawSquare(Graphics g, int x, int y, int size) {
        drawSquare(g, x, y, size, DEFAULT_SIZE);
    }

    public static void drawSquare(Graphics g, int x, int y, int size, int lines) {
        for(int i = 1; i <= lines; i++){
            g.setColor(Color.RED);
            g.drawRect(x, y, size * i / lines, size * i / lines);
        }
        g.setColor(Color.BLACK);
        g.drawLine(x, y, x + size, y + size);
    }
}