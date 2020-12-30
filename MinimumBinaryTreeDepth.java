import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
Time complexity #
The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N) which is required for the queue.
 */
public class MinimumBinaryTreeDepth {

    static Set<Integer> levelOrderTraversal(Node root) {
        Set<Integer> allDepths = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize;
        int currentDepth = 0;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (isLeaf(currentNode)) allDepths.add(currentDepth);
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            currentDepth++;
        }
        return allDepths;
    }

    static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        System.out.println("Tree all Depths: " + MinimumBinaryTreeDepth.levelOrderTraversal(root));
        root.left.left = new Node(9);
        root.right.left.left = new Node(11);
        System.out.println("Tree all Depths: " + MinimumBinaryTreeDepth.levelOrderTraversal(root));
    }
}
