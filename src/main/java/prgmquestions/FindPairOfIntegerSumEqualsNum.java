package prgmquestions;

import java.util.HashMap;
import java.util.Map;

public class FindPairOfIntegerSumEqualsNum {


    static void findPair(int[] arr, int num) {
        Map<Integer, Integer> pair = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (pair.containsKey(arr[i])) {
                continue;
            }
            int x = num - arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (x == arr[j]) {
                    pair.put(arr[j], arr[i]);
                    break;
                }
            }
        }

        pair.forEach((key, value) -> System.out.println(key + " and " + value));
    }

    public static void main(String args[]) {
        int[] arr = new int[]{3, 5, 8, 2, 4, 9, 2, -12, 11, 7};
        findPair(arr, 10);
    }
}
