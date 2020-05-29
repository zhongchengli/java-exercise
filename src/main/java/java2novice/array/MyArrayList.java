package java2novice.array;

/*
Write a program to implement your own ArrayList class. It should
contain add(), get(), remove(), size() methods. Use dynamic array logic.
It should increase its size when it reaches threshold.
 */

import java.util.Arrays;

public class MyArrayList {

    private Object[] myStore;
    private int actSize = 0;

    public MyArrayList() {
        myStore = new Object[10];
    }

    public int size() {
        return actSize;
    }

    public Object get(int index) {
        if (index < actSize) {
            return myStore[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(Object obj) {
        if (myStore.length - actSize <= 5) {
            increaseListSize();
        }
        myStore[actSize++] = obj;
    }

    public Object remove(int index) {
        if (index >= actSize || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object removedObj = myStore[index];
        for (int i = index; i < actSize - 1; i++) {
            myStore[i] = myStore[i + 1];
        }
        myStore[actSize - 1] = null;
        actSize--;
        return removedObj;
    }

    private void increaseListSize() {
        myStore = Arrays.copyOf(myStore, myStore.length * 2);
        System.out.println("\nNew Length = " + myStore.length);
    }


    public static void main(String a[]) {
        MyArrayList mal = new MyArrayList();
        mal.add(Integer.valueOf(2));
        mal.add(Integer.valueOf(5));
        mal.add(Integer.valueOf(1));
        mal.add(Integer.valueOf(23));
        mal.add(Integer.valueOf(14));
        for (int i = 0; i < mal.size(); i++) {
            System.out.print(mal.get(i) + " ");
        }
        mal.add(Integer.valueOf(29));
        System.out.println("Element at Index 5:" + mal.get(5));
        System.out.println("List size: " + mal.size());
        System.out.println("Removing element at index 2: " + mal.remove(2));
        for (int i = 0; i < mal.size(); i++) {
            System.out.print(mal.get(i) + " ");
        }
    }

}
