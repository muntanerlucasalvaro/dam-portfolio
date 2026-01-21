public class App {
    String invertir(String s) {
        if (s == null || s.length() <= 1) {
        return s;
    }
    return s.charAt(s.length() - 1) + invertir(s.substring(0, s.length() - 1));
}

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        App a = new App();
        String res = a.invertir("Java");
        System.out.println(res);
    }
}
