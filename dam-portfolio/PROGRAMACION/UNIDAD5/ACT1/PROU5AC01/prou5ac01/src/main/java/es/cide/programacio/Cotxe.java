package es.cide.programacio;

public abstract class Cotxe extends Vehicle {
    // ATRIBUTOS
    protected int plaçes;
    protected double velocitatMaxima;

    // CONSTRUCTOR
    public Cotxe(String matricula, String marca, int plaçes, double velocitatMaxima) {
        super(matricula, marca);
        this.plaçes = plaçes;
        this.velocitatMaxima = velocitatMaxima;
    }

    // METODOS
    public double getVelocitatMaxima() {
        return velocitatMaxima;
    }
}
