public class IsTreeBalanced {
    static class Node {
        int data;
        MinimumBinaryTreeDepth.Node left;
        MinimumBinaryTreeDepth.Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MinimumBinaryTreeDepth.Node root = new MinimumBinaryTreeDepth.Node(12);
        root.left = new MinimumBinaryTreeDepth.Node(7);
        root.right = new MinimumBinaryTreeDepth.Node(1);
        root.right.left = new MinimumBinaryTreeDepth.Node(10);
        root.right.right = new MinimumBinaryTreeDepth.Node(5);

    }
}
