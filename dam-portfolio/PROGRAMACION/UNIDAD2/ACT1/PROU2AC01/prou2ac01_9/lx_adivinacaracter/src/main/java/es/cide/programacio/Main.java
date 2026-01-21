package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 9. Adivinar carácter
        // Declara una variable char letra.
        System.out.print("Introduce un carácter: ");
        char a = sc.next().charAt(0);
        // Si es 'a', 'e', 'i', 'o', 'u', muestra "Es una vocal"
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
            System.out.println("Es una vocal");
        }
        // En otro caso, muestra "Es una consonante"
        else {
            System.out.println("Es una consonante");
        }
        sc.close();
    }
}