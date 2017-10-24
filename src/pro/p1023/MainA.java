package pro.p1023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int testCase=1; testCase<=test; testCase++) {
            StringTokenizer stNM = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stNM.nextToken());
            int M = Integer.parseInt(stNM.nextToken());

            int[] P = new int[N + 1];

            for(int i=0; i<=N; i++) {
                P[i] = i;
            }

            StringTokenizer stP = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                int S = Integer.parseInt(stP.nextToken());
                int E = Integer.parseInt(stP.nextToken());

                while(P[S] != S) {
                    S = P[S];
                }

                P[E] = S;
            }

            int total = 0;
            for(int i=1; i<=N; i++) {
                if(P[i] == i) {
                    total++;
                }
            }

            System.out.println("#"+testCase + " " + total);
        }
    }
}
