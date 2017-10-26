package pro.p1025;

import java.util.Scanner;

public class MainC {
    static int A;
    static int B;
    static int C;
    static int Result;
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test=1; test<=T; test++) {
            A = sc.nextInt();
            B = sc.nextInt();
            C = sc.nextInt();
            Result = sc.nextInt();
            dp = new long[Result+1];

            System.out.println("#"+test+" " + cal(Result));
        }
    }

    public static long cal(int result) {
        if (result < 0) {
            return 0;
        }
        if (result == 0) {
            return 1;
        }
        if (result == 1) {
            return 1;
        }
        if (dp[result] > 0) {
            return dp[result];
        }

        dp[result] = cal(result - A) + cal(result - B) + cal(result - C);

        return dp[result];
    }
}
