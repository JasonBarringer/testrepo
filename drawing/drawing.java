package drawing;

import java.awt.*;

public class drawing {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(400, 200);
        panel.setBackground(Color.LIGHT_GRAY);
        Graphics brush = panel.getGraphics();
        brush.fillRect(30, 30, 40, 60);
    }
}