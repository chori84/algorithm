package pro.p1023;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int testCase = 1; testCase <= test; testCase++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            boolean[][] p = new boolean[N + 1][N + 1];
            int[] count = new int[N + 1];
            int[] coin = new int[N + 1];

            for(int i=0; i<K; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();

                count[e]++;
                p[s][e] = true;
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i=1; i<=N; i++) {
                if (count[i] == 0) {
                    queue.offer(i);
                    coin[i] = 1;
                }
            }

            while (!queue.isEmpty()) {
                int start = queue.poll();
                for (int i = 1; i <= N; i++) {
                    if(p[start][i]) {
                        count[i]--;
                        p[start][i] = false;

                        if(count[i] == 0) {
                            queue.offer(i);
                            coin[i] = coin[start]+1;
                        }
                    }
                }
            }

            int max = 0;
            for(int i=1; i<=N; i++) {
                if(coin[i] > max) {
                    max = coin[i];
                }
            }

            System.out.println("#"+testCase+ " " + max);
        }
    }
}
