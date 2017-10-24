package pro.p1024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MainA {
    static class Edge {
        int s;
        int e;
        int cost;

        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }

    static int[] group;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int testCase = 1; testCase <= test; testCase++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            Edge[] edges = new Edge[E];
            group = new int[V+1];

            for(int i=0; i<=V; i++) {
                group[i] = i;
            }
            for (int i = 0; i < E; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int cost = sc.nextInt();

                edges[i] = new Edge(s, e, cost);
            }

            Arrays.sort(edges, Comparator.comparingInt(e -> e.cost));

            int cnt = 0;
            int index = 0;
            int sum = 0;
            while (cnt < V) {
                Edge edge = edges[index];
                int p1 = findGroup(edge.s);
                int p2 = findGroup(edge.e);

                if (p1 != p2) {
                    group[p2] = p1;
                    sum += edge.cost;
                    cnt++;
                }
                index++;
            }

            System.out.println("#"+testCase+" " + sum);
        }
    }

    public static int findGroup(int n) {
        while (group[n] != n) {
            n = group[n];
        }

        return n;
    }
}
