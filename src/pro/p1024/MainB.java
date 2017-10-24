package pro.p1024;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MainB {
    static int N;
    static int[][] map;
    static boolean[] check;
    static int cost[];
    final static int inf = 10000000;

    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int testCase=1; testCase<=test; testCase++) {
            N = sc.nextInt();
            int E = sc.nextInt();

            map = new int[N + 1][N + 1];
            check = new boolean[N + 1];
            cost = new int[N + 1];

            for(int i=0; i<=N; i++) {
                cost[i] = inf;
                for(int j=0; j<=N; j++) {
                    if (i == j) {
                        map[i][j] = 0;
                    } else {
                        map[i][j] = inf;
                    }
                }
            }
            for(int i=0; i<E; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int cost = sc.nextInt();

                map[s][e] = cost;
            }

            cost[0] = 0;
            dij();

            System.out.println("#"+testCase+" " + cost[N]);
        }
    }

    public static void dij() {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        for(int i=1; i<=N; i++) {
            cost[i] = map[0][i];
            if (map[0][i] > 0 && map[0][i] != inf) {
                queue.add(new Node(i, cost[i]));
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i=0; i<=N; i++) {
                if (map[node.node][i] > 0 && map[node.node][i] != inf) {
                    if(cost[i] > map[node.node][i] + node.cost) {
                        cost[i] = map[node.node][i] + node.cost;
                        queue.add(new Node(i, cost[i]));
                    }
                }
            }
        }
    }

    public static void dijkstra(int s, int e) {
        for(int k=0; k<=e; k++) {
            int min = inf + 1;
            int x = -1;
            for(int i=0; i<=e; i++) {
                if(!check[i] && min > cost[i]) {
                    min = cost[i];
                    x = i;
                }
            }
            check[x] = true;

            for(int i=0; i<=e; i++) {
                if (cost[i] > min + map[x][i]) {
                    cost[i] = min + map[x][i];
                }
            }
        }
    }
}
