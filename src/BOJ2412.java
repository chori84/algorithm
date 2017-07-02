import java.util.*;

public class BOJ2412 {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int T = sc.nextInt();

        int[] c = new int[n+1];
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(0, 0));

        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pointList.add(new Point(x, y));
        }

        pointList.sort((p1, p2) -> {
            if(p1.x == p2.x) return p1.y - p2.y;
            else return p1.x - p2.x;
        });

        Queue<Integer> q = new LinkedList<>();
        c[0] = 1;
        q.offer(0);
        int count = -1;

        while(q.peek() != null) {
            int index = q.poll();
            Point p = pointList.get(index);
            if(p.y == T) {
                count = c[index]-1;
                break;
            }

            for(int i=index+1; i<=n; i++) {
                if(Math.abs(pointList.get(i).x - p.x) <= 2) {
                    if(c[i] == 0 && Math.abs(pointList.get(i).y - p.y) <= 2) {
                        c[i] = c[index]+1;
                        q.offer(i);
                    }
                } else {
                    break;
                }
            }

            for(int i=index-1; i>0; i--) {
                if(Math.abs(pointList.get(i).x - p.x) <= 2) {
                    if(c[i] == 0 && Math.abs(pointList.get(i).y - p.y) <= 2) {
                        c[i] = c[index]+1;
                        q.offer(i);
                    }
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}