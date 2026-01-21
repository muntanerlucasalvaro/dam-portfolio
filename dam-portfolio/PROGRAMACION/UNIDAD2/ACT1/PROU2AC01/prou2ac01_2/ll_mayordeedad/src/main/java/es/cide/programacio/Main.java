package es.cide.programacio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       //2. Mayor de edad
       // Pedir la edad al usuario
        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();
        // Comprobar si es mayor o menor de edad
        if (edad >= 18) {
            System.out.println("Mayor de edad");
        } else {
            System.out.println("Menor de edad");
        }

        sc.close();
        }
    }
