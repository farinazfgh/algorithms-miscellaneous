import java.util.HashSet;
import java.util.Set;

//all inorder, preorder and post order traversals are DFS they all go deep before they go wide
//and they are all recursive which means they use stack (program stack)

public class TreeTraversal {
    static class Node {
        final int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node root;

    static void inOrder(Node current, int index, Set<Integer> listOfDepths) {
        if (current == null) return;
        if (isLeaf(current)) listOfDepths.add(index);

        inOrder(current.left, index + 1, listOfDepths);
        System.out.print(current.data + " , ");
        inOrder(current.right, index + 1, listOfDepths);
    }

    static void preOrder(Node current, int index, Set<Integer> listOfDepths) {
        if (current == null) return;
        if (isLeaf(current)) listOfDepths.add(index);

        System.out.print(current.data + " , ");
        preOrder(current.left, index + 1, listOfDepths);
        preOrder(current.right, index + 1, listOfDepths);

    }

    static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);

    }

    static void postOrder(Node current, int index, Set<Integer> listOfDepths) {
        if (current == null) return;
        if (isLeaf(current)) listOfDepths.add(index);

        postOrder(current.left, index + 1, listOfDepths);
        postOrder(current.right, index + 1, listOfDepths);
        System.out.print(current.data + " , ");
    }
    /*
         12
        /  \
      7     1
    /     / \
   9   10    5
/
20
    */

    public static void main(String[] args) {
        root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.left.left.left = new Node(20);
        root.right.left = new Node(10);
        root.right.right = new Node(5);

        Set<Integer> preOrderDepth = new HashSet<>();
        preOrder(root, 0, preOrderDepth);
        System.out.println(preOrderDepth);

        Set<Integer> inOrderDepth = new HashSet<>();
        inOrder(root, 0, inOrderDepth);
        System.out.println(inOrderDepth);

        Set<Integer> postOrderDepth = new HashSet<>();
        postOrder(root, 0, postOrderDepth);
        System.out.println(postOrderDepth);
    }

}
