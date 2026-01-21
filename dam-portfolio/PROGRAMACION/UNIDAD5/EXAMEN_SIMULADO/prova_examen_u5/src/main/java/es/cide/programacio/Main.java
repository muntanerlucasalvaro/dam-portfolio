package es.cide.programacio;


public class Main {
    public static void main(String[] args) {
        boolean cargaC=false, cargaM=false;
        boolean llestC = false, llestM = false;
        Vehicle vehicle = new Vehicle("Sherlon", "123456789123456");
        Cotxe cotxe = new Cotxe("Hasteco", "123456789123456", false);
        Moto moto = new Moto("Jose", "123456789123456");
        System.out.println("Benvingut al taller de reparacions 2026");
        System.out.println("Vehicle registrat, cotxe de: " + cotxe.getPropietari());
        System.out.println("Vehicle registrat, moto de: " + moto.getPropietari());
        while (!llestC || !llestM) {
            if (!llestC) {

                cotxe.revisarVehicle();
                cargaC = cotxe.teCorrent();
            }
            if (!llestM) {
            moto.revisarVehicle();
            cargaM = moto.teCorrent();
            }
            if (cargaC) {
                llestC = cotxe.estaLlest();
            }
            if (cargaM) {
                llestM = moto.estaLlest();
            }
            if (llestC && !llestM) {
                System.out.println("El cotxe està llest i la moto encara està al taller. Cal esperar.");
            }
            if (llestM && !llestC) {
                System.out.println("El cotxe encara està al taller i la moto està llesta. Cal esperar.");
            }
            if (!llestC && !llestM) {
                System.out.println("El cotxe encara està al taller i la moto encara està al taller. Cal esperar.");
            }
        }
        System.out.println("...");
        System.out.println("El cotxe està llest i la moto està llesta. Vehicles entregats!");
        cotxe.finalitzarManteniment();
        moto.finalitzarManteniment();
    }
}