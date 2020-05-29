package java2novice.array;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatedNumber {

    static class DuplicateNumber {
        public static String findDuplicateNumber(List<Integer> numbers) {
            List<Integer> duplicates = new ArrayList<>();
            for (int i = 0; i < numbers.size(); i++) {
                int number = numbers.get(i).intValue();
                for (int j = i + 1; j < numbers.size(); j++) {
                    if (number == numbers.get(j).intValue()) {
                        if (!duplicates.contains(numbers.get(j))) {
                            duplicates.add(numbers.get(j));
                        }
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Integer obj : duplicates) {
                sb.append(obj.intValue() + ", ");
            }
            return sb.toString();
        }
    }

    public static void main(String a[]) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < 30; i++) {
            numbers.add(i);
        }
        //add duplicate number into the list
        numbers.add(22);
        numbers.add(22);
        numbers.add(5);
        numbers.add(18);
        DuplicateNumber dn = new DuplicateNumber();
        System.out.println("Duplicate Number: " + dn.findDuplicateNumber(numbers));
    }
}
