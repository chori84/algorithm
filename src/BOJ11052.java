import java.util.Scanner;

public class BOJ11052 {
    static int N;
    static int[] P;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        P = new int[N + 1];
        dp = new int[N + 1];

        for(int i=1; i<=N; i++) {
            P[i] = sc.nextInt();
        }

        System.out.println(sell(N));
    }

    public static int sell(int n) {
        if (n <= 0) {
            return 0;
        }
        if (dp[n] > 0) {
            return dp[n];
        }

        int max = 0;
        for(int i=1; i<=n && i<=N; i++) {
            max = Math.max(max, sell(n-i) + P[i]);
        }

        dp[n] = max;

        return dp[n];
    }
}
