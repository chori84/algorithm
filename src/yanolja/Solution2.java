package yanolja;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{80, 80, 1000000000, 80, 80, 80, 80, 80, 80, 123456789}));
    }
    public static int solution(int[] T) {
        int brothersCount = T.length/2;
        Map<Integer, Integer> numberCounts = new HashMap<>();
        ValueComparator vc = new ValueComparator(numberCounts);
        Map<Integer, Integer> sortedMap = new TreeMap<>(vc);

        for(int number : T) {
            numberCounts.put(number, numberCounts.getOrDefault(number, 0) + 1);
        }

        sortedMap.putAll(numberCounts);

        Set<Integer> numbers = new HashSet<>();
        numbers.addAll(numberCounts.keySet());

        for (Map.Entry<Integer,Integer> entry : sortedMap.entrySet()) {
            if(entry.getValue() > 1) {
                if(entry.getValue() > brothersCount) {
                    break;
                } else {
                    brothersCount -= (entry.getValue() - 1);
                }
            } else if(entry.getValue() == 1) {
                brothersCount -= 1;
                numbers.remove(entry.getKey());
            }

            if(brothersCount == 0) {
                break;
            }
        }

        return numbers.size();
    }
}

class ValueComparator implements Comparator<Integer> {
    Map<Integer, Integer> base;

    public ValueComparator(Map<Integer, Integer> base) {
        this.base = base;
    }

    public int compare(Integer a, Integer b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}