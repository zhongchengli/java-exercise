package java2novice.collection;

import java.util.*;

public class OrderByMapValue {

    public static void main(String a[]) {

        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("java", 20);
        map.put("C++", 45);
        map.put("Java2Novice", 2);
        map.put("Unix", 67);
        map.put("MAC", 26);
        map.put("Why this kolavari", 93);

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
        // TODO: Collections sort
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
//        Collections.sort(list, (o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                // ASC
////                return o1.getValue().compareTo(o2.getValue());
//                // DESC
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " ==== " + entry.getValue());
        }
    }

}
