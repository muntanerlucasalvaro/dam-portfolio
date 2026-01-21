package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int a;
        boolean rep = true;
        while (sc.hasNextInt()) {
            a = sc.nextInt();
            if (a < p) {
                System.out.print(a + " ");
            } else if (a == p || a > p && rep == true) {
                System.out.print(p + " ");
                rep = false;
            }
            if (a > p) {
                System.out.print(a + " ");
            }
        }
        if (rep) {
            System.out.print(p + " ");
        }
        sc.close();
    }
}