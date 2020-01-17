package hmmm;

import javax.swing.JFrame;

public class draw {
    public guy guy = new guy(100);
    public static void main(String[] args) {
        canvas canvas = new canvas();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 1000, 1000);
        window.getContentPane().add(canvas);
        window.setVisible(true);
        window.repaint();
    }
}