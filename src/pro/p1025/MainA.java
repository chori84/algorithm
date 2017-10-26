package pro.p1025;

import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test=1; test<=T; test++) {
            int N = sc.nextInt();
            int D = sc.nextInt();

            int result = 1;
            for(int i=1; i<=N; i++) {
                result *= i;
                result %= D;
            }

            System.out.println("#"+test+" " + result);
        }
    }
}
