package es.cide.programacio;

import java.sql.*;
import java.util.*;

public class BaseDades {

    // Ruta de la base de datos, siempre la misma
    private static final String URL = "jdbc:sqlite:Places.db";

    // TIPUS_PLACA
    // METODO OBTENIR NOMS TIPUS PLACA
    public static ArrayList<String> obtenirNomsTipusPlaca() {// Devuelve una lista con los nombres de todos los tipos de plaza
        ArrayList<String> noms = new ArrayList<>();//INstancio la lista que voy a devolver
        String sql = "SELECT NOM FROM TIPUS_PLACA ORDER BY NOM";
        try (Connection conexion = DriverManager.getConnection(URL);// Abro la conexion con la BD
             Statement stmt = conexion.createStatement();// Creo el statement para ejecutar la query
             ResultSet rs = stmt.executeQuery(sql)) {// Ejecuto la query y obtengo el resultado
            while (rs.next()) {// Recorro los resultados y los agrego a la lista
                noms.add(rs.getString("NOM"));//Agrgo el nombre a nom
            }
        } catch (SQLException e) {
            System.err.println("Error obtenirNomsTipusPlaca: " + e.getMessage());
        }
        return noms;
    }

    //METODO OBTENER FUNCION DE UNA PLACA POR SU NOMBRE
    public static String obtenirFuncioPerNomPlaca(String nomPlaca) {//Con el nom de una plaça busca la funcio de su tipus asociado haciendo un JOIN
        String sql = "SELECT TP.FUNCIO FROM PLACA P JOIN TIPUS_PLACA TP ON P.NOM_TIPUS_PLACA = TP.NOM WHERE P.NOM = ?";
        try (Connection conexion = DriverManager.getConnection(URL);// Abro la conexion con la BD
             PreparedStatement pStmt = conexion.prepareStatement(sql)) {// Creo el PreparedStatement (ejecutar la query con parametro)
            pStmt.setString(1, nomPlaca);// cambia el ? por el nombre de la placa
            try (ResultSet rs = pStmt.executeQuery()) {
                if (rs.next()) return rs.getString("FUNCIO");//Devulve el string de la columna funcio
            }
        } catch (SQLException e) {
            System.err.println("Error obtenirFuncioPerNomPlaca: " + e.getMessage());
        }
        return "";// Si no encuentra nada
    }

    //METODO GUARDAR TIPUS PLACA (ACRUALOZA O INSERTA)
    public static boolean guardarTipusPlaca(String nom, String funcio) {// Guarda un tipus de placa si ya existe lo actualiza y si no inserta
        if (nom == null || nom.isBlank() || funcio == null || funcio.isBlank()) return false;// Compruebo que los datos no esten vacios
        try (Connection conexion = DriverManager.getConnection(URL)) {// Abro la conexion con la BD
            
            boolean exists = false;// Variable para comprobar si existe
            try (PreparedStatement stmntComprobar = conexion.prepareStatement("SELECT COUNT(*) FROM TIPUS_PLACA WHERE NOM = ?")) {
                stmntComprobar.setString(1, nom);// Cambio el ? por el nombre del tipo de placa
                try (ResultSet rs = stmntComprobar.executeQuery()) {// Ejecutamos consulta
                    exists = rs.next() && rs.getInt(1) > 0;//Si el numero del count (coincide con el were) es + q 0 existe
                }
            }
            if (exists) {
                // Si existe UPDATE
                try (PreparedStatement pstmt = conexion.prepareStatement("UPDATE TIPUS_PLACA SET FUNCIO = ? WHERE NOM = ?")) {
                    pstmt.setString(1, funcio);
                    pstmt.setString(2, nom);
                    pstmt.executeUpdate();
                }
            } else {
                // Si no existe INSERT
                try (PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO TIPUS_PLACA (NOM, FUNCIO) VALUES (?, ?)")) {
                    pstmt.setString(1, nom);
                    pstmt.setString(2, funcio);
                    pstmt.executeUpdate();
                }
            }
            return true;
        } catch (SQLException e) {
            System.err.println("Error guardarTipusPlaca: " + e.getMessage());
            return false;
        }
    }

    //METODO ELIMINAR TIPUS PLACA POR NOMBRE
    public static boolean eliminarTipusPlaca(String nom) {// Elimina un tipus de placa por su nom
        try (Connection conexion = DriverManager.getConnection(URL);// Abro la conexion con la BD
             PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM TIPUS_PLACA WHERE NOM = ?")) {
            pstmt.setString(1, nom);// Cambio el ? por el nombre del tipo de placa q hay que borrar
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error eliminarTipusPlaca: " + e.getMessage());
            return false;
        }
    }

