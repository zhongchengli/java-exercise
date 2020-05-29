package java2novice.array;

/*
Write a program to find out duplicate or repeated characters in a
string, and calculate the count of repeatation.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharsInString {

    static void findDuplicateChars(String str) {
        Map<Character, Integer> dup = new HashMap<Character, Integer>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (dup.containsKey(arr[i])) {
                dup.put(arr[i], dup.get(arr[i]) + 1);
            } else {
                dup.put(arr[i], 1);
            }
        }

        Set<Character> keys = dup.keySet();
        for (Character ch : keys) {
            if (dup.get(ch) > 1) {
                System.out.println(ch + " -->" + dup.get(ch));
            }
        }
    }

    public static void main(String a[]) {
        DuplicateCharsInString dcs = new DuplicateCharsInString();
        dcs.findDuplicateChars("Java2Novice");
    }
}
