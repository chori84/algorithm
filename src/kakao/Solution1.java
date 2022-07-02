package kakao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    static String decode(String encoded) {
        String reverseString = new StringBuffer(encoded).reverse().toString();

        int index = 0;
        StringBuffer resultBuffer = new StringBuffer();
        while (index < reverseString.length()) {
            if(reverseString.charAt(index) == '1') {
                String stringNumber = new StringBuffer()
                        .append(reverseString.charAt(index++))
                        .append(reverseString.charAt(index++))
                        .append(reverseString.charAt(index++)).toString();
                int number = Integer.parseInt(stringNumber);

                resultBuffer.append((char)number);
            } else {
                String stringNumber = new StringBuffer()
                        .append(reverseString.charAt(index++))
                        .append(reverseString.charAt(index++)).toString();
                int number = Integer.parseInt(stringNumber);

                resultBuffer.append((char)number);
            }
        }

        return resultBuffer.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String arrCount = scanner.next();

        System.out.println(decode(arrCount));
    }
}
