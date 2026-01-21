import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int input, no = 0;
        boolean a = false;
        input = sc.nextInt();
        while (sc.hasNextInt()) {
            if (input%2==0) {
                a= true;
            }
            input = sc.nextInt();
            if (a ==true && input % 2 == 0||a ==false && input % 2 != 0) {
                no = 1;
            }
        }
        if (no == 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
