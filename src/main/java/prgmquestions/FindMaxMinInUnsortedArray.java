package prgmquestions;

// How do you find the largest and smallest number in an unsorted integer array?

public class FindMaxMinInUnsortedArray {

    static void findMaxMin(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }

        }
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
    }


    public static void main(String args[]) {
        int[] arr = new int[]{6, 3, 8, 6, 5, 30, 23};
        findMaxMin(arr);
    }
}
