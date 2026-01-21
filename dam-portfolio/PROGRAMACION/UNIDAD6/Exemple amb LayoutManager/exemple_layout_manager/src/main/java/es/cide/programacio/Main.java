package es.cide.programacio;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Creem la finestra principal (JFrame)
        JFrame finestra = new JFrame("Exemple LayoutManager");
        finestra.setSize(500, 300);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new BorderLayout());

        // Creem un panell Superior amb FlowLayout
        JPanel panellSuperior = new JPanel();
        panellSuperior.setLayout(new FlowLayout());
        panellSuperior.add(new JButton("Botó 1"));
        panellSuperior.add(new JButton("Botó 2"));
        panellSuperior.add(new JButton("Botó 3"));

        // Creem un panell central amb GridLayout
        JPanel panellCentral = new JPanel();
        panellCentral.setLayout(new GridLayout(2, 2));
        panellCentral.add(new JLabel("Etiqueta 1"));
        panellCentral.add(new JTextField("Text 1"));
        panellCentral.add(new JLabel("Etiqueta 2"));
        panellCentral.add(new JTextField("Text 2"));

        // Afegim el panel a la finestra
        finestra.add(panellSuperior, BorderLayout.NORTH);
        finestra.add(panellCentral, BorderLayout.CENTER);

        // LOOK & FEEL
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Fem la finestra visible
        finestra.setVisible(true);

    }
}