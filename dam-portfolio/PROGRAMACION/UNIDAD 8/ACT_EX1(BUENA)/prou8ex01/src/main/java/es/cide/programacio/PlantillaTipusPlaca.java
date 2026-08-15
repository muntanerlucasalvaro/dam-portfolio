package es.cide.programacio;

import javax.swing.*;
import java.awt.*;

public class PlantillaTipusPlaca extends JDialog {
    //ATRIBUTS
    private JTextField txtNom, txtFuncio;// Campos de texto de datos del tipo de plaza
    private JButton btnEdit, btnSave;// Botones del dialogo
    private boolean esEditable;// Indica si el formulario esta en modo edicion o lectura

    private String nomGuardat = null;// Nombre del tipo guardado (para devolverlo al combo de PlantillaPlaca)

    //CONSTRUCTOR
    public PlantillaTipusPlaca(Frame pare, String titol, boolean editable) {
        super(pare, titol, true);// Llamo al constructor de JDialog (ventana padre, titulo, modal)
        this.esEditable = editable;

        // CONFIGURACION DEL DIALOG
        this.setSize(400, 260);
        this.setLocationRelativeTo(pare);// Centro el dialogo respecto al padre
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        // PANEL DE DADES
        JPanel panelDades = new JPanel(new GridLayout(2, 2, 10, 20));
        panelDades.setBorder(BorderFactory.createTitledBorder("DADES DEL TIPUS DE PLACA"));

        // NOM
        txtNom = new JTextField();
        panelDades.add(new JLabel("Nom:"));
        panelDades.add(txtNom);

        // FUNCIO
        txtFuncio = new JTextField();
        panelDades.add(new JLabel("Funcio:"));
        panelDades.add(txtFuncio);

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 1.0; gbc.weighty = 1.0;
        this.add(panelDades, gbc);

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
        btnSave.addActionListener(e -> guardar());
    }

    //METODOS
    // METODO GUARDAR TIPUS PLACA
    private void guardar() {//valida los datos y llama a BaseDades
        String nom = txtNom.getText().trim();
        String funcio = txtFuncio.getText().trim();

        if (nom.isEmpty() || funcio.isEmpty()) {// Compruebo que los datos no esten vacios
            JOptionPane.showMessageDialog(this, "El nom i la funcio son obligatoris.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean ok = BaseDades.guardarTipusPlaca(nom, funcio);
        if (ok) {
            nomGuardat = nom;// Guardo el nombre para devolverlo al combo de PlantillaPlaca
            JOptionPane.showMessageDialog(this, "Tipus de placa desat correctament.");
            this.dispose();// Cierro el dialogo
        } else {
            JOptionPane.showMessageDialog(this, "Error en desar el tipus de placa.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // METODO CONFIGURAR EDICION
    private void configurarEdicio(boolean edit) {//activa o desactiva los campos segun el modo
        txtNom.setEditable(edit && nomGuardat == null);// El nom es la PK, no se puede cambiar si ya existe
        txtFuncio.setEditable(edit);
        btnSave.setEnabled(edit);
    }

    //GETTERS Y SETTERS
    //GETTERS
    public String getNomGuardat() {
        return nomGuardat;
    }
}