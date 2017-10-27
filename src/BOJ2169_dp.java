import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  StackOverflow 발생...
 */
public class BOJ2169_dp {
    static int N;
    static int M;
    static int[][] map;
    static int[][] dp;
    static boolean[][] check;
    static int MINIMUM = Integer.MIN_VALUE;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./src/BOJ2169_dp.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        dp = new int[N][M];
        check = new boolean[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = MINIMUM;
            }
        }

        dp[N - 1][M - 1] = map[N - 1][M - 1];

        System.out.println(go(0, 0));
    }

    public static int go(int x, int y) {
        if (x >= N) {
            return MINIMUM;
        }
        if (y < 0 || y >= M) {
            return MINIMUM;
        }
        if (check[x][y]) {
            return MINIMUM;
        }
        if (dp[x][y] > MINIMUM) {
            return dp[x][y];
        }

        dp[x][y] = map[x][y];
        check[x][y] = true;

        int temp1 = go(x, y - 1);
        int temp2 = go(x, y + 1);

        int temp = Math.max(temp1, temp2);

        Math.max(temp, go(x + 1, y));

        dp[x][y] += temp;
        check[x][y] = false;

        return dp[x][y];
    }
}
