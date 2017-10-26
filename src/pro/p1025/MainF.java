package pro.p1025;

import java.util.Scanner;

public class MainF {
    static int N;
    static int M;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test=1; test<=T; test++) {
            N = sc.nextInt();
            M = sc.nextInt();
            map = new int[N][M];
            dp = new int[N][M];

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            System.out.println("#"+test+" " + go(0, 0));
        }
    }

    public static int go(int x, int y) {
        if (x == N - 1 && y == M - 1) {
            dp[x][y] = map[x][y];
            return dp[x][y];
        }
        if (x >= N || y >= M) {
            return Integer.MAX_VALUE;
        }
        if (dp[x][y] > 0) {
            return dp[x][y];
        }

        int nextX = go(x + 1, y);
        int nextY = go(x, y + 1);
        dp[x][y] = Math.min(nextX, nextY);

        dp[x][y] += map[x][y];

        return dp[x][y];
    }
}
