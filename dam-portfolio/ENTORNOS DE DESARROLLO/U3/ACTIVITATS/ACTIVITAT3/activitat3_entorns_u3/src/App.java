import java.util.Scanner;

public class App {
    public static boolean funcio(int n) {
        if (n < 10) {
            return true;
        } else { 
            return(n % 10 >= ((n / 10) % 10))&& funcio(n/10);
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un numero para ver si es creciente");
        int a = sc.nextInt();
        boolean sino = funcio(a);
        if (sino) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }
}
