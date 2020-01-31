// Jason Barringer
// 1/28/2020
// CSE142
// TA: Esther Chien
// Assignment #3
//
// This program will use DrawingPanel to draw an apple!

import java.awt.*;

public class Doodle {

        //This is the main and only method. It creates the drawing panel and draws an apple on it.
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(200, 200);

        Graphics g = panel.getGraphics();

        g.setColor(Color.GREEN);
        g.fillRect(37, 30, 5, 15);
        g.fillOval(42, 35, 10, 5);

        g.setColor(Color.RED);
        g.fillOval(20, 40, 30, 40);
        g.fillOval(30, 40, 30, 40);

    }
}