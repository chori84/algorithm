package test2;

public class Solution3 {
    public String solution(String[] registered_list, String new_id) {
        boolean[] nArr = new boolean[1000000];

        String newS = new_id.replaceAll("[0-9]", "");
        String newN = new_id.replaceAll("[^0-9]", "");

        for (int i = 0; i < registered_list.length; i++) {
            String registered = registered_list[i];
            String registeredS = registered.replaceAll("[0-9]", "");
            String registeredN = registered.replaceAll("[^0-9]", "");

            int number = 0;
            if (registeredN != null && !"".equals(registeredN)) {
                number = Integer.parseInt(registeredN);
            }

            if(newS.equals(registeredS)) {
                nArr[number] = true;
            }
        }

        int number = 0;

        if(newN != null && !"".equals(newN)) {
            number = Integer.parseInt(newN);
        }

        while (true) {
            if (nArr[number]) {
                number++;
            } else {
                if(number == 0) {
                    return newS;
                } else {
                    return newS + number;
                }
            }
        }
    }
}
