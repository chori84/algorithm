package pro.p1023;

import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int testCase=1; testCase<=test; testCase++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] tree = new int[N*4];

            for(int i=1; i<=N; i++) {
                int number = sc.nextInt();
                update(tree, 1, 1, N, i, number);
            }

            int max = 0;
            for(int i=0; i<M; i++) {
                int left = sc.nextInt()+1;
                int right = sc.nextInt()+1;
                int sum = sum(tree, 1, 1, N, left, right);

                if (sum > max) {
                    max = sum;
                }
            }

            System.out.println("#"+testCase+" "+ max);
        }
    }

    public static void update(int[] arr, int node, int start, int end, int target, int diff) {
        if(start > target || end < target) {
            return;
        }

        arr[node] += diff;

        if (start != end) {
            int mid = (start+end) / 2;
            update(arr, node*2, start, mid, target, diff);
            update(arr, node * 2 + 1, mid + 1, end, target, diff);
        }
    }

    public static int sum(int[] arr, int node, int start, int end, int left, int right) {
        if(right < start || left > end) {
            return 0;
        }

        if(start >= left && end <= right) {
            return arr[node];
        }

        int mid = (start+end) / 2;
        return sum(arr, node * 2, start, mid, left, right) + sum(arr, node*2+1, mid+1, end, left, right);
    }
}
