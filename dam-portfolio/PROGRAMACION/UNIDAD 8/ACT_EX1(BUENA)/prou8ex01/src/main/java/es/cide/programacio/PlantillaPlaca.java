package es.cide.programacio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlantillaPlaca extends JDialog {
    //ATRIBUTS
    private JTextField txtNom, txtSalari, txtInforme, txtSupervisora;// Campos de texto de datos de la plaza
    private JComboBox<String> comboTipus;// ComboBox para seleccionar el tipo de plaza
    private JButton btnEdit, btnSave, btnCT, btnBT;// Botones del dialogo
    private boolean esEditable;// Indica si el formulrio esta en modo edicion o lectura

    private String nomPlacaGuardada = null;// Nombre de la plaza guardada (para devolverlo al combo de PlantillaEmpleado)

    //CONSTRUCTOR
    public PlantillaPlaca(Frame pare, String titol, boolean editable) {
        super(pare, titol, true);// Llamo al constructor de JDialog (vntana padre, titulo, booleano que manda si se edita)
        this.esEditable = editable;

        // CONFIGURACION DEL DIALOGO
        this.setSize(500, 380);
        this.setLocationRelativeTo(pare);// Centro el dialogo respecto al padre
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        // PANEL DE DADES
        JPanel panelDades = new JPanel(new GridBagLayout());
        panelDades.setBorder(BorderFactory.createTitledBorder("DADES DE LA PLACA"));
        GridBagConstraints gbcD = new GridBagConstraints();
        gbcD.insets = new Insets(8, 8, 8, 8);
        gbcD.fill = GridBagConstraints.HORIZONTAL;
        gbcD.anchor = GridBagConstraints.WEST;

        // NOM
        txtNom = new JTextField();
        gbcD.gridx = 0; gbcD.gridy = 0; gbcD.weightx = 0;
        panelDades.add(new JLabel("Nom:"), gbcD);
        gbcD.gridx = 1; gbcD.weightx = 1.0; gbcD.gridwidth = 2;
        panelDades.add(txtNom, gbcD);

        // SALARI
        txtSalari = new JTextField();
        gbcD.gridx = 0; gbcD.gridy = 1; gbcD.weightx = 0; gbcD.gridwidth = 1;
        panelDades.add(new JLabel("Salari (EUR):"), gbcD);
        gbcD.gridx = 1; gbcD.weightx = 1.0; gbcD.gridwidth = 2;
        panelDades.add(txtSalari, gbcD);

        // PLACA SUPERVISORA
        txtSupervisora = new JTextField();
        gbcD.gridx = 0; gbcD.gridy = 2; gbcD.weightx = 0; gbcD.gridwidth = 1;
        panelDades.add(new JLabel("Placa supervisora:"), gbcD);
        gbcD.gridx = 1; gbcD.weightx = 1.0; gbcD.gridwidth = 2;
        panelDades.add(txtSupervisora, gbcD);

        // INFORME
        txtInforme = new JTextField();
        gbcD.gridx = 0; gbcD.gridy = 3; gbcD.weightx = 0; gbcD.gridwidth = 1;
        panelDades.add(new JLabel("Informe supervisio:"), gbcD);
        gbcD.gridx = 1; gbcD.weightx = 1.0; gbcD.gridwidth = 2;
        panelDades.add(txtInforme, gbcD);

        // TIPUS DE PLACA + BOTONS CT i BT
        comboTipus = new JComboBox<>();
        btnCT = new JButton("Crear tipus");
        btnBT = new JButton("Borrar tipus");// Elimina el tipus seleccionado en el combo
        carregarTipusAlCombo();// Cargo los tipos de plaza desde la BD
        gbcD.gridx = 0; gbcD.gridy = 4; gbcD.weightx = 0; gbcD.gridwidth = 1;
        panelDades.add(new JLabel("Tipus de placa:"), gbcD);
        gbcD.gridx = 1; gbcD.weightx = 1.0; gbcD.gridwidth = 2;
        panelDades.add(comboTipus, gbcD);
        gbcD.gridx = 0; gbcD.gridy = 5; gbcD.weightx = 0.5; gbcD.gridwidth = 1;
        panelDades.add(btnCT, gbcD);
        gbcD.gridx = 1; gbcD.weightx = 0.5;
        panelDades.add(btnBT, gbcD);

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 1.0; gbc.weighty = 1.0;
        this.add(panelDades, gbc);

        //FILTRO SALARI (SOLi num y decimal)
        txtSalari.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (c >= '0' && c <= '9') {// Si es un numero lo acepto
            // ok
        } else if (c == '.') {// Si es un punto decimal lo acepto
            // ok
        } else if (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {// Si es borrar lo acepto
            // ok
        } else {
            e.consume();// Si es cualquier otra cosa la ignoro
        }
    }
});

        // BOTON CT
        btnCT.addActionListener(e -> {//abre PlantillaTipusPlaca para crear un tipo de plaza nuevo
            PlantillaTipusPlaca nouTipus = new PlantillaTipusPlaca(pare, "Nou Tipus de Placa", true);
            nouTipus.setVisible(true);
            String nomNou = nouTipus.getNomGuardat();// Obtengo el nombre del tipo guardado
            if (nomNou != null) {// Si se guardo un tipo nuevo lo añado al combo
                carregarTipusAlCombo();
                comboTipus.setSelectedItem(nomNou);
            }
        });

        // BOTON BT
        btnBT.addActionListener(e -> {//elimina el tipus seleccionado en el combo
            String sel = (String) comboTipus.getSelectedItem();
            if (sel == null || sel.startsWith("*")) {// Si no hay tipus seleccionado aviso
                JOptionPane.showMessageDialog(this, "Selecciona un tipus per eliminar-lo.");
                return;
            }
            boolean ok = BaseDades.eliminarTipusPlaca(sel);
            if (ok) {
                carregarTipusAlCombo();// Recargo el combo
            } else {
                JOptionPane.showMessageDialog(this, "Error en eliminar el tipus.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // BOTONES EDIT Y SAVE
        JPanel panelBotons = new JPanel(new GridLayout(1, 2, 10, 0));
        btnEdit = new JButton("EDIT");
        btnSave = new JButton("SAVE");
        panelBotons.add(btnEdit);
        panelBotons.add(btnSave);

        gbc.gridy = 1; gbc.weighty = 0;
        this.add(panelBotons, gbc);

        configurarEdicio(esEditable);// Ajusto el modo edicion inicial

        // ACCION BOTON EDIT
        btnEdit.addActionListener(e -> {
            esEditable = !esEditable;// Cambio el estado
            configurarEdicio(esEditable);
        });

        // ACCION BOTON SAVE
        btnSave.addActionListener(e -> guardarPlaca());
    }

    //METODOS
    // METODO GUARDAR PLAZA
    private void guardarPlaca() {//valida los datos y llama a BaseDades
        String nom = txtNom.getText().trim();//(.trim quita ezpacios)
        String salariT = txtSalari.getText().trim();
        String tipusNom = (String) comboTipus.getSelectedItem();

        if (nom.isEmpty() || salariT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nom i el salari son obligatoris.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (tipusNom == null || tipusNom.startsWith("*")) {// Compruebo que se haya seleccionado un tipo
            JOptionPane.showMessageDialog(this, "Selecciona un tipus de placa.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double salari;
        try {
            salari = Double.parseDouble(salariT);// Convierto el salario a double
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El salari ha de ser un numero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String informe = txtInforme.getText().trim();
        String supText = txtSupervisora.getText().trim();
        Integer codiPlacaSupervisora = null;
        if (!supText.isEmpty()) {// Si hay plaza supervisora intento convertir el codi a entero
            try {
                codiPlacaSupervisora = Integer.parseInt(supText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El codi de placa supervisora ha de ser un numero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        boolean ok = BaseDades.guardarPlaca(nom, salari, informe, codiPlacaSupervisora, tipusNom);
        if (ok) {
            nomPlacaGuardada = nom;// Guardo el nombre para devolverlo al combo de PlantillaEmpleado
            JOptionPane.showMessageDialog(this, "Placa desada correctament.");
            this.dispose();// Cierro el dialogo
        } else {
            JOptionPane.showMessageDialog(this, "Error en desar la placa.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // METODO CARGAR TIPOS
    private void carregarTipusAlCombo() {//carga los tipos de plaza disponibles en el combo desde la BD
        String selActual = (String) comboTipus.getSelectedItem();// Guardo la seleccion actual para no perderla
        comboTipus.removeAllItems();// Limpio el combo
        comboTipus.addItem("* Selecciona tipus *");// Opcion por defecto
        for (String nombreTipo : BaseDades.obtenirNomsTipusPlaca()) {
            comboTipus.addItem(nombreTipo);// Agrego cada tipo al combo
        }
        if (selActual != null) comboTipus.setSelectedItem(selActual);// Restauro la seleccion anterior
    }

    // METODO CONFIGURAR EDICION
    private void configurarEdicio(boolean edit) {//activa o desactiva los campos segun el modo
        txtNom.setEditable(edit && nomPlacaGuardada == null);// El nom no se puede cambiar si la plaza ya existe
        txtSalari.setEditable(edit);
        txtInforme.setEditable(edit);
        txtSupervisora.setEditable(edit);
        comboTipus.setEnabled(edit);
        btnSave.setEnabled(edit);
        btnCT.setEnabled(edit);// Solo se puede crear tipo en modo edicion
        btnBT.setEnabled(edit);// Solo se puede borrar tipo en modo edicion
        }

    //GETTERS Y SETTERS
    //GETTERS
    public String getNomPlacaGuardada() {
        return nomPlacaGuardada;
    }
}