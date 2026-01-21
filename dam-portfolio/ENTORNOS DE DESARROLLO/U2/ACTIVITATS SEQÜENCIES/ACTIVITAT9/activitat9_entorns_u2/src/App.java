import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int input, res = 0;
        while (sc.hasNextInt()) {
            input=sc.nextInt();
            if (input%3==0) {
                res= res+ input;
            }
            if (input%5==0) {
                res=res-input;
            }
        }
        System.out.println(res);
    }
}
