package test220530.test1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String[] emails = {"abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"};
        System.out.println(new Solution().solution(emails));
    }
}

class Solution {
    public int solution(String[] emails) {
        int answer = 0;

        Pattern emailPattern = Pattern.compile("^[a-z|.]+@[a-z]+.[com|net|org]+$");

        for (int index = 0; index < emails.length; index++) {
            Matcher emailMatcher = emailPattern.matcher(emails[index]);
            if(emailMatcher.matches()) {
                answer++;
            }
        }

        return answer;
    }
}
