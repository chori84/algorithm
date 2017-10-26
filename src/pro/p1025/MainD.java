package pro.p1025;

import java.util.Arrays;
import java.util.Scanner;

public class MainD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test=1; test<=T; test++) {
            int N = sc.nextInt();
            int[] numbers = new int[N];
            int[] dp = new int[N];
            for(int i=0; i<N; i++) {
                numbers[i] = sc.nextInt();
            }

            for(int i=0; i<N; i++) {
                dp[i] = 1;
                for(int j=0; j<i; j++) {
                    if (numbers[j] < numbers[i] && dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }

            Arrays.sort(dp);

            System.out.println("#"+test+ " " + dp[N-1]);
        }
    }
}
