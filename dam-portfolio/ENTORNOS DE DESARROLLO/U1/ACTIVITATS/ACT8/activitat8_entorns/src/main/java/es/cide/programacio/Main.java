package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int corx = 0, cory = 0;
        boolean on = true;
        while (on == true) {
            String linea = sc.nextLine();
            for (int i = 0; i < linea.length(); i++)
            {
                if (linea.charAt(i) == 'n') {
                    cory = cory + 1;
                } else if (linea.charAt(i) == 's') {
                    cory = cory + 1;
                }
                if (linea.charAt(i) == 'w') {
                    corx = corx - 1;
                } else if (linea.charAt(i) == 'e') {
                    corx = corx + 1;
                }
                if (linea.charAt(i) == '.') {
                    on = false;
                }
            }
        }
        System.out.println("("+ corx + "," + cory +")");
        sc.close();
    }
}