package es.cide.programacio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Introdueix un nombre natural");
    int a = sc.nextInt();
    int b = 2;
    if (a==1||a==3||a==5||a==7||a==11||a==13) {
        System.out.println("El nombre es primer");
    }
    if (a%b==0 && a>=b||a%(b+1)==0 && a>=b||a%(b+3)==0 && a>=b||a%(b+5)==0 && a>=b||a%(b+9)==0 && a>=b||a%(b+11)==0 && a>=b) {
        System.out.println("El nombre es compost");}
    while (a%b!=0) {
        b=b+1;
        if (a==b) {
            System.out.println("El nombre es primer");
        }
        
    }
    }
}