package es.cide.programacio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1. Número positivo o negativo 
        //Declara una variable entera numero.
        System.out.println("introduzca un numero entero");
        int a = sc.nextInt();
        // Si es mayor o igual a 0, muestra "El número es positivo".
        if (a>=0) {
            System.out.println("El número es positivo");
        }
        //Si es menor que 0, muestra "El número es negativo".
        else if (a<0) {
            System.out.println("El número es negativo");
        }
        sc.close();
    }   
}