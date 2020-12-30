import java.util.*;

public class TreePathSum {
    static class Node {
        final int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static Map<Node, Node> parents = new HashMap<>();
    static Node root;
    static Stack<Node> stack = new Stack<>();
    static List<Node> leaves = new ArrayList<>();

    static void dfs() {
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.left != null) {
                stack.push(current.left);
                parents.put(current.left, current);

            }
            if (current.right != null) {
                stack.push(current.right);
                parents.put(current.right, current);

            }
            if (current.right == null && current.left == null) leaves.add(current);
        }
    }

    public static List<List<Integer>> getpathSums(int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        for (Node leaf : leaves) {
            List<Integer> currentPath = new ArrayList<>();
            if (getPathSum(leaf, currentPath) == sum) paths.add(currentPath);
        }
        return paths;
    }

    static int getPathSum(Node leaf, List<Integer> path) {
        int sum = leaf.data;
        path.add(leaf.data);
        Node parent = parents.get(leaf);
        while (parent != null) {
            sum += parent.data;
            path.add(parent.data);
            parent = parents.get(parent);
        }
        return sum;
    }


    public static boolean hasPath(Node root, int sum) {
        if (root == null)
            return false;

        // if the current node is a leaf and its value is equal to the sum, we've found a path
        if (root.data == sum && root.left == null && root.right == null)
            return true;

        // recursively call to traverse the left and right sub-tree
        // return true if any of the two recursive call return true
        return hasPath(root.left, sum - root.data) || hasPath(root.right, sum - root.data);
    }

    public static void main(String[] args) {
        root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        dfs();
        System.out.println("path: " + TreePathSum.getpathSums(23));
        System.out.println("path: " + TreePathSum.getpathSums(18));
        System.out.println("path: " + TreePathSum.getpathSums(28));
        System.out.println("path: " + TreePathSum.getpathSums(29));

        List<Integer> paths = new ArrayList<>();
        TreePathSum.hasPath(root, 23);
        System.out.println(paths);
        paths.clear();

        TreePathSum.hasPath(root, 18);
        System.out.println(paths);
        paths.clear();

        TreePathSum.hasPath(root, 28);
        System.out.println(paths);
        paths.clear();

        TreePathSum.hasPath(root, 29);
        System.out.println(paths);
        paths.clear();

    }
}
