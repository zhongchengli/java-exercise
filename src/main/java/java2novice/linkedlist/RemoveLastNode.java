package java2novice.linkedlist;

// Write a program to delete last node from the given Linked List.

public class RemoveLastNode {
    static class Node {
        int id;
        Node next;

        Node(int id) {
            this.id = id;
        }

    }

    static Node removeLastNode(Node node) {
        if (node == null || node.next == null) {
            return null;
        }
        Node next = node;
        while (next.next.next != null) {
            next = next.next;
        }
        next.next = null;
        return node;
    }

    static void printLinkedList(Node node) {
        while (node != null) {
            System.out.print(node.id + ", ");
            node = node.next;
        }
    }

    public static void main(String[] a) {


        Node n1 = new Node(23);
        Node n2 = new Node(29);
        Node n3 = new Node(29);
        Node n4 = new Node(45);
        Node n5 = new Node(45);
        Node n6 = new Node(45);
        Node n7 = new Node(54);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.print("Initial linked list : ");
        printLinkedList(n1);
        n1 = removeLastNode(n1);
        n1 = removeLastNode(n1);
        n1 = removeLastNode(n1);
        System.out.println();
        System.out.print("Linked list after removing last node: ");
        printLinkedList(n1);
    }
}
