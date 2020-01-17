package hmmm;

import java.awt.Graphics;
import javax.swing.JComponent;

public class canvas extends JComponent {

    public void paint(Graphics g) {
        g.drawRect (50, 50, 7, 200);
    }
}