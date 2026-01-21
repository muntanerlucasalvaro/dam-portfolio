package es.cide.programacio;

public class CotxeElectric extends Cotxe implements Recarregable {
    // ATRIBUTS
    private int dies;
    private double preuLloguer;
    private int nivellBateria;

    // CONSTRUCTOR
    public CotxeElectric(String matricula, String marca, int plaçes, double velocitatMaxima) {
        super(matricula, marca, plaçes, velocitatMaxima);
    }

    // METODOS
    @Override
    public void carregarBateria() {
        nivellBateria = 100;
    }

    @Override
    public int getNivellBateria() {

        return nivellBateria;
    }

    @Override
    public double calcularPreuLloguer(int dies) {
        preuLloguer = dies * 56;
        return preuLloguer;
    }
}
