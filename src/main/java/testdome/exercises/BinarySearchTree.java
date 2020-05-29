package testdome.exercises;

class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {
        boolean result = false;
        Node next = root;
        while (next != null) {
            if(next.value == value){
                result = true;
                break;
            }
            if (next.value > value) {
                next = next.left;
            }else {
                next = next.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        System.out.println(contains(n2, 3));
    }
}