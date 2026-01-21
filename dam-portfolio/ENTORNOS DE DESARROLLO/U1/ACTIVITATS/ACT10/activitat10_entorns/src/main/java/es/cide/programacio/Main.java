package es.cide.programacio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        boolean on = true;
        while(on){
            if (a<b){
                System.out.print(a+", ");
                a++;
            }else if (a==b){
                System.out.print(a);
                on = false;
            }else{
                on = false;
            }
        }sc.close();
        
    }
}