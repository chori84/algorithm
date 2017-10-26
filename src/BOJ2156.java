import java.util.Scanner;

public class BOJ2156 {
    static int n;
    static int[] W;
    static int[] D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        W = new int[n+1];
        D = new int[n+1];

        for(int i=1; i<=n; i++) {
            W[i] = sc.nextInt();
        }

        D[1] = W[1];

        System.out.println(dp(n));
    }

    public static int dp(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return D[1];
        }
        if (n == 2) {
            return D[2] = W[1] + W[2];
        }
        if (D[n] > 0) {
            return D[n];
        }

        D[n] = Math.max(Math.max(W[n] + W[n - 1] + dp(n - 3), W[n] + dp(n - 2)), dp(n - 1));

        return D[n];
    }
}
