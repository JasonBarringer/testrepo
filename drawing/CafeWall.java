// Jason Barringer
// 1/28/2020
// CSE142
// TA: Esther Chien
// Assignment #3
//
// This program will use DrawingPanel to draw the cafe wall illusion
package drawing;

import java.awt.*;

public class CafeWall {

    public static final int MORTAR = 1;

    //the main method initializes the canvas and then calls each of the methods to draw the lines or
    //grids in each location
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

    //the drawline method uses Graphics g to draw a line of squares of length 'length', with size
    //squaresize, starting at point (x, y). It does this by drawing pairs of squares repeatedly
    //using a for loop. It also draws a blue x over each black square.
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

    //the drawGrid method accepts the same parameters as the drawLine method with the addition of the offset
    //parameter. Also notice that length is replaced with gridSize. This is because the gridSize and length are
    //actually the same, but when talking about a square grid, length seemed like a misleading name. The offset
    //is the pixel amount by which every other line is shifted to the right.
    public static void drawGrid(Graphics g, int x, int y, int gridSize, int squareSize, int offset) {
        for(int c = 0; c < gridSize; c++) {
            for(int l = 0; l < 2 * gridSize; l++) {
                drawLine(g, x + offset * ( l % 2 ), y + (l * (squareSize + MORTAR)), gridSize, squareSize);
            }
        }
    }
}