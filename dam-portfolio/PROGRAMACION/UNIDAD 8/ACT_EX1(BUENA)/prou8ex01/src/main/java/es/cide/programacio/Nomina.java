package es.cide.programacio;

public class Nomina {
    // ATRIBUTS
    private int idNomina;// ID (clave primaria)
    private String ibanPagament;// IBAN donde se paga la nomina
    private double importe;// Cantidad de la nomina
    private int nssEmpleat;// NSS del empleado al que pertenece
    private String codiPlaca;// Codi de la plaza asociada

    // CONSTRUCTOR
    public Nomina(int idNomina, String ibanPagament, double importe, int nssEmpleat, String codiPlaca) {
        this.idNomina = idNomina;
        this.ibanPagament = ibanPagament;
        this.importe = importe;
        this.nssEmpleat = nssEmpleat;
        this.codiPlaca = codiPlaca;
    }

    // GETTERS Y SETTERS
    // GETTERS
    public int getIdNomina() {
        return idNomina;
    }

    public String getIbanPagament() {
        return ibanPagament;
    }

    public double getImporte() {
        return importe;
    }

    public int getNssEmpleat() {
        return nssEmpleat;
    }

    public String getCodiPlaca() {
        return codiPlaca;
    }

    // SETTERS
    public void setIdNomina(int idNomina) {
        this.idNomina = idNomina;
    }

    public void setIbanPagament(String ibanPagament) {
        this.ibanPagament = ibanPagament;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setNssEmpleat(int nssEmpleat) {
        this.nssEmpleat = nssEmpleat;
    }

    public void setCodiPlaca(String codiPlaca) {
        this.codiPlaca = codiPlaca;
    }
}