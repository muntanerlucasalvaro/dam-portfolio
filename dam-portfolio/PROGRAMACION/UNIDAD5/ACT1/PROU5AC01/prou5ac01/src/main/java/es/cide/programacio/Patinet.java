package es.cide.programacio;

public class Patinet extends Vehicle implements Recarregable {
    // ATRIBUTOS
    private int dies;
    private double preuLloguer;
    private int nivellBateria;

    // CONSTRUCTOR
    public Patinet(String matricula, String marca, int dies, int nivellBateria) {
        super(matricula, marca);
        this.dies = dies;
        this.nivellBateria = nivellBateria;
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
        preuLloguer = dies * 15;
        return preuLloguer;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("--- FITXA PATINET ---");
        System.out.println("Marca: " + marca);
        System.out.println("Matrícula: " + matricula);
    }
}
