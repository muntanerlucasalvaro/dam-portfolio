package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero natural entre 0 y 9.");
        int d = sc.nextInt();
        int c=0;
        while (d<0||d>9) {
            System.out.println("ERROR: Numero no valido, vuelva a introducir el valor");
            d = sc.nextInt();
        }
        int a = sc.nextInt();
        while (a !=0) {
            c= a%10;
            if (c==d) {
                System.out.println("SI");
                a=0;
            }
            a=a/10;
        }
        if (a==0&&c!=d) {
            System.out.println("NO");
        }
    }
}