package kakao.test_220602.test2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY teamK
     *  2. INTEGER_ARRAY teamB
     *
     * teamK의 점수 기록, teamB의 점수 기록
     * teamB의 각 경기의 점수가 teamK의 경기 중 점수가 높거나 같은 경우의 수
     *
     * ex) teamK = [1,2,5,2,0,4,3], teamB = [1,5,4,2]
     * result = [2, 7, 6, 4]
     */

    public static List<Integer> solution(List<Integer> teamK, List<Integer> teamB) {
        // Write your code here
        Collections.sort(teamK);

        return teamB.stream()
                .map(score -> numberOfGames(teamK, score))
                .collect(toList());
    }

    public static int numberOfGames(List<Integer> teamK, int score) {
        int begin = 0;
        int end = teamK.size();

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (teamK.get(mid) <= score) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int teamKCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> teamK = IntStream.range(0, teamKCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int teamBCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> teamB = IntStream.range(0, teamBCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.solution(teamK, teamB);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

