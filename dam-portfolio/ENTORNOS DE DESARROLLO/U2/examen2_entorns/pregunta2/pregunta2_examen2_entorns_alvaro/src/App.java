import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = "a";
        int contador = 0;
        boolean cuentaActiva = false;
        boolean incorrecte = false;
        while (!input.equals("*")) {
            input = sc.next();
            if (input.equals("principi")) {
                cuentaActiva = true;
            }
            if (cuentaActiva == true) {
                contador++;
            }
            if (input.equals("final") && cuentaActiva == false) {
                incorrecte = true;
                input = "*";
            }
            if (input.equals("final")) {
                cuentaActiva = false;
            }

        }
        if (cuentaActiva==true) {
            incorrecte = true;
        }
        if (input.equals("*") && contador == 0) {
            incorrecte = true;
        }
        if (incorrecte == false) {
            System.out.println(contador-2);
        } else {
            System.out.println("incorrecte");
        }
    }

}
