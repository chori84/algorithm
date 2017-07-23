import java.util.Scanner;

/**
 * Created by chori on 2017. 7. 23..
 */
public class BOJ2999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String encryptString = sc.next();
        int length = encryptString.length();

        int R = 0;
        int C = 0;
        for(int i=1; i*i<=length; i++) {
            if (length % i == 0) {
                int j = length / i;

                if(i <= j) {
                    R = i;
                    C = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder(length);
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                sb.append(encryptString.charAt(i + j*R));
            }
        }

        System.out.println(sb.toString());
    }
}
