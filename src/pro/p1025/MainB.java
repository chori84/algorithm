package pro.p1025;

import java.util.Scanner;

public class MainB {
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test=1; test<=T; test++) {
            int n = sc.nextInt();
            dp = new long[n + 1];

            System.out.println("#"+test+" " + cal(n));
        }
    }

    public static long cal(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (dp[n] > 0) {
            return dp[n];
        }

        dp[n] = cal(n-1) + (2*cal(n-2)) + cal(n-3);

        return dp[n];
    }
}
