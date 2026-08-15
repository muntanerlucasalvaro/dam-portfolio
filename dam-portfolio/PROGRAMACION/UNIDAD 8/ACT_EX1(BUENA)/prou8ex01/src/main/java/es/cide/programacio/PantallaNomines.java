package es.cide.programacio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PantallaNomines extends JDialog {
    //ATRIBUTS
    private DefaultListModel<String> listaDatos;// Guarda texto para el jlist de nominas
    private JList<String> listaNomines;// Lista visual de nominas
    private ArrayList<Nomina> nomines;// Lista de objetos Nomina en paralelo a la lista visual

    // Campos del formulario de la nomina seleccionada
    private JTextField txtId, txtIban, txtImport, txtCodiPlaca;
    private JButton btnNova, btnGuardar, btnEliminar;

    private final int nssEmpleat;// NSS del empleado propietario de las nominas
    private final Frame pare;// Ventana padre

    //CONSTRUCTOR
    public PantallaNomines(Frame padre, String nomEmpleat, int nss) {
        super(padre, "Nomines - " + nomEmpleat, true);// Llamo al constructor de JDialog
        this.pare = padre;
        this.nssEmpleat = nss;// Guardo el NSS para filtrar las nomins de este empleado

        // CONFIGURACION DEL DIALOGO
        this.setSize(650, 450);
        this.setLocationRelativeTo(padre);
        this.setLayout(new BorderLayout(10, 10));

        // CABECERA (nombre empleado)
        JLabel lblNom = new JLabel(nomEmpleat, SwingConstants.CENTER);
        lblNom.setFont(new Font("Arial", Font.BOLD, 20));
        lblNom.setForeground(Color.WHITE);
        lblNom.setBackground(Color.BLACK);
        lblNom.setOpaque(true);
        lblNom.setBorder(BorderFactory.createEmptyBorder(12, 10, 8, 10));
        this.add(lblNom, BorderLayout.NORTH);

        // LISTA DE NOMINES (parte izquierda)
        listaDatos = new DefaultListModel<>();
        listaNomines = new JList<>(listaDatos);
        listaNomines.setFont(new Font("Arial", Font.PLAIN, 15));
        listaNomines.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Solo se puede seleccionar una a la vez

        JScrollPane scroll = new JScrollPane(listaNomines);
        scroll.setPreferredSize(new Dimension(260, 0));
        scroll.setBorder(BorderFactory.createTitledBorder("Lista de nomines"));
        this.add(scroll, BorderLayout.WEST);

        // FORMULARIO (parte derecha)
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createTitledBorder("Dades de la nomina"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ID (solo lectura porque es autoincrement)
        txtId = new JTextField();
        txtId.setEditable(false);
        gbc.gridx = 0; gbc.gridy = 0;
        panelForm.add(new JLabel("ID Nomina:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        panelForm.add(txtId, gbc);

        // IBAN
        txtIban = new JTextField();
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        panelForm.add(new JLabel("IBAN pagament:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        panelForm.add(txtIban, gbc);

        // IMPORT
        txtImport = new JTextField();
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        panelForm.add(new JLabel("Import (EUR):"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        panelForm.add(txtImport, gbc);

        // CODI PLACA
        txtCodiPlaca = new JTextField();
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0;
        panelForm.add(new JLabel("Codi Placa:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        panelForm.add(txtCodiPlaca, gbc);

        //Filtrode numeros del importe
        txtImport.addKeyListener(new KeyAdapter() {
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

        // BOTONES
        JPanel panelBotons = new JPanel(new GridLayout(1, 3, 8, 0));
        btnNova     = new JButton("Nova (+)");
        btnGuardar  = new JButton("Guardar");
        btnEliminar = new JButton("Eliminar (-)");
        btnGuardar.setEnabled(false);// Desactivados hasta que se seleccione o cree una nomina
        btnEliminar.setEnabled(false);
        panelBotons.add(btnNova);
        panelBotons.add(btnGuardar);
        panelBotons.add(btnEliminar);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.SOUTH; gbc.fill = GridBagConstraints.HORIZONTAL;
        panelForm.add(panelBotons, gbc);

        this.add(panelForm, BorderLayout.CENTER);

        // Cargo las nominas del empleado al abrir
        carregarNomines();

        // CLICK EN LA LISTA
        listaNomines.addListSelectionListener(e -> {//carga los datos de la nomina seleccionada en el formulario
            if (!e.getValueIsAdjusting()) {// Evito que se dispare dos veces durante al darle
                int posicioNomnaSeleccionada = listaNomines.getSelectedIndex();
                if (posicioNomnaSeleccionada != -1) {
                    Nomina n = nomines.get(posicioNomnaSeleccionada);// Obtengo la nomin de la lista de objetos
                    txtId.setText(String.valueOf(n.getIdNomina()));
                    txtIban.setText(n.getIbanPagament());
                    txtImport.setText(String.valueOf(n.getImporte()));
                    txtCodiPlaca.setText(n.getCodiPlaca());
                    btnGuardar.setEnabled(true);// Activo los botones
                    btnEliminar.setEnabled(true);
                }
            }
        });

        // BOTON NOVA
        btnNova.addActionListener(e -> {//limpia el formulario para introducir una nomina nueva
            listaNomines.clearSelection();// Deselecciono la lista
            txtId.setText("");
            txtIban.setText("");
            txtImport.setText("");
            txtCodiPlaca.setText("");
            btnGuardar.setEnabled(true);
            btnEliminar.setEnabled(false);// No se puede eliminar si es nueva
            txtIban.requestFocus();// Pongo el foco en el primer campo
        });

        // BOTON GUARDAR
        btnGuardar.addActionListener(e -> {//INSERT si no  ID, UPDATE si si
        String iban = txtIban.getText().trim();
        String importT = txtImport.getText().trim();
        String placaT = txtCodiPlaca.getText().trim();

        if (iban.isEmpty() || importT.isEmpty() || placaT.isEmpty()) {// Compruebo que los datos obligatorios no esten vacios
            JOptionPane.showMessageDialog(this, "IBAN, import i codi placa son obligatoris.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double importe;
        int codiPlaca;
        try {
            importe = Double.parseDouble(importT);// Convierto el import a double
            codiPlaca = Integer.parseInt(placaT);// Convierto el codi a entero
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Import i codi placa han de ser numerics.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Si hay ID es UPDATE si no INSERT
        String idText = txtId.getText().trim();
        int id;
        if (idText.isEmpty()) {// Si no hay ID
            id = 0;//Nomina nva
        } else {
            id = Integer.parseInt(idText);// Si hay (UPDATE)
        }
        boolean ok = BaseDades.guardarNomina(id, iban, importe, nssEmpleat, codiPlaca);
        if (ok) {
            carregarNomines();// Recargo la lista
            // Limpio los cmpos
            btnGuardar.setEnabled(false);
            btnEliminar.setEnabled(false);
            txtId.setText(""); txtIban.setText(""); txtImport.setText(""); txtCodiPlaca.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Error en desar la nomina.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    });

        // BOTON ELIMINAR
        btnEliminar.addActionListener(e -> {//elimina la nomina seleccionada
            String idText = txtId.getText().trim();
            if (idText.isEmpty()) return;// Si no hay ID no hago nada
            boolean ok = BaseDades.eliminarNomina(Integer.parseInt(idText));
            if (ok) {
                carregarNomines();// Recargo la lista
                // Limpio el formulario
                txtId.setText(""); txtIban.setText(""); txtImport.setText(""); txtCodiPlaca.setText("");
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Error en eliminar la nomina.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    //METODOS
    // METODO CARGAR NOMINAS
    private void carregarNomines() {//consulta la BD y refresca la lista visual
        nomines = BaseDades.obtenirNominesPerEmpleat(nssEmpleat);// Obtengo las nominas del empleado
        listaDatos.clear();// Limpio la lista visual
        for (Nomina n : nomines) {// Recorro las nominas y las agrego a la lista visual
            listaDatos.addElement("#" + n.getIdNomina() + "  " + n.getImporte() + " EUROS");
        }
    }
}