package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println( "Indiqui l'operació introduïnt (suma) o (resta) seguida de nos nombres reals (a) i (b) o inversió per invertir el signe del valor, finalment (aturar)");
        String op = sc.nextLine();
        double a, b;
        while (sc.hasNext()) {
            if (op.equals("suma")) {
                a = sc.nextDouble(); 
                b = sc.nextDouble();
                System.out.println(a + b);
                break;
            }
            if (op.equals("resta")) {
                a = sc.nextDouble(); 
                b = sc.nextDouble();
                System.out.println(a - b);
                break;
            }
            if (op.equals("inversio")) {
                a = sc.nextDouble(); 
                System.out.println(-a);
                break;
            }
            if (op.equals("aturar")) {
                break;
            }
        }
    }
}