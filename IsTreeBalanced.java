import java.util.LinkedList;
import java.util.Queue;

public class IsTreeBalanced {
    static Node root;

    public static int heightRecursive(Node root) {
        if (root == null) {
            return 0;
        }

        // recur for left and right subtree and consider maximum depth
        return 1 + Math.max(heightRecursive(root.left), heightRecursive(root.right));
    }

    public static int heightIterative(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node front = null;
        int height = 0;

        // loop till queue is empty
        while (!queue.isEmpty()) {
            // calculate number of nodes in current level
            int size = queue.size();

            // process each node of current level and enqueue their
            // non-empty left and right child to queue
            while (size-- > 0) {
                front = queue.poll();

                if (front.left != null) {
                    queue.add(front.left);
                }

                if (front.right != null) {
                    queue.add(front.right);
                }
            }

            // increment height by 1 for each level
            height++;
        }

        return height;
    }

    static boolean isLeaf(Node node) {
        return node.right == null && node.left == null;
    }

    public static void main(String[] args) {
        root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.left.left.left = new Node(20);
        root.right.left = new Node(10);
        root.right.right = new Node(5);

    }

    boolean isBalanced(Node root) {
        if (root == null) return true;// Base case
        int heightDiff = heightRecursive(root.left) - heightRecursive(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else { // Recurse
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    int checkHeight(Node root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        // Pass error up
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        // Pass error up

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
            // Found error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    boolean isBalanced2(Node root) {

        return checkHeight(root) != Integer.MIN_VALUE;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
