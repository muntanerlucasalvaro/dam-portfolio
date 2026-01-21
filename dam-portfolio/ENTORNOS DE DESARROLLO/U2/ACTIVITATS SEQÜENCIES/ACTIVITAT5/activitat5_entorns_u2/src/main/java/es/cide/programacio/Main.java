package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String clave = sc.next();
        String secuencia;
        int output = 0;
        int maxRep=0;
        boolean on = true;
        while (on==true) {
            secuencia = sc.next();
            if (secuencia.equals(clave)) {
                output++;
            }
            else {
                output=0;
            }
            if (output>maxRep) {
                maxRep = output;
            }
            if (secuencia.equals(".")) {
                on=false;
            }
        }
        System.out.println(maxRep);
        sc.close();
    }
}