package es.cide.programacio;

public class Moto extends Vehicle implements Energia, Manteniment {

    public Moto(String propietari, String numBastidor) {
        super(propietari, numBastidor);
    }

    @Override
    public void revisarVehicle() {
        System.out.println("Iniciant la revisió de la moto");
    }

    @Override
    public void finalitzarManteniment() {
        System.out.println("Manteniment finalitzat de la moto.");
    }

    @Override
    public boolean estaLlest() {
        int a = ra.nextInt(10) + 1;
        if (a <= 6) {
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
