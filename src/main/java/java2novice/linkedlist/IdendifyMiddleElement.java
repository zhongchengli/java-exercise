package java2novice.linkedlist;

// Write a simple code to identify middle element from given linked list.

public class IdendifyMiddleElement {

    static class Node {
        int id;
        Node next;

        public Node(int id) {
            this.id = id;
        }
    }

    static void findMiddleElementV2(Node node) {
        if (node == null) {
            System.out.println(0);
        } else {
            int count = 1;
            Node next = node;
            while (next.next != null) {
                next = next.next;
                count++;
                System.out.println("current node *** = " + next.id);
            }
            if (count % 2 == 0) {
                System.out.println("No middle node");
                return;
            }
            int middle = count / 2;
            System.out.println("middle = " + middle);
            Node temp = node;
            int i = 1;
            while (i++ <= middle) {
                temp = temp.next;
                System.out.println("current temp = " + temp.id);
            }
            System.out.println("Middle node = " + temp.id);
        }
    }

    public static void main(String a[]) {

        Node n1 = new Node(10);
        Node n2 = new Node(29);
        Node n3 = new Node(20);
        Node n4 = new Node(25);
        Node n5 = new Node(10);
        Node n6 = new Node(11);
        Node n7 = new Node(21);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        findMiddleElementV2(n1);
    }
}
