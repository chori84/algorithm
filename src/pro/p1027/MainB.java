package pro.p1027;

import java.util.Scanner;

public class MainB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test=1; test<=T; test++) {
            int N = sc.nextInt();
            int[] p = new int[N+1];

            p[0] = sc.nextInt();
            p[1] = sc.nextInt();

            boolean check = true;
            for(int i=1; i<N; i++) {
                int p1 = sc.nextInt();
                int p2 = sc.nextInt();

                if (p1 != p[i]) {
                    check = false;
                }
                p[i+1] = p2;
            }

            int total = 0;
            if(check) {
                int[][] dp = new int[N + 1][N + 1];

                for(int l=1; l<N; l++) {
                    for (int i = 1; i <= N-l; i++) {
                        int j = i + l;

                        int min = Integer.MAX_VALUE;
                        for(int k=i; k<j; k++) {
                            min = Math.min(min, dp[i][k] + dp[k + 1][j] + p[i-1]*p[k]*p[j]);
                        }

                        dp[i][j] = min;

                    }
                }

                total = dp[1][N];
            }

            System.out.println("#"+test+ " " + total);
        }
    }
}
