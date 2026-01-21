package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        boolean encontrado = false;
        while (input!=0) {
            if (input%2==0 && input!=0) {
                encontrado = true;
            }
            input=sc.nextInt();
            
        }
        if (encontrado== true) {
            System.out.println("si");
        }
        else{System.out.println("no");}
        sc.close();
    }
}