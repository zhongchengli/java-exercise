package array;

import java.util.ArrayList;
import java.util.List;

public class findPairEqualSum {

    public static void main(String args[]) {

        int[] intArr = new int[]{2, 32, -12, 13, -3, 7, 18, 5, 81, 73, 44, 23, 15, 19, 170};

        List<int[]> test1 = findPairEqualSum(intArr, 20);
        for (int[] pair : test1) {
            System.out.println(pair[0] + " + " + pair[1]);
        }
    }

    //    How to find all pairs on integer array whose sum is equal to given number?
    private static List<int[]> findPairEqualSum(int[] intArr, int sum) {
        List<int[]> list = new ArrayList<int[]>();

        for (int i = 0; i < intArr.length; i++) {

            for (int j = i; j < intArr.length; j++) {

                if (intArr[i] + intArr[j] == sum) {
//                    System.out.println("intArr[i] = " + intArr[i]);
//                    System.out.println("intArr[j] = " + intArr[j]);
                    list.add(new int[]{intArr[i], intArr[j]});
                }
            }
        }
        return list;
    }

    // Sort array
    public static int[] sortArray(int[] array) {
        if (array.length == 0) {
            return array;
        } else {
            for (int i = 0; i < array.length; i++) {
                int minI = i;
                for (int j = i; j < array.length; j++) {
                    if (array[j] > array[minI]) {
                        minI = j;
                    }
                }
                int temp = array[minI];
                array[minI] = array[i];
                array[i] = temp;
            }
            return array;
        }
    }
}
