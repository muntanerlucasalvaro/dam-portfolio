package es.cide.programacio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix dos nombres enters no negatius");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int res = 0;
        while (b>0) {
            res = res +a;
            b = b -1;
        }
        System.out.println(res);
    }
}