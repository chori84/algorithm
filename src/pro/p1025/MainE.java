package pro.p1025;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test=1; test<=T; test++) {
            int N = sc.nextInt();
            int E = sc.nextInt();

            int[][] map = new int[N+1][N+1];
            int[] count = new int[N+1];
            int[] dp = new int[N+1];

            for(int i=0; i<E; i++) {
                int s = sc.nextInt();
                int next = sc.nextInt();
                int cost = sc.nextInt();

                map[s][next] = cost;
                count[next]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            while (!queue.isEmpty()) {
                int n = queue.poll();

                for(int i=1; i<=N; i++) {
                    if(map[n][i] > 0) {
                        dp[i] = Math.max(dp[i], dp[n] + map[n][i]);
                        count[i]--;

                        if (count[i] == 0) {
                            queue.add(i);
                        }
                    }
                }
            }

            System.out.println("#"+test+" "+dp[N]);
        }
    }
}
