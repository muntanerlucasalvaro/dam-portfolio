package es.cide.programacio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //3. Par o impar
        //Declara una variable entera numero.
        System.out.println("Introduzca un numero entero");
        int a = sc.nextInt();
        //Si el número es divisible por 2, muestra "El número es par"
        if (a%2==0) {
            System.out.println( "El número es par");
        }
        //Si no lo es, muestra "El número es impar".
        else {
        System.out.println("El número es impar");    
        }
        sc.close();
    }
}