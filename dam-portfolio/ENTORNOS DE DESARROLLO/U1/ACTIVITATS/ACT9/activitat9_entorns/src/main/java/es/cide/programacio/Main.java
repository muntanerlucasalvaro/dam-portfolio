package es.cide.programacio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la cantidad de figuras");
        int n = sc.nextInt();
        int c = 0;
        double h,l,r,a;
        String desc;
        final double pi= 3.14;
        while (c<n){
            System.out.println("Elija \"rectangle\" o \"cercle\" seguida de sus atributos");
            desc = sc.next();
            if (desc.equals("rectangle")){
                h = sc.nextDouble();
                l = sc.nextDouble();
                a = h*l;
                System.out.println(a);
                
            }else if (desc.equals("cercle")){
                r = sc.nextDouble();
                a = pi * (r*r);
                System.out.println(a);
            }else {
                System.out.println("Figura invalida");
                c--;
            }
            c++;
        }
        sc.close();
    }
}