package es.cide.programacio;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class ProvaSwing {
    public static void main(String[] args) {
        JFrame Frame = new JFrame("Ventana");
        Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hola Mundo");
        Frame.getContentPane().add(label);
        Frame.pack();
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
    }
}
