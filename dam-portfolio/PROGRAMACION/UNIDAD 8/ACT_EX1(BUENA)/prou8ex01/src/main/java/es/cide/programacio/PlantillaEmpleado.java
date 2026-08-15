
package es.cide.programacio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlantillaEmpleado extends JDialog {
    //ATRIBUTS
    private JTextField txtNss, txtNombre, txtApellidos, txtEmail, txtIban;// Campos de texto de datos personales
    private JComboBox<String> comboPlaca;// ComboBox para seleccionar la plaza del empleado
    private JTextField txtFuncion;// Campo de texto para mostrar la funcion de la plaza (es txtfield porqie no me gusta como se ve el lbel)
    private JButton btnEdit, btnSave, btnCP, btnNomines, btnBP;// Botones del dialogo
    private boolean esEditable;// Indica si el formulario esta en modo edicion o lectura
    private int nssActual = 0;// NSS del empleado cargado (0 si es nuevo)

    //CONSTRUCTOR
    public PlantillaEmpleado(Frame padre, String titulo, boolean editable) {
        super(padre, titulo, true);// Llamo al constructor de JDialog (vntana padre, titulo, booleano que manda si se edita)
        this.esEditable = editable;

        // CONFIGURACION DEL DIALOGO
        this.setSize(800, 500);
        this.setLocationRelativeTo(padre);// Centro el dialogo respecto al padre
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        // SECCION IZQUIERDA - DATOS PERSONALES
        JPanel panelIzquierdo = new JPanel(new GridLayout(5, 2, 10, 20));
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("DATOS PERSONALES"));

        // NSS
        txtNss = new JTextField();
        panelIzquierdo.add(new JLabel("Empleado (NSS):"));
        panelIzquierdo.add(txtNss);

        // NOMBRE
        txtNombre = new JTextField();
        panelIzquierdo.add(new JLabel("Nombre:"));
        panelIzquierdo.add(txtNombre);

        // APELLIDOS
        txtApellidos = new JTextField();
        panelIzquierdo.add(new JLabel("Apellidos:"));
        panelIzquierdo.add(txtApellidos);

        // EMAIL
        txtEmail = new JTextField();
        panelIzquierdo.add(new JLabel("Correo electronico:"));
        panelIzquierdo.add(txtEmail);

        // IBAN
        txtIban = new JTextField();
        panelIzquierdo.add(new JLabel("IBAN:"));
        panelIzquierdo.add(txtIban);

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.66; gbc.weighty = 1.0;
        this.add(panelIzquierdo, gbc);

        // SECCION DERECHA
        JPanel panelDerecho = new JPanel(new GridLayout(3, 1, 0, 10));// 3 fulas 1 columna

        // OCUPACION
        JPanel panelOcupacion = new JPanel(new GridBagLayout());
        panelOcupacion.setBorder(BorderFactory.createTitledBorder(null, "OCUPACION", 2, 0, new Font("Arial", Font.BOLD, 14)));
        GridBagConstraints gbcOcupacio = new GridBagConstraints();
        gbcOcupacio.insets = new Insets(5, 5, 5, 5);
        gbcOcupacio.fill = GridBagConstraints.HORIZONTAL;

        comboPlaca = new JComboBox<>();
        carregarPlacesAlCombo();// Cargo las plazas disponibles desde la BD
        txtFuncion = new JTextField();
        txtFuncion.setEditable(false);
        btnCP = new JButton("Crear plaça");
        btnBP = new JButton("Borrar plaça");

        gbcOcupacio.gridx = 0; gbcOcupacio.gridy = 0; gbcOcupacio.weightx = 0;
        panelOcupacion.add(new JLabel("Placa:"), gbcOcupacio);
        gbcOcupacio.gridx = 1; gbcOcupacio.weightx = 1.0; gbcOcupacio.gridwidth = 2;
        panelOcupacion.add(comboPlaca, gbcOcupacio);
        gbcOcupacio.gridx = 0; gbcOcupacio.gridy = 1; gbcOcupacio.gridwidth = 1; gbcOcupacio.weightx = 0.5;
        panelOcupacion.add(btnCP, gbcOcupacio);
        gbcOcupacio.gridx = 1;
        panelOcupacion.add(btnBP, gbcOcupacio);
        gbcOcupacio.gridx = 0; gbcOcupacio.gridy = 2; gbcOcupacio.gridwidth = 1; gbcOcupacio.weightx = 0;
        panelOcupacion.add(new JLabel("Funcio:"), gbcOcupacio);
        gbcOcupacio.gridx = 1; gbcOcupacio.gridwidth = 2; gbcOcupacio.weightx = 1.0;
        panelOcupacion.add(txtFuncion, gbcOcupacio);

        //ACCION COMBO PLAZA
        comboPlaca.addActionListener(e -> {// Al seleccionar una plaza del combo autocompleta el campo funcio (consulta BD)
            String sel = (String) comboPlaca.getSelectedItem();
            if (sel == null || sel.startsWith("*")) {//puse * poeque se rallaba con los sin plaza
                txtFuncion.setText("");// Si no hay plaza seleccionada limpio el campo
            } else {
                txtFuncion.setText(BaseDades.obtenirFuncioPerNomPlaca(sel));// Busco la funcio en la BD
            }
        });

        // BOTON CP 
        btnCP.addActionListener(e -> {//abre PlantillaPlaca para crear una plaza nueva
            PlantillaPlaca novaPlaca = new PlantillaPlaca(padre, "Nova Placa", true);
            novaPlaca.setVisible(true);
            String nomNova = novaPlaca.getNomPlacaGuardada();// Obtengo el nombre de la plaza guardada
            if (nomNova != null) {// Si se guardo una plaza nueva la añado al combo
                carregarPlacesAlCombo();
                comboPlaca.setSelectedItem(nomNova);
            }
        });

        // BOTON BP
        btnBP.addActionListener(e -> {//elimina la plaza seleccionada en el combo
            String sel = (String) comboPlaca.getSelectedItem();
            if (sel == null || sel.startsWith("*")) {// Si no hay plaza seleccionada aviso
                JOptionPane.showMessageDialog(this, "Selecciona una placa per eliminar-la.");
                return;
            }
            boolean ok = BaseDades.eliminarPlaca(sel);
            if (ok) {
                carregarPlacesAlCombo();// Recargo el combo
                txtFuncion.setText("");// Limpio el campo funcio
            } else {
                JOptionPane.showMessageDialog(this, "Error en eliminar la placa.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // NOMINA
        JPanel panelNomina = new JPanel(new BorderLayout(5, 5));
        panelNomina.setBorder(BorderFactory.createTitledBorder(null, "NOMINA", 2, 0, new Font("Arial", Font.BOLD, 14)));

        // Boton para abrir la gestion de nominas del empleado
        btnNomines = new JButton("Gestionar Nomines");
        btnNomines.setFont(new Font("Arial", Font.BOLD, 16));

        //ACCION BOTON NOMINES
        btnNomines.addActionListener(e -> {
            if (nssActual == 0) {// Si el empleado no esta guardado todavia aviso
                JOptionPane.showMessageDialog(this, "Desa primer l'empleat per gestionar les nomines.");//Obligatorio porque es una calu foana
                return;
            }
            PantallaNomines pant = new PantallaNomines(padre, txtNombre.getText().trim(), nssActual);
            pant.setVisible(true);
        });
        panelNomina.add(btnNomines, BorderLayout.CENTER);

        // BOTONES EDIT Y SAVE
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 5, 5));
        btnEdit = new JButton("EDIT");
        btnSave = new JButton("SAVE");
        panelBotones.add(btnEdit);
        panelBotones.add(btnSave);

        //Añado las 3 secciones a la parte derecha
        panelDerecho.add(panelOcupacion);
        panelDerecho.add(panelNomina);
        panelDerecho.add(panelBotones);

        gbc.gridx = 1; gbc.weightx = 0.33;//(1/3)
        this.add(panelDerecho, gbc);

        configurarEdicion(esEditable);// Ajusto el modo edicion inicial

        // ACCION BOTON EDIT 
        btnEdit.addActionListener(e -> {
            esEditable = !esEditable;// Cambio el estado
            configurarEdicion(esEditable);
        });

        // ACCION BOTON SAVE
        btnSave.addActionListener(e -> guardarEmpleat());
    }

    //METODOS
    // METODO GUARDAR EMPLEADO
    private void guardarEmpleat() {//valida los datos y llama a BaseDades
        String nssText = txtNss.getText().trim();//(.trim quita ezpacios)
        if (nssText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El NSS es obligatori.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int nss;
        try {
            nss = Integer.parseInt(nssText);//convertir el NSS a entero
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El NSS ha de ser un numero enter.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nom = txtNombre.getText().trim();
        String llinatges = txtApellidos.getText().trim();
        String iban = txtIban.getText().trim();
        if (nom.isEmpty() || llinatges.isEmpty() || iban.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nom, llinatges i IBAN son obligatoris.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!iban.startsWith("ES")) {// Compruebo que el IBAN empiece por ES
            JOptionPane.showMessageDialog(this, "L'IBAN ha de comenar per 'ES'.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String email    = txtEmail.getText().trim();
        String nomPlaca = (String) comboPlaca.getSelectedItem();// Obtengo la plaza seleccionada en string
        if (nomPlaca != null && nomPlaca.startsWith("*")) nomPlaca = null;// Si no hay plaza seleccionada lo pongo a null

        boolean seGuarda = BaseDades.guardarEmpleat(nss, nom, llinatges, email, iban, nomPlaca);
        if (seGuarda) {
            nssActual = nss;// Guardo el NSS para poder abrir nominas despues
            JOptionPane.showMessageDialog(this, "Empleat desat correctament.");
            configurarEdicion(false);// Vuelvo a modo lectura
        } else {
            JOptionPane.showMessageDialog(this, "Error en desar. Comprova les dades.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // METODO CARGAR DATOS 
    public void carregarDadesEmpleado(Empleat empleaoElegido) {//carga los datos de un empleado existente en los campos
        int nss = empleaoElegido.getNss();// Obtengo el NSS del empleado
        nssActual = nss;// Lo guardo para poder usarlo luego (en nominas)
        txtNss.setText(String.valueOf(nss));// Lo convierto a String y lo meto en el campo
        txtNombre.setText(empleaoElegido.getNom());
        txtApellidos.setText(empleaoElegido.getLlinatges());
        txtEmail.setText(empleaoElegido.getEmail());
        txtIban.setText(empleaoElegido.getIban());
        if (empleaoElegido.getPlazaNom() != null) {// Si el empleado tiene plaza la selecciono en el combo
            comboPlaca.setSelectedItem(empleaoElegido.getPlazaNom());
    }
}

    // METODO CARGAR PLAZAS
    private void carregarPlacesAlCombo() {//carga las plazas disponibles en el combo desde la BD
        String selActual = (String) comboPlaca.getSelectedItem();// Guardo la seleccion actual para no perderla
        comboPlaca.removeAllItems();// Limpio el combo
        comboPlaca.addItem("*NO te plaça*");// Opcion por defecto
        for (String nomPlaza : BaseDades.obtenirNomsPlaca()) {
            comboPlaca.addItem(nomPlaza);// Agrego cada plaza al combo
        }
        if (selActual != null) comboPlaca.setSelectedItem(selActual);// Restauro la seleccion anterior
    }

    // METODO CONFIGURAR EDICION
    private void configurarEdicion(boolean edit) {//activa o desactiva los campos segun el mod
        if (edit && nssActual == 0) {// Si es modo edicion y el empleado es nuevo
        txtNss.setEditable(true);
        } 
        else {// Si el empleado ya existe el NSS no se puede cambiar
        txtNss.setEditable(false);
        }
        txtNombre.setEditable(edit);
        txtApellidos.setEditable(edit);
        txtEmail.setEditable(edit);
        txtIban.setEditable(edit);
        comboPlaca.setEnabled(edit);
        btnSave.setEnabled(edit);
        btnCP.setEnabled(edit);// Solo se puede crear plaza en modo edicion
        btnBP.setEnabled(edit);// Solo se puede borrar plaza en modo edicion
    }
}