package es.cide.programacio;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExempleDialog {
    public static void main(String[] args) {
        //Creem el JFrame principal
        JFrame finestra = new JFrame("Exemple JDialog");
        finestra.setSize(400,200);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new FlowLayout());

        //Botó per obrir el JDialog
        JButton botoObrir = new JButton("Obrir diàleg");
        finestra.add(botoObrir);
        
        //Afegim un Listener per obrir el JDialog quan es premi
        botoObrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mostrarDialeg(finestra);
            }
        });

        //Fem visible la finestra principal
        finestra.setVisible(true);
    }
        //Mètode per crear i mostrar un JDialog
        private static void mostrarDialeg(JFrame parent){
            //Creem el dialeg modal (bloquetja la finestra principal fins que es tanqui)
            JDialog dialeg = new JDialog(parent, "Missatje important", true);
            dialeg.setSize(300,150);
            dialeg.setLayout(new BorderLayout());

            //Afegim un missatge
            JLabel etiqueta = new JLabel("Aixó es un diàleg!", JLabel.CENTER);
            dialeg.add(etiqueta, BorderLayout.CENTER);

            //Botó per tancar el diàleg
            JButton botoTancar =new JButton("D'acord");
            botoTancar.addActionListener(e-> dialeg.dispose());
            dialeg.add(botoTancar, BorderLayout.SOUTH);

            //Fem visible el diàleg
            dialeg.setLocationRelativeTo(parent);
            dialeg.setVisible(true);
        }
    }

