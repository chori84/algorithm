package pro.p1026;

import java.util.Scanner;

public class MainB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test=1; test<=T; test++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int map[][] = new int[N + 1][M + 1];
            int dp[][] = new int[N + 1][M + 1];

            for(int i=1; i<=N; i++) {
                for(int j=1; j<=M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            dp[1][1] = 1;
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=M; j++) {
                    for(int k=1; k<i; k++) {
                        if (map[k][j] == i - k) {
                            dp[i][j] += dp[k][j];
                        }
                    }
                    for(int k=1; k<j; k++) {
                        if (map[i][k] == j - k) {
                            dp[i][j] += dp[i][k];
                        }
                    }
                }
            }

            System.out.println("#"+test+" " + dp[N][M]);

        }
    }
}
