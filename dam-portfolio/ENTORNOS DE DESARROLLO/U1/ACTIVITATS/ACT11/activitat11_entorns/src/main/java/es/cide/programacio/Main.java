package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "a";
        double a, s = 0, c = 0;
        while (!input.equals('.')) {
            input = sc.next();
            a=0;
            s=0;
            c=0;
            a = Integer.parseInt(input);
            while (a > 3) {
                if (a % 7 == 0) {
                    s++;
                    a = a - 7;
                } else if (a % 4 == 0) {
                    c++;
                    a = a - 4;
                } else {
                    a = a - 7;
                    s++;
                }
            }
            System.out.println(s);
            System.out.println(c);
        }
    }
}