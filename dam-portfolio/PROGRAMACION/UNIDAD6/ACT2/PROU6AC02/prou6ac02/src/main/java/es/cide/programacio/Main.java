package es.cide.programacio;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //Pas 1: El Contenidor Principal (JFrame)
        JFrame ServerAdminPanel = new JFrame("Tauler d'Administració - [Álvaro Muntaner Lucas]");//Creamos una clase ServerADminPanel que herede el JFrame.
        ServerAdminPanel.setSize(800,600);//Ajustamos el tamaño a 800x600
        ServerAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Tancament lo ponemos por defecto
        ServerAdminPanel.setLocationRelativeTo(null);//Y lo centramos
        ServerAdminPanel.setVisible(true);//Hacemos la ventana visible,

        //Pas 2: Construcció dels 4 Panells

        //A. Panell d'Estat (Nord-Oest):
        JPanel a = new JPanel();//Creamos el primer panel.
        TitledBorder borderABorder = BorderFactory.createTitledBorder("Estat del Sistema");//Hacemos un Titleborder para ponerle el titulo.
        a.setBorder(borderABorder);//Asignamos el titleborder al primer panel.
        a.setLayout(new GridLayout(2, 3));//Hacemos el grid de 2x1,
        JLabel etiquetaA1 = new JLabel( "CPU: 15% Ús");//Generamos la primera etiqueta.
        a.add(etiquetaA1);//Y la añadimos.
        JLabel etiquetaA2 = new JLabel( "RAM: 4GB / 16GB");//Generamos la segunda etiqueta.
        a.add(etiquetaA2);//Y la añadimos.
        a.setVisible(true);//Hacemos el panel visible,


        //B. Panell de Control (Nord-Est):
        JPanel b = new JPanel();//Creamos el segundo panel.
        TitledBorder borderBBorder = BorderFactory.createTitledBorder("Accions Ràpides");//Hacemos un Titleborder para ponerle el titulo.
        b.setBorder(borderBBorder);//Asignamos el titleborder al primer panel.
        b.setLayout(new GridLayout(3, 1,0,10));//Hacemos el grid de 3x1 y ponemos el vGap en 10.
        JButton ba = new JButton("▶ Iniciar Servei");//Creamos el primer boton.
        JButton bb = new JButton("■ Aturar Servei");//Creamos el segundo boton.
        JButton bc = new JButton("↻ Reiniciar");//Creamos el tercer boton.
        b.add(ba);
        b.add(bc);
        b.add(bb);
        b.setVisible(true);//Hacemos el panel visible,

        //C. Panell de Configuració (Sud-Oest) - ATENCIÓ AQUÍ:
        JPanel c = new JPanel();//Creamos el tercero panel.
        TitledBorder borderCBorder = BorderFactory.createTitledBorder("Paràmetres de Càrrega");//Hacemos un Titleborder para ponerle el titulo.
        c.setBorder(borderCBorder);//Asignamos el titleborder al primer panel.
        c.setLayout(new GridLayout(4, 1));//Hacemos el grid de 4x1,
        JLabel etiquetaC1 = new JLabel( "Límit de Connexions (0-500):");//Generamos la primera etiqueta.
        c.add(etiquetaC1);//Y la añadimos.
        JSlider sliderC = new JSlider(0,500,250);//Creamos un slider con valor minimo 0, valor maximo 500 y valor inicial 250
        sliderC.setMajorTickSpacing(100);//Ticks grandes
        sliderC.setMinorTickSpacing(25);  // ticks pequeños;
        sliderC.setPaintTicks(true);
        sliderC.setPaintLabels(true);
        c.add(sliderC);//Y la añadimos.
        JLabel etiquetaC2 = new JLabel( "Timeout (segons):");//Generamos la segunda etiqueta.
        c.add(etiquetaC2);//Y la añadimos.
        JTextField textFieldC1 = new JTextField("60");//Creo el primer textfield.
        c.add(textFieldC1);//Y lo añado
        c.setVisible(true);//Hacemos el panel visible,

        //D. Panell de Registres (Sud-Est) - LA PART MÉS TÈCNICA:
        JPanel d = new JPanel();//Creamos el cuarto panel.
        TitledBorder borderDBorder = BorderFactory.createTitledBorder("Logs del Servidor en Viu");//Hacemos un Titleborder para ponerle el titulo.
        d.setBorder(borderDBorder);//Asignamos el titleborder al primer panel.
        d.setLayout(new BorderLayout());//Añadimos un border layout (imprescindible)
        JTextArea textAreaD1 = new JTextArea("[Info] Servei iniciat... \\n" + " [Warning] Connexió lenta IP 192... \\n" + " ...");
        textAreaD1.setEditable(false);
        textAreaD1.setFont(new Font(null));
        d.setVisible(true);//Hacemos el panel visible,
        //J
        ServerAdminPanel.add(a);
        ServerAdminPanel.add(b);
        ServerAdminPanel.add(c);
        ServerAdminPanel.setVisible(true);//Hacemos la ventana visible,

    }
}