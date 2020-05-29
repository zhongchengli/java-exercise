package java2novice.array;

import java.io.*;
import java.util.*;

public class FindMaxRepeatWordInFile {

    static class MaxDuplicateWordCount {

        public Map<String, Integer> getWordCount(String fileName) {
            FileInputStream fis = null;
            DataInputStream dis = null;
            BufferedReader br = null;
            Map<String, Integer> wordMap = new HashMap<>();

            try {
                fis = new FileInputStream(fileName);
                dis = new DataInputStream(fis);
                br = new BufferedReader(new InputStreamReader(dis));
                String line = null;

                while ((line = br.readLine()) != null) {
                    // TODO: study StringTokenizer
                    StringTokenizer st = new StringTokenizer(line, " ");
                    while (st.hasMoreTokens()) {
                        String temp = st.nextToken().toLowerCase();
                        if (wordMap.containsKey(temp)) {
                            wordMap.put(temp, wordMap.get(temp) + 1);
                        } else {
                            wordMap.put(temp, 1);
                        }
                    }
                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return wordMap;
        }

        // TODO: study Map.Entry and Collections.sort
        public List<Map.Entry<String, Integer>> sortByValue(Map<String, Integer> wordMap) {
            Set<Map.Entry<String, Integer>> set = wordMap.entrySet();
            List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                    return (obj2.getValue()).compareTo(obj1.getValue());
                }
            });
            return list;
        }
    }

    public static void main(String a[]) {
        MaxDuplicateWordCount mdc = new MaxDuplicateWordCount();
        Map<String, Integer> wordMap = mdc.getWordCount("/home/jasonli/Desktop/Go/MyTestFile.txt");
        List<Map.Entry<String, Integer>> list = mdc.sortByValue(wordMap);
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " ==== " + entry.getValue());
        }
    }
}
