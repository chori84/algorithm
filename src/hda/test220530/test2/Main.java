package test220530.test2;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(1000, 1000, 5108));
    }
}

class Solution {
    public String solution(int left, int right, int offset) {
        String answer = "";

        String[] numberMap = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tenOverNumberMap = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        String text = "";

        while (text.length() < right) {
            char[] offsetText = String.valueOf(offset).toCharArray();

            for(int index = 0; index < offsetText.length; index++) {
                if(offsetText[index] == '1' && index != offsetText.length - 1) {
                    text += tenOverNumberMap[Character.getNumericValue(offsetText[++index])];
                } else {
                    text += numberMap[Character.getNumericValue(offsetText[index])];
                }
            }

            offset++;
        }

        answer = text.substring(left-1, right);

        return answer;
    }
}