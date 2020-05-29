package java2novice.linkedlist;

/*
Write a simple code to identify given LinkedList has a loop
and if loop is present then calculate the lenght of a loop.
Length of a loop is count of nodes with in the loop.
If loop is not present then it should return 0.
 */

import java.util.HashSet;
import java.util.Set;

public class FindLengthOfLoop {

    static class Node {
        int id;
        Node next;

        public Node(int id) {
            this.id = id;
        }
    }

    static int identifyLoopCount(Node node) {
        Node startNode = findNodeInLoop(node);
        Node temp = startNode;
        int count = 1;

        while (temp != null && temp.next != startNode){
            temp = temp.next;
            count++;
        }

        return count;
    }

    static Node findNodeInLoop(Node node) {
        Set<Node> set = new HashSet<>();

        Node temp = node;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            } else {
                set.add(temp);
                temp = temp.next;
            }
        }
        return null;
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

        System.out.println("Loop count: " + identifyLoopCount(n1));
    }
}
