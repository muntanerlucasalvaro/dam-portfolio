package es.cide.programacio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        Calculadora miCasio = new Calculadora(10, 5);
        double resultado;
        resultado = miCasio.sumar();
        System.out.println(resultado);
        miCasio.setOperando1(200);
         resultado = miCasio.sumar();
        System.out.println(resultado);
        resultado = miCasio.restar();
        System.out.println(resultado);
        resultado = miCasio.dividir();
        System.out.println(resultado);
        resultado = miCasio.multiplicar();
        System.out.println(resultado);
        //--------------------------------------------------------------------------------------
        System.out.println();
         double operando1 = 0;
        double operando2 = 0;
        System.out.println("Introduce la operación que deseas realizar");
        String operacion = sc.next();
        switch (operacion) {
            case "sumar":
                System.out.println("indique los dos operandos que desea sumar");
                System.out.println();
                System.out.println("operando 1");
                operando1 = sc.nextDouble();
                miCasio.setOperando1(operando1);
                System.out.println("operando 2");
                operando2 = sc.nextDouble();
                miCasio.setOperando2(operando2);
                resultado = miCasio.sumar();
                System.out.println(resultado);
                break;
            case "resta":
                System.out.println("indique los dos operandos que desea restar");
                System.out.println();
                System.out.println("operando 1");
                operando1 = sc.nextDouble();
                miCasio.setOperando1(operando1);
                System.out.println("operando 2");
                operando2 = sc.nextDouble();
                miCasio.setOperando2(operando2);
                resultado = miCasio.restar();
                System.out.println(resultado);
                break;
            case "multiplicacion":
                System.out.println("indique los dos operandos que desea multiplicar");
                System.out.println();
                System.out.println("operando 1");
                operando1 = sc.nextDouble();
                miCasio.setOperando1(operando1);
                System.out.println("operando 2");
                operando2 = sc.nextDouble();
                miCasio.setOperando2(operando2);
                resultado = miCasio.multiplicar();
                System.out.println(resultado);
                break;
            case "division":
                System.out.println("indique los dos operandos que desea dividir");
                System.out.println();
                System.out.println("operando 1");
                operando1 = sc.nextDouble();
                miCasio.setOperando1(operando1);
                System.out.println("operando 2");
                operando2 = sc.nextDouble();
                miCasio.setOperando2(operando2);
                resultado = miCasio.dividir();
                System.out.println(resultado);
                break;
        
            default:
            System.out.println("OPERACIÓN INCORRECTA O NO DISPONIBLE");
                break;
        }
        
    }
}