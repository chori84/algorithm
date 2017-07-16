import java.util.Scanner;

/**
 * Created by chori on 2017. 7. 16..
 */
public class BOJ1712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        if (C - B <= 0) {
            System.out.println(-1);
        } else {
            int S = A / (C - B);

            System.out.println(S+1);
        }
    }
}
