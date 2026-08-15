package es.cide.programacio;

public class Empleat {
    // ATRIBUTS
    private int nss;// NSS (clave primaria)
    private String nom;
    private String llinatges;
    private String email;
    private String iban;
    private String nomPlaca;// Nombre de la plaza que ocupa (nuleable)

    // CONSTRUCTOR
    public Empleat(int nss, String nom, String llinatges, String email, String iban, String nomPlaca) {
        this.nss = nss;
        this.nom = nom;
        this.llinatges = llinatges;
        this.email = email;
        this.iban = iban;
        this.nomPlaca = nomPlaca;
    }

    // GETTERS Y SETTERS
    // GETTERS
    public int getNss() {
        return nss;
    }

    public String getNom() {
        return nom;
    }

    public String getLlinatges() {
        return llinatges;
    }

    public String getEmail() {
        return email;
    }

    public String getIban() {
        return iban;
    }

    public String getPlazaNom() {
        return nomPlaca;
    }

    // SETTERS
    public void setNss(int nss) {
        this.nss = nss;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setPlazaNom(String nomPlaca) {
        this.nomPlaca = nomPlaca;
    }
}