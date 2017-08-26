import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2517 {
    static int[] t;
    public static void main(String[] args) throws Exception {
        class Runner {
            int no;
            int cost;

            Runner(int no, int cost) {
                this.no = no;
                this.cost = cost;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Runner[] runners = new Runner[N];
        t = new int[N+1];

        for (int i = 0; i < N; i++) {
            int cost = Integer.parseInt(br.readLine());
            runners[i] = new Runner(i, cost);
        }

        Arrays.sort(runners, (r1, r2) -> r1.cost - r2.cost);

        for (int i = 0; i < N; i++) {
            runners[i].cost = i+1;
        }

        Arrays.sort(runners, (r1, r2) -> r1.no - r2.no);

        int totalRunner = 0;
        for (int i = 0; i < N; i++) {
            totalRunner++;
            System.out.println(totalRunner - sum(runners[i].cost-1));
            update(runners[i].cost);
        }
    }

    public static void update(int i) {
        while (i < t.length) {
            t[i] += 1;
            i += (i & -i);
        }
    }

    public static long sum(int i) {
        int total = 0;
        while (i > 0) {
            total += t[i];
            i -= (i & -i);
        }
        return total;
    }
}

