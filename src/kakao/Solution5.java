package kakao;

import java.util.Arrays;

public class Solution5 {

    // b 숫자들로 만들 수 있는 경우의 수
    public static void main(String[] args) {

        find(1234, 1213);
    }

    public static long find(long a, long b) {
        String str = String.valueOf(b);
        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);

        long total = 1;
        for (int i = 1; i <= str.length(); i++) {
            total *= i;
        }

        char c = 'a';
        int number = 1;
        for (int i = 0; i < strArray.length; i++) {
            if(strArray[i] != c) {
                c = strArray[i];
            } else {
                number++;
            }
        }

        return total / number;
    }
}
