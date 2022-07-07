package kakao.test_220602.test3;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY infectedHouses
     *
     * 바이러스 문제
     * 턴 마다 바이러스가 바이러스가 양쪽 집에 전파 된다
     * 한번 걸린 집은 또 안걸림
     * n은 집의 최대값
     * infectedHouses는 바이러스 걸린 집의 번호들
     * 모든 경우의 수
     */

    public static int solution(int n, List<Integer> infectedHouses) {
        // Write your code here
        boolean[] currentIntectedHouses = new boolean[n+1];
        for(int index : infectedHouses) {
            currentIntectedHouses[index] = true;
        }

        long result = 1;
        int count;
        do {
            count = 0;
            List<Integer> newInfectedHouses = new ArrayList<>();
            for(int index : infectedHouses) {
                if(index < n) {
                    if(!currentIntectedHouses[index + 1]) {
                        currentIntectedHouses[index + 1] = true;
                        newInfectedHouses.add(index + 1);
                        count++;
                    }
                }

                if(index > 1) {
                    if(!currentIntectedHouses[index - 1]) {
                        currentIntectedHouses[index - 1] = true;
                        newInfectedHouses.add(index - 1);
                        count++;
                    }
                }
            }
            infectedHouses = newInfectedHouses;
            if(count > 0) {
                result *= factorial(count);
                result %= 1000000007;
            }
        } while(count > 0);

        return (int) result;
    }

    public static long factorial(long n) {
        if(n <= 1) {
            return n;
        } else {
            return n * factorial(n - 1) % 1000000007;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int infectedHousesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> infectedHouses = IntStream.range(0, infectedHousesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.solution(n, infectedHouses);

        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
