package es.cide.programacio;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import javax.swing.*;

public class Main {
    private static String nomFitxerActual = null;// Variable general para guardar el archivo actual abierto o guardado (est es pra el desar)

    // FUNCION PARA ESCRIBIR EN UN ARCHIVO
    public static void escriureCaracters(String nomFitxer, String frase) {
        FileOutputStream fos = null;// Declaro el FileOutputStream fuera del try para poder cerrarlo en el finally

        try {
            fos = new FileOutputStream(nomFitxer);// Abrimos el fileOutput con el archivo que queramos tratar

            for (int i = 0; i < frase.length(); i++) {// Bucle que recorre los caracteres de la frase
                char c = frase.charAt(i); // Obtenimos el carcter a la posicio i
                fos.write((byte) c); // Convertim el char a byte i lo escribimos.
            }

            System.out.println("Frase escrita correctament al fitxer: " + nomFitxer);

        } catch (IOException e) {// Capturo cualquier excepcion de entradaosalida
            System.out.println("Error en escriure el fitxer: " + nomFitxer);
            e.printStackTrace();

        } finally {
            if (fos != null) {// Cerramos el flux siempre
                try {
                    fos.close();
                    System.out.println("Flux tancat correctament.");
                } catch (IOException e) {
                    System.out.println("Error en tancar el flux.");
                }
            }
        }
    }

    // FUNCION PARA LEER CARACTERES (Devuelve un String)
    public static String llegirCaracters(String nomFitxer) {
        FileInputStream fis = null;
        String text = "";

        try {
            fis = new FileInputStream(nomFitxer);
            int size = fis.available();
            for (int i = 0; i < size; i++) {
                char caracter = (char) fis.read();
                text = text + caracter;
            }
        } catch (IOException e) {
            System.out.println("Error en llegir el fitxer: " + nomFitxer);
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return text; // Devolvemos el resultado para poder usarlo en el JTextArea
    }

    public static void main(String[] args) {

        // LOOK AND FEEL
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.err.println("No se pudo cargar el Look and Feel: " + e.getMessage());
        }
        // VENTANA
        JFrame finestra = new JFrame("PROU7EX02");// Creo la ventana principal en el main
        finestra.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// Ajusto salida
        finestra.setBackground(Color.BLACK);// Ajusto el color
        finestra.setSize(400, 400);// Ajusto el tamaño
        finestra.setResizable(false);// Evito que se pueda alterar el tamaño
        finestra.setLocationRelativeTo(null);// Centro la ventana

        // GRID BAG LAYOUT
        finestra.setLayout(new GridBagLayout());// Ajusto el layout
        GridBagConstraints g = new GridBagConstraints();// Creo las constraints para el layout
        g.weightx = 0.25;//ancho de las columnas
        g.fill = GridBagConstraints.HORIZONTAL;// Hago que los botones se expandan horizontalmente
        g.insets = new Insets(5, 5, 5, 5);

        // CREACION AREA DE ESCRITURA
        JTextArea area = new JTextArea(20, 30);// Creo el area de escritura
        JScrollPane scroll = new JScrollPane(area);// Agrego el area de escritura a un scroll pane para permitir el desplazamiento

        // DECLARAR BOTONES
        JButton nou = new JButton("Nou");
        JButton obrir = new JButton("Obrir");
        JButton desar = new JButton("Desar");
        JButton desarCom = new JButton("Desar com...");


        // BOTON NOU
        g.gridx = 0;// Posiciono el boton en la columna 0
        g.gridy = 0;// Posiciono el boton en la fila 0

        // Agrego un ActionListener al boton Nou para borrar el area de escritura
        nou.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText("");
                nomFitxerActual = null; // Reseteamos la ruta para que sea un documento nuevo
            }
        });
        finestra.add(nou, g);// Agrego el boton a la ventana con las constraints

        // BOTON OBRIR
        g.gridx = 1;// Posiciono el boton en la columna 1
        g.gridy = 0;// Posiciono el boton en la fila 0

        // ACTION LISTENER OBRIR
        obrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(finestra);//este mtodo devuelve un int que indica si se ha aprobado la seleccion o se ha cancelado (0,1,-1)

                if (result == JFileChooser.APPROVE_OPTION) {
                    nomFitxerActual = fileChooser.getSelectedFile().getAbsolutePath();

                    // Llamamos a tu función y lo que devuelva lo ponemos en el área
                    String contingutLlegit = llegirCaracters(nomFitxerActual);
                    area.setText(contingutLlegit);
                }
            }
        });

        finestra.add(obrir, g);// Agrego el boton a la ventana con las constraints

        // BOTON DESAR
        g.gridx = 2;// Posiciono el boton en la columna 2
        g.gridy = 0;// Posiciono el boton en la fila 0

        // ACTION LISENER BOTON DESAR
        desar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nomFitxerActual != null) {
                    // Si ya tenemos un archivo abierto, guardamos directamente
                    escriureCaracters(nomFitxerActual, area.getText());
                } else {
                    // Si es un archivo nuevo.
                    desarCom.doClick();// Simula el click en el boTn "Desar com.
                }
            }
        });

        finestra.add(desar, g);// Agrego el boton a la ventana con las constraints

        // BOTON DESAR COMO
        g.gridx = 3;// Posiciono el boton en la columna 3
        g.gridy = 0;// Posiciono el boton en la fila 0

        //ACTION LISTENER DESAR COMO
        desarCom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(finestra) == JFileChooser.APPROVE_OPTION) {
                    nomFitxerActual = fileChooser.getSelectedFile().getAbsolutePath();// Guardamos la ruta del nuevo archivo seleccionado
                    escriureCaracters(nomFitxerActual, area.getText());// Guardamos el contenido del arrrea en el nuevo archivo seleccionad.
                }
            }
        });

        finestra.add(desarCom, g);// Agrego el botn a la ventana con las constraints

        // COLOCACION DEL AREA DE ESCRITURA
        g.gridx = 0;// Posiciono el area de escritura en la columna 0
        g.gridy = 1;// Posiciono el area de escritura en la fila 1
        g.gridwidth = 4;// Hago que el area de escritura ocupe las 4 columnas
        g.fill = GridBagConstraints.BOTH;// Hago que el area de escritura se expanda tanto horizontal como verticalmente
        g.weightx = 1.0;// Hago que el area de escritura ocupe todo el espacio horizontal disponible
        g.weighty = 1.0;// Hago que el area de escritura ocupe todo el espacio vertical disponible

        finestra.add(scroll, g);

        finestra.setVisible(true);// Hago visible la ventana
    }
}