    // PLACA
    //METODO OBTENER NOMBRES DE PLAZA
    public static ArrayList<String> obtenirNomsPlaca() {// Devuelve una lista con los nombres de todas las plazas
        ArrayList<String> noms = new ArrayList<>();// Instancio la lista que voy a devolver
        String sql = "SELECT NOM FROM PLACA ORDER BY NOM";
        try (Connection conexion = DriverManager.getConnection(URL);// Abro la conexion con la BD
             Statement stmt = conexion.createStatement();// Creo el statement para ejecutar la query
             ResultSet rs = stmt.executeQuery(sql)) {// Ejecuto la query y obtengo el resultado
            while (rs.next()) {//Mientras haya resultados
                noms.add(rs.getString("NOM"));//guardo en la lista el string de lacolumna nom
            }
        } catch (SQLException e) {
            System.err.println("Error obtenirNomsPlaca: " + e.getMessage());
        }
        return noms;
    }

    //METODO OBTENER CODI DE PLAZA POR NOMBRE
    public static int obtenirCodiPlacaPerNom(String nom) {// Devuelve el codi de una placa por su nom (-1 si no existe)
        try (Connection conexion = DriverManager.getConnection(URL);// Abro la conexion con la BD
             PreparedStatement pstmt = conexion.prepareStatement("SELECT CODI FROM PLACA WHERE NOM = ?")) {
            pstmt.setString(1, nom);// Cambio el ? por el nombre de la placa
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return rs.getInt("CODI");// Devuelve el int de la columna codi si hay
            }
        } catch (SQLException e) {
            System.err.println("Error obtenirCodiPlacaPerNom: " + e.getMessage());
        }
        return -1;// Si no la encuentra devuelvo -1
    }

    //METODO GUARDAR PLAZA
    public static boolean guardarPlaca(String nom, double salari, String informe, Integer codiSupervisora, String nomTipus) {//Guarda plaza (Update o Insert) y codiSupervisora puede ser null si no tiene supervisora
        if (nom == null || nom.isBlank() || nomTipus == null || nomTipus.isBlank()) return false;//Comprobador de los datos obligatiroos
        try (Connection conexion = DriverManager.getConnection(URL)) {// Abro la conexion con la BD
            boolean exists = false;// Variable para comprobar si existe
            int codiExistent = -1;// Variable para guardar el codi si existe
            try (PreparedStatement pCheck = conexion.prepareStatement("SELECT CODI FROM PLACA WHERE NOM = ?")) {
                pCheck.setString(1, nom);// Cambio el ? por el nombre de la placa
                try (ResultSet rs = pCheck.executeQuery()) {// Ejecuto consulta
                    if (rs.next()) {
                        exists = true;
                        codiExistent = rs.getInt("CODI");
                    }
                }
            }
            if (exists) {
                // UPDATE si la placa ya existe
                try (PreparedStatement pstmt = conexion.prepareStatement("UPDATE PLACA SET SALARI = ?, INFORME_SUPERVISIO = ?, CODI_PLACA_SUPERVISORA = ?, NOM_TIPUS_PLACA = ? WHERE CODI = ?")) {
                    pstmt.setDouble(1, salari);
                    pstmt.setString(2, informe);
                    if (codiSupervisora != null && codiSupervisora > 0) {// Si hay supervisora
                        pstmt.setInt(3, codiSupervisora);
                    } else {// Si no hay supervisora 
                        pstmt.setNull(3, Types.INTEGER);// Si no hay supervisora pongo null
                    }
                    pstmt.setString(4, nomTipus);
                    pstmt.setInt(5, codiExistent);
                    pstmt.executeUpdate();
                }
            } else {
                // INSERT si la placa es nueva
                try (PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO PLACA (NOM, SALARI, INFORME_SUPERVISIO, CODI_PLACA_SUPERVISORA, NOM_TIPUS_PLACA) VALUES (?, ?, ?, ?, ?)")) {
                    pstmt.setString(1, nom);
                    pstmt.setDouble(2, salari);
                    pstmt.setString(3, informe);
                    if (codiSupervisora != null && codiSupervisora > 0) {// Si hay supervisora
                        pstmt.setInt(4, codiSupervisora);
                    } else {// Si no hay supervisora
                        pstmt.setNull(4, Types.INTEGER);// Si no hay supervisora pongo null
                    }
                    pstmt.setString(5, nomTipus);
                    pstmt.executeUpdate();
                }
            }
            return true;
        } catch (SQLException e) {
            System.err.println("Error guardarPlaca: " + e.getMessage());
            return false;
        }
    }

    //METODO ELIMINAR PLAZA POR NOMBRE
    public static boolean eliminarPlaca(String nom) {// Elimina una placa por su nom
        int codi = obtenirCodiPlacaPerNom(nom);// Primero obtengo el codi de la placa para eliminarla por codi (por FK)
        if (codi == -1) return false;// Si no existe no hay nada que eliminar
        try (Connection conexion = DriverManager.getConnection(URL);// Abro la conexion con la BD
             PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM PLACA WHERE CODI = ?")) { 
            pstmt.setInt(1, codi);// Cambio el ? por el codi de la placa
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error eliminarPlaca: " + e.getMessage());
            return false;
        }
    }

    // EMPLEAT
    //METODO OBTENER EMPLEADOS
    public static ArrayList<Empleat> obtenirEmpleats() {// Devuelve todos los empleados haciendo JOIN con OCUPA y PLACA para obtener el nombre de la plaza que ocupa cadan
        ArrayList<Empleat> llista = new ArrayList<>();//Instancio la lista que voy a devolver (lista de objetos Empleat)
        String sql = "SELECT EMPLEAT.NSS, EMPLEAT.NOM AS NOM, LLINATGES, EMAIL, IBAN, " +
                     "PLACA.NOM AS PLAZA_NOM " +
                     "FROM EMPLEAT " +
                     "LEFT JOIN OCUPA ON EMPLEAT.NSS = OCUPA.NSS_EMPLEAT " +
                     "LEFT JOIN PLACA ON OCUPA.CODI_PLACA = PLACA.CODI";
        try (Connection conexion = DriverManager.getConnection(URL);// Abro la conexion con la BD
             Statement stmt = conexion.createStatement();// Creo el statement para ejecutar la query
             ResultSet rs = stmt.executeQuery(sql)) {// Ejecuto la query y obtengo el resultado
            while (rs.next()) {// Recorro los resultados y creo un objeto Empleat por cada fila
                llista.add(new Empleat(
                        rs.getInt("NSS"),
                        rs.getString("NOM"),
                        rs.getString("LLINATGES"),
                        rs.getString("EMAIL"),
                        rs.getString("IBAN"),
                        rs.getString("PLAZA_NOM")));
            }
        } catch (SQLException e) {
            System.err.println("Error obtenirEmpleats: " + e.getMessage());
        }
        return llista;
    }

    //METODO GUARDAR EMPLEADO (INSERT O UPDATE) + ASIGNAR PLAZA EN OCUPA
    public static boolean guardarEmpleat(int nss, String nom, String llinatges, String email, String iban, String nomPlaca) { // Guarda un empleat (si NSS ya existe UPDATE y si no INSERT) + la tabla OCUPA para asignarle la placa
        if (nom == null || nom.isBlank() || llinatges == null || llinatges.isBlank() || iban == null || iban.isBlank()) return false;// Comprobador de los datos obligatiroos
        try (Connection conexion = DriverManager.getConnection(URL)) {// Abro la conexion con la BD
            boolean exists = false;// Variable para comprobar si existe
            try (PreparedStatement pCheck = conexion.prepareStatement("SELECT NSS FROM EMPLEAT WHERE NSS = ?")) {
                pCheck.setInt(1, nss);// Cambio el ? por el NSS del empleado
                try (ResultSet rs = pCheck.executeQuery()) {
                    exists = rs.next();// Si hay resultado existey si no no
                }
            }
            if (exists) {
                // UPDATE si el empleat ya existe
                try (PreparedStatement pstmt = conexion.prepareStatement(
                        "UPDATE EMPLEAT SET NOM = ?, LLINATGES = ?, EMAIL = ?, IBAN = ? WHERE NSS = ?")) {
                    pstmt.setString(1, nom);
                    pstmt.setString(2, llinatges);
                    pstmt.setString(3, email);
                    pstmt.setString(4, iban);
                    pstmt.setInt(5, nss);
                    pstmt.executeUpdate();
                }
            } else {
                // INSERT si el empleat es nuevo
                try (PreparedStatement pstmt = conexion.prepareStatement(
                        "INSERT INTO EMPLEAT (NSS, NOM, LLINATGES, EMAIL, IBAN) VALUES (?, ?, ?, ?, ?)")) {
                    pstmt.setInt(1, nss);
                    pstmt.setString(2, nom);
                    pstmt.setString(3, llinatges);
                    pstmt.setString(4, email);
                    pstmt.setString(5, iban);
                    pstmt.executeUpdate();
                }
            }
            // Borro la ocupacion anterior y la vuelvo a insertar con la nueva placa
            try (PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM OCUPA WHERE NSS_EMPLEAT = ?")) {
                pstmt.setInt(1, nss);
                pstmt.executeUpdate();
            }
            if (nomPlaca != null && !nomPlaca.isBlank()) {// Si se ha especificado una placa para al empleado
                int codiPlaca = obtenirCodiPlacaPerNom(nomPlaca);// Obtengo el codi de la placa por su nombre
                if (codiPlaca != -1) {// Si la placa existe asign la placa al empleado insertando en OCUPA
                    try (PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO OCUPA (NSS_EMPLEAT, CODI_PLACA, DATA_INICI) VALUES (?, ?, date('now'))")) {
                        pstmt.setInt(1, nss);
                        pstmt.setInt(2, codiPlaca);
                        pstmt.executeUpdate();
                    }
                }
            }
            return true;
        } catch (SQLException e) {
            System.err.println("Error guardarEmpleat: " + e.getMessage());
            return false;
        }
    }

    //METODO ELIMINAR EMPLEADO POR NSS
    public static boolean eliminarEmpleat(int nss) {// Elimina un empleat por su NSS (primero borra OCUPA por la FK)
        try (Connection conexion = DriverManager.getConnection(URL)) {// Abro la conexion con la BD
            //borro ocupa
            try (PreparedStatement p1 = conexion.prepareStatement("DELETE FROM OCUPA WHERE NSS_EMPLEAT = ?")) {
                p1.setInt(1, nss);
                p1.executeUpdate();
            }
            //borro empleat
            try (PreparedStatement p2 = conexion.prepareStatement("DELETE FROM EMPLEAT WHERE NSS = ?")) {
                p2.setInt(1, nss);
                p2.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            System.err.println("Error eliminarEmpleat: " + e.getMessage());
            return false;
        }
    }

    // NOMINA
    //METODO OBTENER NOMINAS DE UN EMPLEADO POR NSS
    public static ArrayList<Nomina> obtenirNominesPerEmpleat(int nss) {// Devuelve lista de nominas de un empleat concreto
        ArrayList<Nomina> llista = new ArrayList<>();// Instancio la lista que voy a devolver (lista de objetos Nomina)
        String sql = "SELECT ID_NOMINA, IBAN_PAGAMENT, IMPORT, NSS_EMPLEAT, CODI_PLACA FROM NOMINA WHERE NSS_EMPLEAT = ? ORDER BY ID_NOMINA";
        try (Connection conexion = DriverManager.getConnection(URL);// Abro la conexion con la BD
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, nss);// Cambio el ? por el NSS del empleado
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {// Recorro los resultados y creo un objeto Nomina por cada fila
                    llista.add(new Nomina(
                            rs.getInt("ID_NOMINA"),
                            rs.getString("IBAN_PAGAMENT"),
                            rs.getDouble("IMPORT"),
                            rs.getInt("NSS_EMPLEAT"),
                            String.valueOf(rs.getInt("CODI_PLACA"))));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error obtenirNominesPerEmpleat: " + e.getMessage());
        }
        return llista;
    }

    //METODO GUARDAR NOMINA (INSERT O UPDATE)
    public static boolean guardarNomina(int idNomina, String iban, double importe, int nssEmpleat, int codiPlaca) {// Guarda una nomina (si idNomina 0 INSERT si no UPDATE)
        if (iban == null || iban.isBlank()) return false;// Comprobador de los datos obligatiroos
        try (Connection conexion = DriverManager.getConnection(URL)) {// Abro la conexion con la BD
            if (idNomina > 0) {
                // UPDATE si la nomina ya existe
                try (PreparedStatement pstmt = conexion.prepareStatement(
                        "UPDATE NOMINA SET IBAN_PAGAMENT = ?, IMPORT = ?, NSS_EMPLEAT = ?, CODI_PLACA = ? WHERE ID_NOMINA = ?")) {
                    pstmt.setString(1, iban);
                    pstmt.setDouble(2, importe);
                    pstmt.setInt(3, nssEmpleat);
                    pstmt.setInt(4, codiPlaca);
                    pstmt.setInt(5, idNomina);
                    pstmt.executeUpdate();
                }
            } else {
                // INSERT si es una nomina nueva
                try (PreparedStatement pstmt = conexion.prepareStatement(
                        "INSERT INTO NOMINA (IBAN_PAGAMENT, IMPORT, NSS_EMPLEAT, CODI_PLACA) VALUES (?, ?, ?, ?)")) {
                    pstmt.setString(1, iban);
                    pstmt.setDouble(2, importe);
                    pstmt.setInt(3, nssEmpleat);
                    pstmt.setInt(4, codiPlaca);
                    pstmt.executeUpdate();
                }
            }
            return true;
        } catch (SQLException e) {
            System.err.println("Error guardarNomina: " + e.getMessage());
            return false;
        }
    }

    //METODO ELIMINAR NOMINA POR ID
    public static boolean eliminarNomina(int idNomina) {// Elimina una nomina por  ID
        try (Connection conexion = DriverManager.getConnection(URL);// Abro la conexion con la BD
             PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM NOMINA WHERE ID_NOMINA = ?")) {
            pstmt.setInt(1, idNomina);// Cambio el ? por el ID de la nomina
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error eliminarNomina: " + e.getMessage());
            return false;
        }
    }
}