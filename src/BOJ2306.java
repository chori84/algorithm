import java.util.Scanner;

/**
 * Created by chori on 2017. 7. 30..
 */
public class BOJ2306 {
    static char[] strArr;
    static int[][] D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        strArr = sc.next().toCharArray();

        D = new int[strArr.length][strArr.length];

        for(int i=0; i<D.length; i++) {
            for(int j=0; j<D[i].length; j++) {
                D[i][j] = -1;
            }
        }

        System.out.println(dp(0, D.length-1));
    }

    public static int dp(int s, int e) {
        if (s >= e) {
            return 0;
        }
        if(D[s][e] > -1) {
            return D[s][e];
        }

        int cnt = 0;

        if (strArr[s] == 'a' && strArr[e] == 't') {
            cnt = Math.max(cnt, dp(s + 1, e - 1) + 2);
        }
        if (strArr[s] == 'g' && strArr[e] == 'c') {
            cnt = Math.max(cnt, dp(s + 1, e - 1) + 2);
        }

        for(int i=s; i<e; i++) {
            cnt = Math.max(cnt, dp(s, i) + dp(i + 1, e));
        }

        D[s][e] = cnt;

        return D[s][e];
    }
}
