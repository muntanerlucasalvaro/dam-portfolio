package es.cide.programacio;

public class Main {
    public static void main(String[] args) {
        CotxeCombustio cotxeCombustio = new CotxeCombustio("BCD-1234", "opel", 4, 56, 100, 5);
        CotxeElectric cotxeElectric = new CotxeElectric("ABC-9876", "Tesla", 5, 220);
        Patinet patinet = new Patinet("PTN-5555", "marca1", 3, 40);
        double llogerCombustio = cotxeCombustio.calcularPreuLloguer(5);
        double lloguerElectric = cotxeElectric.calcularPreuLloguer(5);
        double lloguerPatinet = patinet.calcularPreuLloguer(5);
        System.out.println(llogerCombustio);
        System.out.println(lloguerElectric);
        System.out.println(lloguerPatinet);
    }
}