import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int input, sumaPars = 0, sumaImpars = 0;
        while (sc.hasNextInt()) {
            input = sc.nextInt();
            if (input % 2 == 0) {
                sumaPars = input + sumaPars;
            } else {
                sumaImpars = input + sumaImpars;
            }
        }
        System.out.println(sumaPars - sumaImpars);
    }
}
