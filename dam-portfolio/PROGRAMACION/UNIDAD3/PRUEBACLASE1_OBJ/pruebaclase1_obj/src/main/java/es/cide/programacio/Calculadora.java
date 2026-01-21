package es.cide.programacio;

public class Calculadora {
    // ATRIBUTOS
    double operando1;
    double operando2;

    // CONSTRUCTOR
    public Calculadora(double operando11, double operando22) {
        this.operando1 = operando11;
        this.operando2 = operando22;
    }

    // GETTERS Y SETTERS
    public void setOperando1(double operando33) {
        this.operando1 = operando33;
    }

    public double getOperando1() {
        return this.operando1;
    }

    public void setOperando2(double operando44) {
        this.operando2 = operando44;
    }

    public double getOperando2() {
        return this.operando2;
    }

    // METODOS
    public double sumar() {
        double resultadoSuma = operando1 + operando2;
        return resultadoSuma;
    }
     public double restar() {
        double resultadoResta = operando1 - operando2;
        return resultadoResta;
    }
     public double multiplicar() {
        double resultadoMultiplicacion = operando1 * operando2;
        return resultadoMultiplicacion;
    }
     public double dividir() {
        double resultadoDivision = operando1 / operando2;
        return resultadoDivision;
    }
}
