package pro.p1026;

import java.util.Scanner;

public class MainD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test=1; test<=T; test++) {
            int N = sc.nextInt();
            int[][] cost = new int[N + 1][4];
            int[][] dp = new int[N + 1][4];

            for(int i=1; i<=N; i++) {
                for(int j=1; j<=3; j++) {
                    cost[i][j] = sc.nextInt();
                }
            }

            for(int i=1; i<=N; i++) {
                for(int j=1; j<=3; j++) {
                    if(i == 1) {
                        dp[i][j] = cost[i][j];
                    } else {
                        int min = Integer.MAX_VALUE;
                        for(int k=1; k<=3; k++) {
                            if (k != j) {
                                min = Math.min(min, dp[i-1][k]);
                            }
                        }
                        dp[i][j] = cost[i][j] + min;
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++) {
                min = Math.min(min, dp[N][i]);
            }

            System.out.println("#"+test+" " + min);
        }
    }
}
