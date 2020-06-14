package amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        GreatestCommonDivisor test = new GreatestCommonDivisor();
        int[] arr = new int[]{6, 8, 10, 2, 4};
        int result = test.generalizedGCD(5, arr);
        System.out.println(result);
    }

    public int generalizedGCD(int num, int[] arr) {

        List<Integer> arrs = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(arrs);

        int result = 1;
        int max = arrs.get(0);
        for (int i = 1; i <= max; i++) {
            boolean flag = true;
            for (int j = 0; j < arrs.size(); j++) {
                if (arrs.get(j) % i > 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result = i;
            }
        }

        return result;
    }
}
