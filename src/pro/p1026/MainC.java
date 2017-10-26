package pro.p1026;

import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test=1; test<=T; test++) {
            int n = sc.nextInt();
            int[][] result = new int[2][n];
            result[0][0] = 0;
            result[1][0] = 1;

            for(int i=1;i<n; i++) {
                result[0][i] = result[1][i-1];
                result[1][i] = result[0][i-1] + result[1][i-1];
            }

            int total = result[0][n - 1] + result[1][n - 1];

            System.out.println("#"+test+ " " + total);
        }
    }
}
