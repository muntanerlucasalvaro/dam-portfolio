package es.cide.programacio;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Main {

    // METODO PARA CREAR LAS TABLAS DE LA BASE DE DATOS
    public static void crearBaseDeDatos() {
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:Places.db");// Abrimos conexion con el archivo de la BD
             Statement stmt = con.createStatement()) {// Creamos el statement para ejecutar las queries

            // Creo la tabla de tipos de plaza, es la primera porque ls demas dependen de ella
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS TIPUS_PLACA (" +
                    "NOM VARCHAR2(50) PRIMARY KEY," +
                    "FUNCIO VARCHAR2(200) NOT NULL" +
                    ");");

            // Creo la tabla de plazas, tiene claus foraneas a TIPUS_PLACA y a si misma (supervisora)
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS PLACA (" +
                    "CODI INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "NOM TEXT NOT NULL," +
                    "SALARI REAL NOT NULL," +
                    "INFORME_SUPERVISIO TEXT," +
                    "CODI_PLACA_SUPERVISORA INTEGER," +
                    "NOM_TIPUS_PLACA TEXT NOT NULL," +
                    "FOREIGN KEY (CODI_PLACA_SUPERVISORA) REFERENCES PLACA (CODI)," +
                    "FOREIGN KEY (NOM_TIPUS_PLACA) REFERENCES TIPUS_PLACA (NOM)" +
                    ");");

            // Creo la tabla de empleados (IBAN tiene que empiezar siempre por ES)
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS EMPLEAT (" +
                    "NSS INTEGER PRIMARY KEY," +
                    "NOM TEXT NOT NULL," +
                    "LLINATGES TEXT NOT NULL," +
                    "EMAIL TEXT," +
                    "IBAN TEXT UNIQUE NOT NULL CHECK (IBAN LIKE 'ES%')" +
                    ");");

            // Creo la tabla OCUPA que relaciona empleados con plazas
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS OCUPA (" +
                    "NSS_EMPLEAT INTEGER NOT NULL," +
                    "CODI_PLACA INTEGER NOT NULL," +
                    "DATA_INICI TEXT NOT NULL," +
                    "DATA_FI TEXT," +
                    "PRIMARY KEY (NSS_EMPLEAT, CODI_PLACA)," +
                    "FOREIGN KEY (NSS_EMPLEAT) REFERENCES EMPLEAT (NSS)," +
                    "FOREIGN KEY (CODI_PLACA) REFERENCES PLACA (CODI)" +
                    ");");

            // Creo la tabla de nominas vinculada a empleado y plaza
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS NOMINA (" +
                    "ID_NOMINA INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "IBAN_PAGAMENT TEXT NOT NULL," +
                    "IMPORT REAL NOT NULL," +
                    "NSS_EMPLEAT INTEGER NOT NULL," +
                    "CODI_PLACA INTEGER NOT NULL," +
                    "FOREIGN KEY (NSS_EMPLEAT) REFERENCES EMPLEAT (NSS)," +
                    "FOREIGN KEY (CODI_PLACA) REFERENCES PLACA (CODI)" +
                    ");");

        } catch (SQLException e) {
            // Si algo falla al crear las tablas lo muestro por consola
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // LOOK AND FEEL
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.err.println("No se pudo cargar el Look and Feel: " + e.getMessage());
        }

        // VENTANA
        JFrame finestra = new JFrame("PROU8EX01");// Creo la ventana principal
        finestra.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        finestra.setBackground(Color.BLACK);// Pongo el colorfondo
        finestra.setSize(800, 400);// tamaño
        finestra.setLocationRelativeTo(null);
        finestra.setResizable(false);// No resizable

        // PANTALLA HOME
        PantallaHome pantallaHome = new PantallaHome();// Creo el panel principal
        finestra.add(pantallaHome);// Lo agrego a la ventana
        finestra.setVisible(true);// Hago visible la ventana

        // Creo las taulas de la BD al arrancar el programa
        crearBaseDeDatos();
    }
}