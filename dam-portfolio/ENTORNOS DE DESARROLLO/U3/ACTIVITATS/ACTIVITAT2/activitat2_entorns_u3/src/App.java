
public class App {
    public static int funcio(int x) {
        if (x / 10 == 0) {
            return x;
        } else {
            return funcio((x % 10) + funcio(x / 10));
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(funcio(33));
    }
}
