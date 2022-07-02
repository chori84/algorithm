package yanolja;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution4 {
    static Set<Integer> numSet = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(solution(0));
    }

    public static int solution(int N) {
        if(N == 0) {
            return 1;
        }

        int[] numbers = new int[(int)(Math.log10(N)+1)];

        if(numbers.length == 1) {
            return 1;
        }

        for(int i=0; i<numbers.length; i++) {
            numbers[numbers.length-i-1] = N % 10;
            N /= 10;
        }

        perm(numbers, 0, numbers.length, numbers.length);

        return numSet.size();
    }

    public static void perm(int[] arr, int depth, int n, int k) {
        if (depth == k) {
            print(arr,k);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth); }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr, int k) {
        if(arr[0] == 0) {
            return;
        }
        int number = 0;
        for (int i = 0; i < k; i++) {
            number += (arr[i] * Math.pow(10, k-i-1));
        }

        numSet.add(number);
    }
}
