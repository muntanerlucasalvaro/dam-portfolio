package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Declara una variable String clave.
        System.out.println("Introduzca la contraseña");
        String clave = sc.nextLine();
        String clave_correcta = "java123";
        // Si es igual a "java123", muestra "Acceso permitido".
        if (clave .equals(clave_correcta)) {
            System.out.println("Acceso permitido");
        }
        // En caso contrario, muestra "Acceso denegado".
        else {
            System.out.println("Acceso denegado");
        }
        sc.close();
    }
}