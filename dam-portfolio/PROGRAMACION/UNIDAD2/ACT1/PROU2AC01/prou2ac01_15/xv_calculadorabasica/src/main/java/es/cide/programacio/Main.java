package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Declara dos enteros a, b y un char operador que puede ser '+', '-', '*', '/'.
        System.out.println("Introduzca una operacion basica de enteros utilizando espacio entre operadores y numeros");
        int a = sc.nextInt();
        char c = sc.next().charAt(0);
        int b = sc.nextInt();
        // Usa switch/case para realizar la operación correspondiente y mostrar el
        // resultado.
        switch (c) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;

            default:
                System.out.println("ERROR");
                break;
        }
        sc.close();
    }
}