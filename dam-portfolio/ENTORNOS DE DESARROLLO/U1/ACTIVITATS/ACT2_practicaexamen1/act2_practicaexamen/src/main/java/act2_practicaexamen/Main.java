package act2_practicaexamen;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   System.out.println("INTRODUZCA EL NUMERO A COMPROBAR");
    String entrada = sc.next();
    int a;
    while (!entrada.equals("*")) {
        a = Integer.parseInt(entrada);
        if (a%10==0) {
            System.out.println("ES MULTIPLO DE 10");
        }
        else {System.out.println("NO ES MULTIPLO DE 10");}
    System.out.println("INTRODUZCA EL NUMERO A COMPROBAR");
       entrada = sc.next();
    }
    sc.close();
        }
}