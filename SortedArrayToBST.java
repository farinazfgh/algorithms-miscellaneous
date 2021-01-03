public class SortedArrayToBST {
    static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};


    static BinaryTreeNode head;

    static BinaryTreeNode sortedArrayToBST(int[] array, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        if (mid == array.length) return null;
        System.out.println("low:" + low + ", high:" + high + ", mid:" + mid);
        BinaryTreeNode node = new BinaryTreeNode(array[mid]);
        node.left = sortedArrayToBST(array, low, mid - 1);
        node.right = sortedArrayToBST(array, mid + 1, high);
        return node;
    }

    static void inOrder(BinaryTreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.data + " , ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode head = sortedArrayToBST(array, 0, array.length);
        inOrder(head);
        System.out.println();
    }
}
