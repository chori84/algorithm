package test2;

import java.util.*;

public class Solution2 {
    class IdNumber {
        boolean[] nArr = new boolean[1000000];
    }

    public String solution(String[] registered_list, String new_id) {
        Map<String, Boolean[]> registeredMap = new HashMap<>();

        for (int i = 0; i < registered_list.length; i++) {
            String registered = registered_list[i];
            String s = registered.replaceAll("[0-9]", "");
            String n = registered.replaceAll("[^0-9]", "");

            int number = 0;
            if (n != null && !"".equals(n)) {
                number = Integer.parseInt(n);
            }

            if (registeredMap.get(s) == null) {
                Boolean[] nArr = new Boolean[1000000];
                nArr[number] = true;

                registeredMap.put(s, nArr);
            } else {
                registeredMap.get(s)[number] = true;
            }
        }

        String S = new_id.replaceAll("[0-9]", "");
        String N = new_id.replaceAll("[^0-9]", "");

        int number = 0;

        if(N != null && !"".equals(N)) {
            number = Integer.parseInt(N);
        }

        Boolean[] registeredNumberArray = registeredMap.get(S);

        if (registeredNumberArray == null) {
            return new_id;
        } else {
            while (true) {
                if (registeredNumberArray[number] == null) {
                    if(number == 0) {
                        return S;
                    } else {
                        return S + number;
                    }
                } else {
                    number++;
                }
            }
        }
    }
}
