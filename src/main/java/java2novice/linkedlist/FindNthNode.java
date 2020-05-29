package java2novice.linkedlist;

public class FindNthNode {

    static class Node {
        int id;
        Node next;

        public Node(int id) {
            this.id = id;
        }
    }

    static Node findNthNodeFromLastV2(Node head, int th) {
//        Node result = node;
//        while (th-- > 1 && result != null) {
//            result = result.next;
//        }
//        return result;
        int length = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        System.out.println("length: " + length);
        for (int i = 0; i < length - th; i++) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] a) {

        Node n1 = new Node(23);
        Node n2 = new Node(29);
        Node n3 = new Node(69);
        Node n4 = new Node(85);
        Node n5 = new Node(40);
        Node n6 = new Node(45);
        Node n7 = new Node(54);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        Node nthNode = findNthNodeFromLastV2(n1, 6);
        System.out.println("Nth node value: " + nthNode.id);
    }
}
