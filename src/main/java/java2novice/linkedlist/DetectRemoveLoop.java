package java2novice.linkedlist;

/*
Write a program to identify given linked list contains loop or not.
If loop exists, then remove the loop.
 */

import java.util.HashSet;
import java.util.Set;

public class DetectRemoveLoop {

    static class Node {
        int id;
        Node next;

        public Node(int id) {
            this.id = id;
        }
    }

    static void printLinkedList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.id + ", ");
            temp = temp.next;
        }
    }

    static String identifyAndDeleteLoop(Node node) {
        Set<Node> set = new HashSet<>();
        Node loop = null;
        Node temp = node;
        while (temp != null) {
            if (set.contains(temp)) {
                loop = temp;
                break;
            } else {
                set.add(temp);
                temp = temp.next;
            }
        }
        StringBuilder sb = new StringBuilder();
        Node tempLoop = loop;
        while (tempLoop != null && tempLoop.next != loop) {
            sb.append(tempLoop.id + ", ");
            tempLoop = tempLoop.next;
        }
        sb.append(temp.id);

        if (loop != null) {
            removeLoop(node, loop);
        }

        return sb.toString();
    }

    static void removeLoop(Node head, Node loop) {
        Node temp = head;
        while (temp != null && temp.next != loop) {
            temp = temp.next;
        }
        temp.next = null;
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
        n5.next = n3;

        System.out.println("Loop detected: " + identifyAndDeleteLoop(n1));
        printLinkedList(n1);
    }
}
