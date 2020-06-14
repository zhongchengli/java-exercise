package java2novice.collection;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String args[]){
        int[] arr = new int[]{1,2,3,4,5,4,3,5,6,7,8,6,9};
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }

        set.forEach(val->System.out.print(val +", "));
    }
}
