package java2novice.array;

public class TwoMaxNumbers {

    public void printTwoMaxNumbers(int[] arr) {
        int maxOne = 0;
        int maxTwo = 0;
        for (int num : arr) {
            if (maxOne < num) {
                maxTwo = maxOne;
                maxOne = num;
            } else if (maxTwo < num) {
                maxTwo = num;
            }
        }
        System.out.println("maxOne = " + maxOne);
        System.out.println("maxTwo = " + maxTwo);
    }

    public static void main(String a[]) {
        int num[] = {5, 34, 78, 2, 45, 1, 99, 23};
        TwoMaxNumbers tmn = new TwoMaxNumbers();
        tmn.printTwoMaxNumbers(num);
    }
}
