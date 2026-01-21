public class App {
    int sumaArray(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++)
            res = res + arr[i];
        return res;

    }

    public static void main(String[] args) throws Exception {
        App a = new App();
        System.out.println("Hello, World!");
        int res = a.sumaArray(new int[]{1,2,3,4,5}, 5);
        System.out.println(res);
    }
}
