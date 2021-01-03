
public class ValidateBST {
    static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    static int index = 0;

    public static void main(String[] args) {
        SortedArrayToBST.Node root = SortedArrayToBST.sortedArrayToBST(array, 0, array.length);
        int[] array = new int[16];

        copyBST(array, root);

        for (int value : array) System.out.println(value + " , ");
        System.out.println(isSorted(array));
    }

    static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) return false;

        }
        return true;
    }

    static void copyBST(int[] array, SortedArrayToBST.Node node) {
        if (node == null) return;
        copyBST(array, node.left);
        array[index] = node.data;
        index++;
        copyBST(array, node.right);
    }

    boolean validateBST(SortedArrayToBST.Node n) {
        return validateBST(n, null, null);
    }

    boolean validateBST(SortedArrayToBST.Node current, Integer max, Integer min) {
        if (current == null) return true;
        if ((min != null && current.data <= min) || (max != null && current.data > max)) return false;
        return validateBST(current.left, current.data, min) && validateBST(current.right, max, current.data);
    }

    static BinaryTreeNode prev = null;

    public static boolean isBst(BinaryTreeNode root) {

        if (root == null) {
            return true;
        }

        if (!isBst(root.left)) {
            return false;
        }

        if (prev != null && prev.data >= root.data) {
            return false;
        }
        prev = root;

        return isBst(root.right);
    }

}


