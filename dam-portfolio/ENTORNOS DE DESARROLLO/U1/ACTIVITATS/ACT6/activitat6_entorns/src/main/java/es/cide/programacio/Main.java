package es.cide.programacio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix un nombre enter positiu");
        int n = sc.nextInt(),i;
        for (i = 0; i <= n; ++i);{
            for(int j = 0;j <= i ;++j);
            System.out.print("*");
        }
        System.out.println();
    }
}