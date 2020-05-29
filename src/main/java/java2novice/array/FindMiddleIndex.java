package java2novice.array;

/*
You are given an array of numbers. Find out the array index or position
where sum of numbers preceeding the index is equals to sum of numbers
succeeding the index.
 */

import java.util.ArrayList;
import java.util.List;

public class FindMiddleIndex {

    static Integer findMiddleIndex(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int index = arr.length / 2;

        while (index >= 0 && index <= arr.length) {
            if (list.contains(index)) {
                System.out.println("index =" + index);
                return null;
            }

            int preceding = 0;
            for (int i = 0; i < index; i++) {
                preceding += arr[i];
            }
            int succeeding = 0;
            for (int i = index; i < arr.length; i++) {
                succeeding += arr[i];
            }

            if (preceding == succeeding) {
                return index;
            } else {
                list.add(index);
            }

            if (preceding < succeeding) {
                index++;
            } else if (preceding > succeeding) {
                index--;
            }

        }
        return index;
    }

    public static void main(String a[]) {
        int[] num = {2, 4, 4, 2, 3, 5, 5, 4, 2};
        try {
            System.out.println("Starting from index 0, adding numbers till index "
                    + findMiddleIndex(num) + " and");
            System.out.println("adding rest of the numbers can be equal");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
