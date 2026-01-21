package es.cide.programacio;

import java.util.Random;

public class Cotxe extends Vehicle implements Energia, Manteniment {
    // ATRIBUTOS
    Random ra = new Random();
    protected boolean esTesla;

    // CONSTRUCTOR
    public Cotxe(String propietari, String numBastidor, boolean esTesla) {
        super(propietari, numBastidor);
        this.esTesla = esTesla;
    }

    // GETTERS Y SETTERS
    public void setEsTesla(boolean esTesla) {
        this.esTesla = esTesla;
    }

    public boolean getEsTesla() {
        return esTesla;
    }

    // METODOS
    @Override
    public void revisarVehicle() {
        System.out.println("Iniciant la revisió del cotxe");
    }

    @Override
    public void finalitzarManteniment() {
        esTesla= getEsTesla();
        if (esTesla) {
            System.out.println("Manteniment finalitzat del cotxe. És un Tesla.");
        } else {
            System.out.println("Manteniment finalitzat del cotxe. No és un Tesla.");
        }
    }

    @Override
    public boolean estaLlest() {
        int a = ra.nextInt(10) + 1;
        if (a <= 8) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void carregarBateria() {

    }

    @Override
    public boolean teCorrent() {
        int b = ra.nextInt(2) + 1;
        if (b == 1) {
            return true;
        } else {
            return false;
        }
    }

}
