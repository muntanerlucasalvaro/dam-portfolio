package es.cide.programacio;

public class CotxeCombustio extends Cotxe {
    // ATRIBUTOS
    private int capacitatDiposit;
    private int dies;
    private double preuLloguer;

    // CONSTRUCTOR
    public CotxeCombustio(String matricula, String marca, int plaçes, double velocitatMaxima, int capacitatDiposit, int dies) {
        super(matricula, marca, plaçes, velocitatMaxima);
        this.capacitatDiposit = capacitatDiposit;
        this.dies=dies;
    }
    //METODOS ABSTRACT HEREDADOS

    @Override
    public double calcularPreuLloguer(int dies) {
    preuLloguer= dies*40;
    return preuLloguer;
    }   
}
