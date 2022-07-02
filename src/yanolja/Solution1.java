package yanolja;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {47, 1900, 1, 90, 45}));
    }
    public static int solution(int[] A) {
        return Arrays.stream(A)
                .filter(n -> (n < 100 && n > 9) || (n < -9 && n > -100))
                .sum();
    }
}
