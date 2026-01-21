package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input;
        int i=0;
        int contadorDerecha =0,contadorIzquierda =0;
        boolean on = true;
        while (on==true) {
            input=sc.next();
            if (contadorIzquierda>contadorDerecha) {
                contadorDerecha=0;
                on= false;
            }
            if (input.equals("(")) {
                contadorDerecha++;
            }
            else if (input.equals(")")) {
                contadorIzquierda++;
            }
            else if (input.equals(".")) {
                on=false;
            }
        }
        if (contadorDerecha==contadorIzquierda) {
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}