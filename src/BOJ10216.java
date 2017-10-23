import java.util.Scanner;

public class BOJ10216 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int testCase=1; testCase<=test; testCase++) {
            int N = sc.nextInt();

            double[][] map = new double[N][3];
            int[] group = new int[N];

            for(int i=0; i<N; i++) {
                group[i] = i;
            }

            for(int i=0; i<N; i++) {
                double x = sc.nextInt();
                double y = sc.nextInt();
                double R = sc.nextInt();

                map[i][0] = x;
                map[i][1] = y;
                map[i][2] = R;
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<i; j++) {
                    int s = i;
                    int e = j;

                    double ix = map[i][0];
                    double iy = map[i][1];
                    double iR = map[i][2];

                    double jx = map[j][0];
                    double jy = map[j][1];
                    double jR = map[j][2];

                    double length = Math.sqrt((jx - ix) * (jx - ix) + (jy - iy) * (jy - iy));
                    if(iR + jR >= length) {
                        while(group[s] != s) {
                            s = group[s];
                        }

                        if(group[e] == e) {
                            group[e] = s;
                        } else {
                            int temp = group[e];
                            while (group[temp] != temp) {
                                int temp2 = group[temp];
                                group[temp] = s;
                                temp = temp2;
                            }
                            group[temp] = s;
                            group[e] = s;
                        }
                    }
                }
            }

            int count = 0;
            for(int i=0; i<N; i++) {
                if (group[i] == i) {
                    count++;
                }
            }

            System.out.println(count);

        }
    }
}
