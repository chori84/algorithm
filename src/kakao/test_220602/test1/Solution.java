package kakao.test_220602.test1;

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
     *  1. INTEGER X
     *  2. INTEGER_ARRAY arr
     *  3. INTEGER_ARRAY indexes
     *
     * X에 찾을 숫자 받음
     * arr에 여러 숫자 컬렉션을 받음 (ex. [1,2,3,3,5,1,2,6,4]
     * indexes에 몇번째 값을 찾을지 받음 (ex. [1, 100, 5, 4]
     *
     * X 값이 arr에서 indexes의 요소 번째 있을 때 arr에서의 위치
     * 없을 경우 -1
     *
     * ex) X = 8, arr = [1,2,3,8,5,2,8,1,8], indexes = [100, 1, 3]
     * result = [-1, 4, 9]
     */

    public static List<Integer> solution(int X, List<Integer> arr, List<Integer> indexes) {
        // Write your code here
        List<Integer> xIndexes = new ArrayList<>();

        for(int index = 0; index < arr.size(); index++) {
            if(arr.get(index) == X) {
                xIndexes.add(index + 1);
            }
        }

        return indexes.stream().map(index -> {
            if(index > xIndexes.size()) {
                return -1;
            } else {
                return xIndexes.get(index - 1);
            }
        }).collect(toList());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int indexesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> indexes = IntStream.range(0, indexesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.solution(X, arr, indexes);

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
