public class SortedArrayToBST {
    static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    static class Node {
        final int data;

        public Node(int data) {
            this.data = data;
        }

        Node left;
        Node right;
    }

    static Node head;

    static Node sortedArrayToBST(int[] array, int low, int high) {
        if (low >= high) return null;
        int mid = (low + high) / 2;
        Node node = new Node(array[mid]);
        node.left = sortedArrayToBST(array, low, mid - 1);
        node.right = sortedArrayToBST(array, mid + 1, high);
        return node;
    }

    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.data + " , ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        Node head = sortedArrayToBST(array, 0, array.length);
        inOrder(head);
        System.out.println();
    }
}
