package java2novice.linkedlist;

import java.util.Stack;

public class IdentifyPalindromeList {
    public static void main(String[] a) {

        Node n1 = new Node(11);
        Node n2 = new Node(10);
        Node n3 = new Node(15);
        Node n4 = new Node(29);
        Node n5 = new Node(10);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        boolean result = isPalindrome(n1);
        System.out.println("Is it palindrome: " + result);
    }

    static class Node {
        int id;
        Node next;

        public Node(int id) {
            this.id = id;
        }
    }

    public static boolean isPalindrome(Node node) {
        boolean flag = false;
        if (node == null || node.next == null) {
            return false;
        }
        Node next = node.next;
        while (next.next != null) {
            next = next.next;
        }
        if (next.id == node.id) {
            flag = true;
        }
        return flag;
    }

    static boolean isPalindromeV2(Node head) {

        Node tempNode = head;

        // Stack is last-in-first-out
        Stack<Integer> stack = new Stack<Integer>();
        while(tempNode != null) {
            stack.push(tempNode.id);
            tempNode = tempNode.next;
        }
        while(head != null) {
            if(head.id != stack.pop()) {
                return Boolean.FALSE;
            }
            head = head.next;
        }

        return Boolean.TRUE;
    }
}
