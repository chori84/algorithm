package pro.p1024;

import java.util.*;

public class MainC {
    static int N;
    static int[][] map;
    static int[][] r;
    static int cost[][];
    final static int inf = 10000000;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int testCase=1; testCase<=test; testCase++) {
            N = sc.nextInt();
            map = new int[N][N];
            r = new int[N][N];
            cost = new int[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    cost[i][j] = inf;
                    map[i][j] = sc.nextInt();
                    r[i][j] = -1;
                }
            }

            dij();
            System.out.println("#"+testCase+ " " + cost[N-1][N-1]);
        }
    }

    public static void dij() {
        Queue<Node> queue = new LinkedList<>();
        cost[0][0] = 0;
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int x = node.x;
            int y = node.y;

            if (x - 1 >= 0) {
                int temp = cost[x][y] + 1;
                if(map[x-1][y] > map[x][y]) {
                    temp += map[x - 1][y] - map[x][y];
                }
                if(cost[x-1][y] > temp) {
                    cost[x-1][y] = temp;
                    queue.add(new Node(x - 1, y));
                }
            }
            if (x + 1 < N) {
                int temp = cost[x][y] + 1;
                if(map[x+1][y] > map[x][y]) {
                    temp += map[x + 1][y] - map[x][y];
                }
                if(cost[x+1][y] > temp) {
                    cost[x+1][y] = temp;
                    queue.add(new Node(x + 1, y));
                }
            }

            if (y + 1 < N) {
                int temp = cost[x][y] + 1;
                if (map[x][y + 1] > map[x][y]) {
                    temp += map[x][y + 1] - map[x][y];
                }
                if(cost[x][y+1] > temp) {
                    cost[x][y+1] = temp;
                    queue.add(new Node(x , y+1));
                }
            }

            if (y - 1 >= 0) {
                int temp = cost[x][y] + 1;
                if (map[x][y - 1] > map[x][y]) {
                    temp += map[x][y - 1] - map[x][y];
                }
                if(cost[x][y-1] > temp) {
                    cost[x][y-1] = temp;
                    queue.add(new Node(x , y-1));
                }
            }
        }
    }

    public static int dp(int x, int y) {
        if(x == N-1 && y == N-1) {
            r[x][y] = 0;
            return 0;
        }
        if (x >= N || y >= N) {
            return Integer.MAX_VALUE-1;
        }
        if(r[x][y] > -1) {
            return r[x][y];
        }

        int right = dp(x + 1, y) + 1;
        if(x+1 < N) {
            right += map[x + 1][y] - map[x][y] > 0 ? map[x + 1][y] - map[x][y] : 0;
        }
        int bottom = dp(x, y + 1) + 1;
        if (y + 1 < N) {
            bottom += map[x][y + 1] - map[x][y] > 0 ? map[x][y + 1] - map[x][y] : 0;
        }
        r[x][y] = Math.min(right, bottom);

        return r[x][y];
    }
}
