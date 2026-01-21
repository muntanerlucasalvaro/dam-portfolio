package es.cide.programacio;

import java.util.Scanner;
//el programa ve si la palabra introducida primero esta en la secuencia de palabras que introduce despues

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.next(); // palabra a buscar
        String s = "";
        boolean nomayor = true; // si no son mayores

        while (nomayor) {
            s = sc.next(); // secuencia
            if (p.compareTo(s) <= 0) { //compara la palabra con la secuencia hasta que no quede ninguno
                nomayor = false;
            } else if (s.equals(".")) { //hasta que ponga "." el usuario no parara de pedir numeros
                nomayor = false;
            }
        }

        if (s.equals(p)) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}