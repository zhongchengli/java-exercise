package java2novice.array;

public class ReverseString {

    static class StringRecursiveReversal {

        String reverse = "";

        public String reverseString(String str) {
//            if (str == null || str.trim().length() == 0) {
//                return null;
//            }
//            StringBuilder sb = new StringBuilder();
//            int n = str.trim().length();
//            for (int i = 0; i < n; i++) {
//                sb.append(str.charAt(n - 1 - i));
//            }
//            return sb.toString();

//            System.out.println(str);
            if(str.length() == 1){
                return str;
            } else {
                reverse += str.charAt(str.length()-1)
                        +reverseString(str.substring(0,str.length()-1));
                System.out.println(reverse);
                return reverse;
            }
        }
    }

    public static void main(String a[]) {
        StringRecursiveReversal srr = new StringRecursiveReversal();
        System.out.println("Result: " + srr.reverseString("Java2novice"));
    }
}
