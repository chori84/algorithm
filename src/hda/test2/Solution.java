package test2;

import java.util.*;

class Solution {

    public String solution(String[] registered_list, String new_id) {

        Map<String, List<Integer>> registeredMap = new HashMap<>();

        for (int registeredIndex = 0; registeredIndex < registered_list.length; registeredIndex++) {
            String S = "";
            String registeredId = registered_list[registeredIndex];
            char[] chars = registeredId.toCharArray();
            int index = 0;

            for (int i = 0; i < chars.length; i++) {
                int temp = (int) chars[i];

                if (temp >= 97 && temp <= 122) {
                    S += chars[i];
                } else {
                    index = i;
                    break;
                }
                index = i;
            }

            int N = 0;

            if(index < registeredId.length() - 1) {
                N = Integer.parseInt(registeredId.substring(index));
            }

            if (Objects.isNull(registeredMap.get(S))) {
                List<Integer> numberList = new ArrayList<>();
                numberList.add(N);
                registeredMap.put(S, numberList);
            } else {
                registeredMap.get(S).add(N);
            }
        }

        String S = "";

        char[] chars = new_id.toCharArray();
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            int temp = (int) chars[i];

            if (temp >= 97 && temp <= 122) {
                S += chars[i];
            } else {
                index = i;
                break;
            }
            index = i;
        }

        int N = 0;

        if(index < new_id.length() - 1) {
            N = Integer.parseInt(new_id.substring(index));
        }

        List<Integer> registeredNumberList = registeredMap.get(S);

        if (registeredNumberList == null) {
            return S + N;
        } else {

            while (registeredNumberList.contains(N)) {
                N++;
                new_id = S + N;
            }
        }

        return new_id;

    }


//    public String solution(String[] registered_list, String new_id) {
//        String answer = "";
//
//        List<String> registeredList = Arrays.asList(registered_list);
//
//        answer = new_id;
//        while (registeredList.contains(answer)) {
//            String S = "";
//            char[] chars = answer.toCharArray();
//
//            int index = 0;
//
//            for (int i = 0; i < chars.length; i++) {
//                int temp = (int) chars[i];
//
//                if (temp >= 97 && temp <= 122) {
//                    S += chars[i];
//                } else {
//                    index = i;
//                    break;
//                }
//            }
//
//            int number = 0;
//            if(index != 0) {
//                String N = answer.substring(index);
//                number = Integer.valueOf(N);
//            }
//
//            number++;
//            answer = S + number;
//
//        }
//
//        return answer;
//    }
}