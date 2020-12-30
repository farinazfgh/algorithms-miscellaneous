import java.util.*;

public class TreePathSum {
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
            if (isLeaf(current)) leaves.add(current);
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

        // if the current node is a leaf and its dataue is equal to the sum, we've found a path
        if (isLeaf(root) && root.data == sum)
            return true;

        // recursively call to traverse the left and right sub-tree
        // return true if any of the two recursive call return true
        return hasPath(root.left, sum - root.data) || hasPath(root.right, sum - root.data);
    }

    private static void findPathsRecursive(
            Node currentNode
            , int sum
            , Stack<Integer> currentPath
            , List<List<Integer>> allPaths) {

        if (currentNode == null)
            return;

        currentPath.push(currentNode.data);

        if (isLeaf(currentNode) && currentNode.data == sum) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            findPathsRecursive(currentNode.left, sum - currentNode.data, currentPath, allPaths);
            findPathsRecursive(currentNode.right, sum - currentNode.data, currentPath, allPaths);
        }

        // we are done with the current node and we want to backtrack so exclude it, no matter whether it is a leaf or not
        currentPath.pop();
    }

    private static boolean isLeaf(Node currentNode) {
        return currentNode.left == null && currentNode.right == null;
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

        List<List<Integer>> allPaths = new ArrayList<>();
        Stack<Integer> currentPath = new Stack<>();
        TreePathSum.findPathsRecursive(root, 23, currentPath, allPaths);
        System.out.println("path: " + allPaths);
        allPaths.clear();

        TreePathSum.findPathsRecursive(root, 18, currentPath, allPaths);
        System.out.println("path: " + allPaths);
        allPaths.clear();

        TreePathSum.findPathsRecursive(root, 28, currentPath, allPaths);
        System.out.println("path: " + allPaths);
        allPaths.clear();

        TreePathSum.findPathsRecursive(root, 29, currentPath, allPaths);
        System.out.println("path: " + allPaths);
        allPaths.clear();


    }

    static class Node {
        final int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
