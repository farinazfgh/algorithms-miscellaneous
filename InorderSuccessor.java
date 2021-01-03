class InorderSuccessor {


    static BinaryTreeNode inorderSuccessorBstParentPointer(BinaryTreeNode current) {
        if (current == null) {
            return null;
        }
        /*
        If the given node has a right child, then the left most child in the right child’s subtree will be the in-order successor
         */
        if (current.right != null) {
            return findLeftMostInRightSubTree(current.right);
        }
        /*
        If the given node has no right child, then:
        Start going up the parent chain.
        In this chain, keep going until you find a node who is a left child of its parent.
        This parent node will be the in-order successor
        If no such node is found, the in-order successor will be NULL
         */
        while (current.parent != null) {
            if (current.parent.left == current) {
                return current.parent;
            }
            current = current.parent;
        }
        return null;
    }

    static BinaryTreeNode findSuccessor(BinaryTreeNode current, int data) {
        while (current != null) {

            if (data > current.data) {
                current = current.right;
            } else if (data < current.data) {
                current = current.left;
            } else {
                return inorderSuccessorBstParentPointer(current);
            }
        }
        return null;
    }

    static BinaryTreeNode findPredecessor(BinaryTreeNode current, int data) {
        while (current != null) {
            if (data > current.data) {
                current = current.right;
            } else if (data < current.data) {
                current = current.left;
            } else {
                return findPredecessor(current);
            }
        }
        return null;
    }

    static BinaryTreeNode findPredecessor(BinaryTreeNode current) {
        if (current.left != null) {
            return findRightMostInLeftSubTree(current.left);
        }
        while (current.parent != null) {
            if (current.parent.right == current) return current.parent;
            current = current.parent;
        }
        return null;

    }

    private static BinaryTreeNode findRightMostInLeftSubTree(BinaryTreeNode current) {
        if (current == null) return null;
        while (current.right != null) current = current.right;
        return current;
    }

    static BinaryTreeNode findLeftMostInRightSubTree(BinaryTreeNode current) {
        if (current == null) return null;
        while (current.left != null) current = current.left;
        return current;
    }

    /// Test Program.
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};


        BinaryTreeNode root = SortedArrayToBST.sortedArrayToBST(array, 0, array.length);
        BinaryTree.populateParents(root);
        BinaryTreeNode pred = findPredecessor(root, 12);
        BinaryTreeNode succ = findSuccessor(root, 12);
        System.out.println(pred.data);
        System.out.println(succ.data);

        BinaryTreeNode pred4 = findPredecessor(root, 4);
        BinaryTreeNode succ4 = findSuccessor(root, 4);
        System.out.println(pred4.data);
        System.out.println(succ4.data);


    }
}  