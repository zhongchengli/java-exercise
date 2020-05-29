package java2novice.array;

/*
A perfect number is a positive integer that is equal to the sum
of its proper positive divisors, that is, the sum of its positive
divisors excluding the number itself. Equivalently, a perfect number
is a number that is half the sum of all of its positive divisors.
The first perfect number is 6, because 1, 2 and 3 are its proper
positive divisors, and 1 + 2 + 3 = 6. Equivalently, the number 6
is equal to half the sum of all its positive divisors:
		( 1 + 2 + 3 + 6 ) / 2 = 6.
 */

public class FindPerfectNumber {

    static class IsPerfectNumber {

        public static boolean isPerfectNumber(int value) {
            int[] arr = new int[value];

            int count = 0;

            for (int i = 1; i <= value; i++) {
                if (value % i == 0) {
                    arr[count] = i;
                    count++;
                }
            }
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + ", ");
                sum += arr[i];
            }
            if (sum % 2 == 0 && sum / 2 == value) {
                return true;
            }
            return false;
        }
    }

    public static void main(String a[]) {
        IsPerfectNumber ipn = new IsPerfectNumber();
        System.out.println("Is perfect number: " + ipn.isPerfectNumber(28));
    }
}
