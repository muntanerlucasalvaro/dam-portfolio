package es.cide.programacio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Indiqui dues paraules per favor: ");
        String a = sc.next();
        String b = sc.next();
        sc.close();
        int comparacio = a.compareTo(b);
       if (comparacio < 0) {
        System.out.println(a + "<" + b);
       }
       else if (comparacio > 0) {
        System.out.println(a + ">" + b);
       }
        else {
            System.out.println(a + "=" + b);
        }
        
    }
}