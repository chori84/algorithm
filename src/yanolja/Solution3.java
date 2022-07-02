package yanolja;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public static void main(String[] args) {
        solution(new int[]{60, 80, 40}, new int[]{2, 3, 5},5, 2, 200);
    }

    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        int count = 0;
        for(int current=0; current<A.length;) {
            Set<Integer> floors = new HashSet<>();
            int people = 0;
            int weight = 0;

            while(current<A.length && people < X && weight + A[current] < Y) {
                people++;
                weight += A[current];
                floors.add(B[current++]);
            }

            count += floors.size() + 1;
        }

        return count;
    }
}
