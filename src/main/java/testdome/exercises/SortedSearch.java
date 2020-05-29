package testdome.exercises;


import java.util.*;
import java.util.stream.Collectors;

/*
Implement function countNumbers that accepts a sorted array of unique integers and,
efficiently with respect to time used,
counts the number of array elements that are less than the parameter lessThan.

For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two array elements less than 4.
 */

// TODO: https://www.testdome.com/questions/java/sorted-search/36030?visibility=3&skillId=4

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {

        List<Integer> list = Arrays.stream(sortedArray).boxed().collect(Collectors.toList());
        if (list.indexOf(lessThan) > -1) {
            return list.indexOf(lessThan);
        } else {
            list.add(Integer.valueOf(lessThan));
            Collections.sort(list);
            return list.indexOf(lessThan);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = i;
        }
        System.out.println(SortedSearch.countNumbers(arr, 10000));
    }
}
