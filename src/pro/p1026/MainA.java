package pro.p1026;

import java.util.Scanner;

public class MainA {
    final static char[] word1 = {' ', 't', 'o', 'd', 'a', 'y'};
    final static char[] word2 = {' ', 't', 'o', 'm', 'o', 'r', 'r', 'o', 'w'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test=1; test<=T; test++) {
            String replyString = sc.next();
            char[] reply = new char[replyString.length()+1];
            for(int i=0; i<replyString.length(); i++) {
                reply[i + 1] = replyString.charAt(i);
            }

            int[][] dp1 = new int[word1.length][reply.length];
            int[][] dp2 = new int[word2.length][reply.length];

            for(int i=1; i<dp1.length; i++) {
                for(int j=1; j<dp1[i].length; j++) {
                    if(word1[i] == reply[j]) {
                        dp1[i][j] = dp1[i-1][j-1] + 1;
                    } else {
                        dp1[i][j] = Math.max(dp1[i][j - 1], dp1[i - 1][j]);
                    }
                }
            }

            for(int i=1; i<dp2.length; i++) {
                for(int j=1; j<dp2[i].length; j++) {
                    if(word2[i] == reply[j]) {
                        dp2[i][j] = dp2[i-1][j-1] + 1;
                    } else {
                        dp2[i][j] = Math.max(dp2[i][j - 1], dp2[i - 1][j]);
                    }
                }
            }

            System.out.print("#"+test+" ");
            if (dp1[word1.length - 1][reply.length - 1] == word1.length - 1) {
                System.out.println("today");
            } else if (dp2[word2.length - 1][reply.length - 1] == word2.length - 1) {
                System.out.println("tomorrow");
            } else {
                System.out.println("none");
            }
        }
    }
}
