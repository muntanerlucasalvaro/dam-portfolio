public class App {
    public int fibonacci(int n) {
    if (n==0) {
        n=0;
    }
    else if (n==1) {
        n=1;
    }
    else if (n>=2) {
        int a = fibonacci(n-1);
        int b = fibonacci(n-2);
        n=a+b;
    }
    return n;
}

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        App a = new App();
        int resultat = a.fibonacci(7);
        System.out.println(resultat);
    }
}
