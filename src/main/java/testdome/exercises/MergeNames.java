package testdome.exercises;

/*
Implement the uniqueNames method. When passed two arrays of names, it will return an array containing the names that appear in either or both arrays. The returned array should have no duplicates.

For example, calling MergeNames.uniqueNames(new String[]{'Ava', 'Emma', 'Olivia'}, new String[]{'Olivia', 'Sophia', 'Emma'}) should return an array containing Ava, Emma, Olivia, and Sophia in any order.
 */

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        String[] temp = new String[names1.length + names2.length];
        int count = 0;
        int total = names1.length + names2.length;

        for (int i = 0; i < names1.length; i++) {
            temp[i] = names1[i];
            count++;
        }
        for (int i = 0; i < names2.length; i++) {
            temp[count++] = names2[i];
        }

        while (count-- > 0) {
            for (int i = 0; i < count; i++) {
                if (temp[count] == null) {
                    break;
                }
                if (temp[i] == temp[count]) {
                    temp[i] = null;
                    total--;
                }
            }
        }
        String[] result = new String[total];
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                result[index++] = temp[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
        String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}