import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int input, inputAnterior = 3143, inputAnterior2 = 3143;
        boolean picoValido = false;
        while (sc.hasNextInt()){
            input = sc.nextInt();
            if (inputAnterior > 3143 && inputAnterior > input && inputAnterior > inputAnterior2) {
                picoValido = true;
            }
            inputAnterior2 = inputAnterior;
            inputAnterior = input;
        }
        if (picoValido==true) {
            System.out.println("SI");
        }
        else{
            System.out.println("NO");
        }
        sc.close();
    }
}
