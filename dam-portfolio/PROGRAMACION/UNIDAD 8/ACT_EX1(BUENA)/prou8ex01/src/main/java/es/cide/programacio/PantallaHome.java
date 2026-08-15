package es.cide.programacio;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PantallaHome extends JPanel {
    //ATRIBUTS
    private DefaultListModel<String> listaDatos;//guarda texto para el jlist de lista de empleados
    private JList<String> listaEmpleados;// Lista visual de empleados
    private ArrayList<Empleat> empleats;// Lista de objetos Empleat en paralelo a la lista visual

    //CONSTRUCTOR
    public PantallaHome() {
        // CONFIGURACION DEL PANEL
        this.setLayout(new GridBagLayout());// Ajusto el layout
        this.setBackground(Color.BLACK);// Ajusto el color de fondo

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);// Espaciado entre componentes
        gbc.fill = GridBagConstraints.BOTH;// Los componentes rellenan su celda

        // PARTE IZQUIERDA
        JLabel tituloIzquierda = new JLabel("EMPLEADOS");
        tituloIzquierda.setForeground(Color.WHITE);
        tituloIzquierda.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.weightx = 0.5; gbc.weighty = 0.1;
        this.add(tituloIzquierda, gbc);

        // BOTON AÑADIR
        JButton btnAdd = new JButton("Añadir (+)");
        btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; gbc.weighty = 0.45;
        this.add(btnAdd, gbc);

        // BOTON ELIMINAR
        JButton btnDelete = new JButton("Eliminar (-)");
        btnDelete.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 1; gbc.gridy = 1;
        this.add(btnDelete, gbc);

        // BOTON VER/EDITAR - abre la ficha del empleado seleccionado
        JButton btnVer = new JButton("Ver/Editar");
        btnVer.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.weighty = 0.45;
        this.add(btnVer, gbc);

        // PARTE DERECHA
        JLabel tituloDerecha = new JLabel("INFORMACIÓN");
        tituloDerecha.setForeground(Color.WHITE);
        tituloDerecha.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 2; gbc.gridy = 0; gbc.gridwidth = 1;
        gbc.weightx = 0.5; gbc.weighty = 0.1;
        this.add(tituloDerecha, gbc);

        // LISTA DE EMPLEADOS
        listaDatos = new DefaultListModel<>();
        listaEmpleados = new JList<>(listaDatos);
        listaEmpleados.setFont(new Font("Arial", Font.PLAIN, 18));

        JScrollPane scrollLista = new JScrollPane(listaEmpleados);// Scroll por si hay muchos empleados
        gbc.gridx = 2; gbc.gridy = 1; gbc.gridwidth = 1; gbc.gridy = 1;
        gbc.weighty = 0.9; gbc.gridheight = 2;
        this.add(scrollLista, gbc);

        // Cargo los empleados desde la BD al arrancar
        carregarEmpleats();

        // ACCION BOTON AÑADIR
        btnAdd.addActionListener(e -> {//abre la ficha de nuevo empleado en modo editable
            Frame pare = (Frame) SwingUtilities.windowForComponent(this);// Obtengo la ventana del main para pasarla como padre al popUp
            PlantillaEmpleado popUp = new PlantillaEmpleado(pare, "Nou Empleat", true);// Creo el popUp en modo nuevo empleado (editable)
            popUp.setVisible(true);
            carregarEmpleats();// Recargo la lista por si se guardo algo nuevo
        });

        // ACCION BOTON ELIMINAR
        btnDelete.addActionListener(e -> {//elimina el empleado seleccionado de la lista y la BD
            int posicio = listaEmpleados.getSelectedIndex();// Posicion del empleado seleccionado en la lista visual
            if (posicio == -1) {// Si no hay ninguno seleccionado aviso
                JOptionPane.showMessageDialog(this, "Selecciona un empleat de la llista.");
                return;
            }
            Empleat seleccionat = empleats.get(posicio);// Obtengo el empleado de la lista de objetos
            boolean ok = BaseDades.eliminarEmpleat(seleccionat.getNss());
            if (!ok) {
                JOptionPane.showMessageDialog(this, "Error en eliminar l'empleat.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            carregarEmpleats();// Recargo la lista
        });

        // ACCION BOTON VER/EDITAR
        btnVer.addActionListener(e -> {//abre la ficha del empleado seleccionado en modo lectura
            int posicio = listaEmpleados.getSelectedIndex();
            if (posicio == -1) {// Si no hay ninguno seleccionado aviso
                JOptionPane.showMessageDialog(this, "Selecciona un empleat de la llista.");
                return;
            }
            Empleat seleccionat = empleats.get(posicio);
            Frame pare = (Frame) SwingUtilities.windowForComponent(this);// Obtengo la ventana del main para pasarla como padre al popUp
            PlantillaEmpleado popUp = new PlantillaEmpleado(pare, "Ficha Empleat", false);
            popUp.carregarDadesEmpleado(seleccionat);// Cargo los datos del empleado en la ficha
            popUp.setVisible(true);
            carregarEmpleats();// Recargo por si se edito algo
        });
    }
    //METODOS
    // METODO CARGAR EMPLEADOS
    private void carregarEmpleats() {//consulta la BD y refresca la lista visual
        empleats = BaseDades.obtenirEmpleats();// Obtengo todos los empleados de la BD
        listaDatos.clear();// Limpio la lista visual
        for (Empleat empleat : empleats) {// Recorro los empleados y los agregoal jlist a traves de la lista de texto
            listaDatos.addElement(empleat.getNom() + " " + empleat.getLlinatges());//nombre y apelldo x empleado
        }
    }
}