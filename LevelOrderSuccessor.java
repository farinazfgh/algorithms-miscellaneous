import java.util.LinkedList;
import java.util.Queue;


class LevelOrderSuccessor {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int x) {
            val = x;
        }
    }

    public static Node findSuccessor(Node root, int key) {
        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);

            if (currentNode.val == key)
                break;
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        Node result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}
