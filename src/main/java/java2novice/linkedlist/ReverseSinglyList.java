package java2novice.linkedlist;

/*
Write a sample code to reverse Singly Linked List by iterating through it only once.
 */


public class ReverseSinglyList {

    static class SinglyLinkedListImpl<T> {
        private Node<T> head;

        public void add(T element) {
            Node<T> node = new Node<T>();
            node.setValue(element);
            Node<T> temp = head;
            while (true) {
                if (temp == null) {
                    head = node;
                    break;
                } else if (temp.getNext() == null) {
                    temp.setNext(node);
                    break;
                } else {
                    temp = temp.getNext();
                }
            }
        }

        public void traverse() {
            Node<T> temp = head;
            while (temp != null) {
                System.out.print(temp.getValue() + "\t");
                temp = temp.getNext();
            }
        }

        public void reverse(){
            System.out.println("\nreversing the linked list\n");
            Node<T> pre = null;
            Node<T> cur = head;
            Node<T> next = null;
            while (cur!=null){
               next = cur.getNext();
               cur.setNext(pre);
               pre = cur;
               cur = next;
            }
            head = pre;
        }
    }

    static class Node<T> implements Comparable<T> {
        private T value;
        private Node<T> next;

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        @Override
        public int compareTo(T t) {
            if (t == this.value) {
                return 0;
            } else {
                return 1;
            }
        }
    }


    public static void main(String a[]) {
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        System.out.println();
        sl.traverse();
        System.out.println();
        sl.reverse();
        sl.traverse();
    }
}
