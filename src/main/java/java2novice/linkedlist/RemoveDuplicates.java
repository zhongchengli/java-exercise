package java2novice.linkedlist;

// Write a program to remove duplicates from sorted linked list. The linked list can be sorted in any order.

public class RemoveDuplicates {

    static class Node {
        int id;
        Node next;

        public Node(int id) {
            this.id = id;
        }
    }

    static void printLinkedList(Node node) {
        Node next = node;
        while (next != null) {
            System.out.print(next.id + ", ");
            next = next.next;
        }
    }

    static Node sortList(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        Node[] nodes = new Node[count];
        count = 0;
        temp = head;
        while (temp != null) {
            nodes[count] = temp;
            temp = temp.next;
            count++;
        }

        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {
                if (nodes[i].id > nodes[j].id) {
                    Node min = nodes[j];
                    nodes[j] = nodes[i];
                    nodes[i] = min;
                }
            }
        }

        for (int i = 0; i < count - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        return nodes[0];
    }

    static void deleteDuplicates(Node node) {

        while (node != null) {
            if (node.next == null) {
                break;
            } else if (node.id == node.next.id) {
                node.next = node.next.next;
            }
            node = node.next;
        }
    }

    public static void main(String[] a) {

        Node n1 = new Node(29);
        Node n2 = new Node(45);
        Node n3 = new Node(23);
        Node n4 = new Node(22);
        Node n5 = new Node(45);
        Node n6 = new Node(29);
        Node n7 = new Node(54);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.print("Initial linked list data: ");
        printLinkedList(n1);
        n1 = sortList(n1);
        deleteDuplicates(n1);
        System.out.println();
        System.out.print("Linked list data after removing duplicates: ");
        printLinkedList(n1);
    }
}
