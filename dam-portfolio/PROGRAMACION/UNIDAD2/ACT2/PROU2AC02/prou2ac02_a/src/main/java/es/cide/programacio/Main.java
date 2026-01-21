package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Escriu un programa en Java que demani a l’usuari un número enter positiu. El
        // programa ha de calcular la suma de tots els números parells des de 1 fins al
        // número introduït utilitzant un bucle while.
        System.out.println("Indiqui un número enter positiu");
        int a = sc.nextInt();// Declaració de int solicitat.
        int i = 0;// Declaració del index.
        int acumulador = 0;// Declaració del acumulador.
        while (i <= a) {
            System.out.println(i);
            if (i % 2 == 0) {
                acumulador = i + acumulador;
            }
            i = i + 1;
        }
        System.out.println(acumulador);
        sc.close();
    }
}