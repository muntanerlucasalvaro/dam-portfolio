package es.cide.programacio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("introduce un numero entero");
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int cuenta = 0;
        while (a!=0) {
            a = a/10;
            cuenta = cuenta +1;
        }
        System.out.println(cuenta);
    }
}