package macquariebank;

public class InterviewTest2 {
    public static void main(String args[]) {
        /*
        Second question is you are given an array on integers and another number(t).
        Then you should get a number from the array,
        divide it by 2 and get ceil value of it and replace the original number in the array.
        This operation should be done t time such that sum of the array becomes minimal.
         */
        int[] intArr = new int[]{2,32,11,13,3,7,33,57,81,73,44,23,27,19,170};



//        printArray(intArr);

//        printArray(sortArray(intArr));


        int t = 5;

        int y = 0;


        int[] sortedArr = sortArray(intArr);
        int x = 0;
        while (x < t) {
            sortedArr = ceilArray(sortedArr);
            System.out.println("x = " + x);
            printArray(sortedArr);
            x++;
        }


//        for (int i = 1;  i <= 5; i++) {
//            int[] myArr;
//            int[] sortedArr = sortArray(intArr);
//
//        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ": " + array[i]);
        }
    }

    public static int[] ceilArray(int[] array) {
        int x = (int) Math.ceil(sortArray(array)[0] / 2);
        array[0] = x;
        return sortArray(array);
    }

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
