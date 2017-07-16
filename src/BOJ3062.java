import java.util.Scanner;

/**
 * Created by chori on 2017. 7. 16..
 */
public class BOJ3062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int test=0; test<testCase; test++) {
            char[] numArr1 = sc.next().toCharArray();
            char[] numArr2 = new char[numArr1.length];

            for(int i=0; i<numArr1.length; i++) {
                numArr2[numArr2.length - 1 - i] = numArr1[i];
            }

            int num1 = Integer.parseInt(new String(numArr1));
            int num2 = Integer.parseInt(new String(numArr2));

            char[] number = String.valueOf(num1 + num2).toCharArray();

            boolean isPalindrome = true;
            for(int i=0; i<number.length/2; i++) {
                if (number[i] != number[number.length - 1 - i]) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
