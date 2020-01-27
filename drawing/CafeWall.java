package drawing;

import java.awt.*;

public class CafeWall {

    //Class constant that controls space between lines in a grid
    public static final int MORTAR = 2;

    //Main method initializes the canvas and graphics, then calls the drawing methods
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

    //DrawLine draws a line of squares from point (x, y) with specified square size and line length.
    //length is measured in pairs of squares (black and white)
    public static void drawLine(Graphics g, int x, int y, int length, int squareSize) {
        for (int c = 0; c < length; c++) {
            int localX = x + (2 * c * squareSize);

            g.setColor(Color.BLACK);
            g.fillRect(localX, y, squareSize, squareSize);

            g.setColor(Color.BLUE);
            g.drawLine(localX, y, localX + squareSize, y + squareSize);
            g.drawLine(localX + squareSize, y, localX, y + squareSize);

            g.setColor(Color.WHITE);
            g.fillRect(localX + squareSize, y, squareSize, squareSize);
        }
    }

    //drawGrid draws repeatedly calls the drawLine method to draw a grid of squares.
    //in addition to the parameters of the drawLine method, this includes gridSize and offset.
    //gridSize is the height of the grid, and offset is the pixel offset of every other line.
    public static void drawGrid(Graphics g, int x, int y, int gridSize, int squareSize, int offset) {
        for(int c = 0; c < gridSize; c++) {
            for(int l = 0; l < 2 * gridSize; l++) {
                drawLine(g, x + offset * ( l % 2 ), y + (l * (squareSize + MORTAR)), gridSize, squareSize);
            }
        }
    }
}