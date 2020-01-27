package drawing;

import java.awt.*;

public class CafeWall {

    public static final int MORTAR = 1;
    public static void main(String[] args){
        DrawingPanel canvas = new DrawingPanel(650, 400);
        canvas.setBackground(Color.GRAY);
        Graphics g = canvas.getGraphics();

        drawLine(g, 0, 0, 4, 20);
        drawLine(g, 50, 70, 5, 30);
        drawGrid(g, 400, 20, 2, 35, 35);
        drawGrid(g, 10, 150, 4, 25, 0);
        drawGrid(g, 250, 200, 3, 25, 10);
        drawGrid(g, 425, 180, 5, 20, 10);
    }

    public static void drawLine(Graphics g, int x, int y, int length, int squareSize) {
        for (int c = 0; c < length; c++) {
            int localX = x + (2 * c * squareSize);
            int localY = y;

            g.setColor(Color.BLACK);
            g.fillRect(localX, localY, squareSize, squareSize);

            g.setColor(Color.BLUE);
            g.drawLine(localX, localY, localX + squareSize, localY + squareSize);
            g.drawLine(localX + squareSize, localY, localX, localY + squareSize);

            g.setColor(Color.WHITE);
            g.fillRect(localX + squareSize, localY, squareSize, squareSize);
        }
    }

    public static void drawGrid(Graphics g, int x, int y, int gridSize, int squareSize, int offset) {
        for(int c = 0; c < gridSize; c++) {
            for(int l = 0; l < 2 * gridSize; l++) {
                drawLine(g, x + offset * ( l % 2 ), y + (l * (squareSize + MORTAR)), gridSize, squareSize);
            }
        }
    }
}