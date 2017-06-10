import java.util.Scanner;

public class BOJ1849 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int size = (int) Math.pow(2, h + 1) - 1;

        int[] nums = new int[N + 1];
        int[] tree = new int[size + 1];
        for(int i=0; i<N; i++) {
            nums[i] = sc.nextInt();
            update(tree, 1, 0, N - 1, i, 1);
        }

        int[] ans = new int[N + 1];
        for(int i=0; i<N; i++) {
            int index = getIndex(tree, 1, 0, N - 1,nums[i] + 1);
            ans[index + 1] = i + 1;
        }

        for(int i=1; i<=N; i++) {
            System.out.println(ans[i]);
        }

    }

    public static void update(int[] tree, int node, int start, int end, int index, int diff) {
        if (index < start || index > end) {
            return;
        }

        tree[node] += diff;

        if (start != end) {
            update(tree, node * 2, start, (start + end) / 2, index, diff);
            update(tree, node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
        }
    }

    public static int getIndex(int[] tree, int node, int start, int end, int value) {
        if (start == end) {
            tree[node]--;
            return start;
        }

        int index = -1;

        if (tree[node * 2] >= value) {
            index = getIndex(tree, node * 2, start, (start + end) / 2, value);
        } else {
            index = getIndex(tree, node * 2 + 1, (start + end) / 2 + 1, end, value - tree[node * 2]);
        }

        tree[node]--;

        return index;
    }
}
