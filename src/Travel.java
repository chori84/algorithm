import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Travel {
    static Map<Integer, Integer> countMap;
    static int[] travel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        countMap = new HashMap<>();
        travel = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<count; i++) {
            int tNumber = Integer.parseInt(st.nextToken());
            travel[i] = tNumber;

            if(countMap.get(tNumber) == null) {
                countMap.put(tNumber, 1);
            } else {
                countMap.put(tNumber, countMap.get(tNumber) + 1);
            }
        }

        System.out.println(goToStart(0));
    }

    public static int goToStart(int s) {
        int e = travel.length-1;

        if(s >= e) {
            return 0;
        }

        int total;

        if(countMap.get(travel[s]) > 1) {
            countMap.put(travel[s], countMap.get(travel[s])-1);
            int next = goToStart(s+1);
            countMap.put(travel[s], countMap.get(travel[s])+1);

            total = Math.min(next, goToEnd(s, e));
        } else {
            total = goToEnd(s, e);
        }

        return total;
    }

    public static int goToEnd(int s, int e) {
        if(s >= e) {
            return 0;
        }

        int total;
        if(countMap.get(travel[e]) > 1) {
            countMap.put(travel[e], countMap.get(travel[e])-1);
            total = goToEnd(s, e-1);
            countMap.put(travel[e], countMap.get(travel[e])+1);
        } else {
            total = e - s + 1;
        }

        return total;
    }
}
