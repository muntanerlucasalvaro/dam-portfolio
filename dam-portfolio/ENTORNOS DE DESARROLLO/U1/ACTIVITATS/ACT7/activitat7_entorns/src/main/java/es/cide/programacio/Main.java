package es.cide.programacio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("introduce el texto:");
       int a = 0, i;
       boolean on = true;
       while (on == true) {
        String texto = sc.nextLine();
        for(i = 0; i<texto.length();i++);{
            if (texto.charAt(i)=='a') {
                a=a+1;
            }
            if (texto.charAt(i)=='.') {
                on = false;
            }
        }
        
       }
       sc.close();
}
}