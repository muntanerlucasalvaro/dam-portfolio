package es.cide.programacio;

public class Vehicle {
    // ATRIBUTOS
    int plazas;
    double peso;
    double autonomiaTotal;
    String tipoCombustible;
    double deposito;
    double consumo;
    double range;
    int ocupantes;

    // CONSTRUCTOR
    public Vehicle(int plazas,double peso, double autonomiaTotal, String tipoCombustible, double deposito, double consumo,int ocupantes) {
        this.plazas = plazas;
        this.peso = peso;
        this.autonomiaTotal = autonomiaTotal;
        this.tipoCombustible = tipoCombustible;
        this.deposito = deposito;
        this.consumo = consumo;
        this.ocupantes = ocupantes;
    }

    // GETTERS Y SETTERS
    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    public double getDeposito() {
        return this.deposito;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getConsumo() {
        return this.consumo;
    }

     public double getOcupantes() {
        return this.ocupantes;
    }

    // METODOS
    public double range() {
        double rangeActual = deposito / consumo*100;
        return rangeActual;
    }
     public int añadirOcupante() {
       if (ocupantes>=plazas) {
        System.out.println("EL COCHE ESTA LLENO, NO CABEN MAS PERSONAS");
       }
       else{ocupantes ++;}
        return ocupantes;
    }
     public int retirarOcupante() {
        if (ocupantes<0) {
        System.out.println("NO HAY PERSONAS DENTRO DEL COCHE");
        }
       else {ocupantes = ocupantes-1;}
        return ocupantes;
    }
}
