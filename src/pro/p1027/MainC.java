package pro.p1027;

import java.util.Scanner;

public class MainC {
    static int N;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test=1; test<=T; test++) {
            N = sc.nextInt();
            map = new int[N+1][N+1];
            dp = new int[N+1][1<<N+1];
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    map[i][j] = sc.nextInt();
                }

                for(int j=0; j<(1<<N+1); j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            for(int i=1; i<=N; i++) {
                dp[i][0] = map[i][1];
            }

            int s = ((1<<(N+1))-1) & ~3;
            System.out.println("#"+test+ " " + go(1, s));
        }
    }

    public static int go(int n, int s) {
        if(s == 0) {
            return dp[n][0];
        }
        if (dp[n][s] < Integer.MAX_VALUE) {
            return dp[n][s];
        }

        int min = Integer.MAX_VALUE;
        for(int i=2; i<=N; i++) {
            if ((s & (1 << i)) != 0) {
                min = Math.min(min, map[n][i] + go(i, (s & ~(1 << i))));
            }
        }

        dp[n][s] = min;

        return dp[n][s];
    }
}
