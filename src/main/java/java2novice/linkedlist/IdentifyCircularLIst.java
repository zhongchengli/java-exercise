package java2novice.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IdentifyCircularLIst {

    static class Node {
        int id;
        Node next;

        public Node(int id) {
            this.id = id;
        }
    }

    static boolean isCircularLinkedList(Node head) {
        Set<Node> set = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return (temp == head);
            }
            set.add(temp);
            temp = temp.next;

        }
        return false;
    }


    public static void main(String[] a) {

        Node n1 = new Node(34);
        Node n2 = new Node(25);
        Node n3 = new Node(31);
        Node n4 = new Node(56);
        Node n5 = new Node(45);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n1;

        System.out.println("Is it circular linked list: " + isCircularLinkedList(n1));
    }
}
