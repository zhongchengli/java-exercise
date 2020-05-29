package java2novice.linkedlist;

/*
Write a simple code to identify loop or cycle in a linked list.

In general, the last node is null in a Linked list.
A loop/cycle exists in a LinkedList when no null is reached as we traverse throughout the LinkedList.
 */

import java.util.*;

public class IdentifyLoopInList {

    static class Node {
        int id;
        Node next;

        public Node(int id) {
            this.id = id;
        }
    }

    static boolean booleanidentifyLoopV1(Node node){
        Node slowMV = node;
        Node fastMV = node;
        while (slowMV != null && fastMV != null && fastMV.next!=null){
            slowMV = slowMV.next;
            fastMV = fastMV.next.next;
            if(slowMV == fastMV){
                return true;
            }
        }
        return false;
    }

    static boolean identifyLoopV2(Node node) {
        List<Node> set = new ArrayList<Node>();
        while (node != null) {
            if(set.contains(node)){
                return true;
            }else{
                set.add(node);
            }
            node = node.next;
        }
        return false;
    }

    public static void main(String[] a) {

        Node n1 = new Node(2);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(2);
        Node n5 = new Node(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        n5.next = n3;

        System.out.println("Is loop detected: " + booleanidentifyLoopV1(n1));
    }

}
