package es.cide.programacio;

public class Main {
    public static void main(String[] args) {
  Vehicle micoche = new Vehicle(5, 1000, 200, "diesel",30, 5, 2);
  double range = micoche.range();
  System.out.println("Los kilometros que puede recorrer son: " + range+"KM");
  double ocupantes = micoche.getOcupantes();
  System.out.println("Los ocupantes actuales son: "+ocupantes);
  ocupantes = micoche.añadirOcupante();
  System.out.println("Los ocupantes actuales son: "+ocupantes);
  micoche.setConsumo(2);
  range = micoche.range();
  System.out.println("Los kilometros que puede recorrer son: " + range+"KM");
    }
}