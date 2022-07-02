package kakao;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int[] arr = new int[c];
        for (int i = 0; i < c; i++) {
            arr[i] = sc.nextInt();
        }
        int d = sc.nextInt();
        int[] r = hackerCards(arr, d);

        for(int n : r) {
            System.out.println(n);
        }
    }

    static int[] hackerCards(int[] collection, int d) {
        Arrays.sort(collection);

        int index = 0;
        int number = 1;

        List<Integer> resultList = new ArrayList<>();
        while(d >= number) {
            if(index >= collection.length) {
                d -= number;
                resultList.add(number++);
            } else {
                if(number == collection[index]) {
                    number++;
                    index++;
                } else {
                    d -= number;
                    resultList.add(number++);
                }
            }
        }

        return resultList.stream().mapToInt(i->i).toArray();
    }

    static int[] hackerCards2(int[] collection, int d) {
        List<Integer> numberList = new ArrayList<>();
        for (int number : collection) {
            numberList.add(number);
        }

        List<Integer> resultList = new ArrayList<>();
        int number = 1;
        while(d >= number) {
            if(!numberList.contains(number)) {
                d -= number;
                resultList.add(number++);
            } else {
                number++;
            }
        }

        return resultList.stream().mapToInt(i->i).toArray();
    }


}
