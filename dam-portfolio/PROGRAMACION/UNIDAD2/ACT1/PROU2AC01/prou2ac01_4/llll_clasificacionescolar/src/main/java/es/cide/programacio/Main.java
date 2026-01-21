package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //4. Calificación escolar
        // Declara una variable entera nota entre 0 y 10.
        System.out.println("Introduzca un numero del 0 al 10");
        int a = sc.nextInt();
        // Usa if/else para mostrar:
        // "Suspenso" si la nota < 5.
        if (a < 5) {
            System.out.println("suspenso");
        }
        // "Aprobado" si está entre 5 y 6.
        else if (5 <= a) {
            if (a <= 6) {
                System.out.println("Aprobado");
            }
        }
        // "Notable" si está entre 7 y 8.
       if (7 <= a) {
            if (a <= 8) {
                System.out.println("Notable");
            }
        }
        // "Sobresaliente" si está entre 9 y 10.
       if (9 <= a) {
            if (a <= 10) {
                System.out.println("Sobresaliente");
            }
        }
        // No puede admitir valores fuera de los especificados.
        if (a<0) {
            System.out.println("ERROR");
        }
        if (a>10) {
            System.out.println("ERROR");
        }
        sc.close();
    }

}