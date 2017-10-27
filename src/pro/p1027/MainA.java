package pro.p1027;

import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test=1; test<=T; test++) {
            int N = sc.nextInt();
            int map[][] = new int[N + 1][N + 1];
            int dp[][] = new int[N + 1][N + 1];

            int k = 0;
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    map[i][j] = (k++) % 10 +1;
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
                }
            }

            int total = 0;
            for(int i=0; i<N; i++) {
                int r1 = sc.nextInt();
                int c1 = sc.nextInt();
                int r2 = sc.nextInt();
                int c2 = sc.nextInt();

                total += dp[r2][c2] - dp[r1-1][c2] - dp[r2][c1-1] + dp[r1-1][c1-1];
            }

            System.out.println("#"+test+ " " + total);
        }
    }
}
