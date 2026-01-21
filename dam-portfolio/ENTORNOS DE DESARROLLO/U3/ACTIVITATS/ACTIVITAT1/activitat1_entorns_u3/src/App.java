public class App {
public static int funcionRecursiva(int n) {
    if (n / 10 == 0) {
        return 1;
    }
    return funcionRecursiva(n/10)+1;
}
    public static void main(String[] args) throws Exception {
        System.out.println(funcionRecursiva(200));
    }
}
