import java.util.LinkedList;
import java.util.*;

class BinaryTree {

    public static BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(BinaryTreeNode head) {
        this.root = head;
    }


    public static void displayLevelOrder(BinaryTreeNode root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.poll();
            System.out.print(temp.data + ",");

            if (temp.left != null) {
                queue.offer(temp.left);
                System.out.println(temp.left.data + "LEFT");
            }

            if (temp.right != null) {
                queue.offer(temp.right);
                System.out.println(temp.right.data + "RIGHT");
            }
        }
        System.out.println();
    }

    public static List<Integer> getLevelOrder(BinaryTreeNode root) {

        List<Integer> output = new ArrayList<>();

        if (root == null)
            return output;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.poll();
            System.out.print(temp.data + ", ");
            output.add(temp.data);

            if (temp.left != null) {
                queue.offer(temp.left);
                System.out.println(temp.left.data + "LEFT");
            }

            if (temp.right != null) {
                queue.offer(temp.right);
                System.out.println(temp.right.data + "RIGHT");
            }
        }
        return output;
    }

    public static boolean isIdenticalTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null) {
            return ((root1.data == root2.data) &&
                    isIdenticalTree(root1.left, root2.left) &&
                    isIdenticalTree(root1.right, root2.right));
        } else {
            return false;
        }
    }

    public static BinaryTreeNode insert(BinaryTreeNode root, int data) {

        BinaryTreeNode newNode = new BinaryTreeNode(data);
        if (root == null) {
            return newNode;
        }

        BinaryTreeNode parent = null;
        BinaryTreeNode pTemp = root;
        while (pTemp != null) {
            parent = pTemp;
            if (data <= pTemp.data) {
                pTemp = pTemp.left;
            } else {
                pTemp = pTemp.right;
            }
        }

        if (data <= parent.data) {
            parent.left = newNode;
            newNode.parent = parent;
        } else {
            parent.right = newNode;
            newNode.parent = parent;
        }
        return root;
    }

    public static BinaryTreeNode insertBT(BinaryTreeNode root, int data) {

        BinaryTreeNode newNode = new BinaryTreeNode(data);
        if (root == null) {
            return newNode;
        }

        BinaryTreeNode parent = null;
        BinaryTreeNode pTemp = root;
        while (pTemp != null) {
            parent = pTemp;
            if (data <= pTemp.data) {
                pTemp = pTemp.left;
            } else {
                pTemp = pTemp.right;
            }
        }

        Random generator = new Random();
        int dir = generator.nextInt(1000);

        if (dir % 2 == 0) {
            parent.left = newNode;
            newNode.parent = parent;
        } else {
            parent.right = newNode;
            newNode.parent = parent;
        }
        return root;
    }

    public static BinaryTreeNode findInBinarySearchTree(BinaryTreeNode root, int data) {
        if (root == null)
            return null;

        if (root.data == data) {
            return root;
        } else if (data < root.data) {
            return findInBinarySearchTree(root.left, data);
        } else {
            return findInBinarySearchTree(root.right, data);
        }
    }


    public static void displayInorder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        displayInorder(node.left);
        System.out.print(node.data + ", ");
        displayInorder(node.right);
    }

    public static void getInorder(BinaryTreeNode node, List<Integer> output) {
        if (node == null) {
            return;
        }
        getInorder(node.left, output);
        output.add(node.data);
        getInorder(node.right, output);
    }

    public static void getPreorder(BinaryTreeNode node, List<Integer> output) {
        if (node == null) {
            return;
        }
        output.add(node.data);
        getPreorder(node.left, output);
        getPreorder(node.right, output);
    }

    public static BinaryTreeNode createBST(List<Integer> list) {
        BinaryTreeNode root = null;
        for (Integer x : list) {
            root = insert(root, x);
        }
        return root;
    }

    public static BinaryTreeNode createRandomBST(int count, int maxValue) {
        BinaryTreeNode root = null;
        for (int i = 0; i < count; ++i) {
            Random generator = new Random();
            root = insert(root, generator.nextInt(maxValue));
        }
        return root;
    }

    public static BinaryTreeNode createRandomBST(int count) {
        return createRandomBST(count, Integer.MAX_VALUE);
    }

    public static BinaryTreeNode createBinaryTree(int count) {
        BinaryTreeNode root = null;
        for (int i = 0; i < count; ++i) {
            Random generator = new Random();
            root = insertBT(root, generator.nextInt(100));
        }
        return root;
    }

    private static void populateParentsRec(BinaryTreeNode root, BinaryTreeNode parent) {
        if (root == null) {
            return;
        }

        root.parent = parent;

        populateParentsRec(root.left, root);
        populateParentsRec(root.right, root);
    }

    public static void populateParents(BinaryTreeNode root) {
        populateParentsRec(root, null);
    }

    public static void bstToArraylistRec(BinaryTreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        bstToArraylistRec(root.left, list);
        list.add(root.data);
        bstToArraylistRec(root.right, list);
    }

    public static ArrayList<Integer> bstToArraylist(BinaryTreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        bstToArraylistRec(root, arr);
        return arr;
    }

    public static void anotherDisplayTree(BinaryTreeNode root, int tabs) {
        if (root != null) {
            int i;

            if (root.left != null) {
                for (i = 0; i < tabs + 4; ++i) {
                    System.out.print(" ");
                }
                System.out.print("L" + root.left.data + "\n");
            }

            if (root.right != null) {
                for (i = 0; i < tabs + 4; ++i) {
                    System.out.print(" ");
                }
                System.out.print("R" + root.right.data + "\n");
            }

            anotherDisplayTree(root.left, tabs + 4);
            anotherDisplayTree(root.right, tabs + 4);
        }
    }

    public static void anotherDisplayTree(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + "\n");
            anotherDisplayTree(root, 0);
        }
    }

    public static void main(String[] argv) {

        List<Integer> input1 = new ArrayList<>();
        input1.add(100);
        input1.add(50);
        input1.add(200);
        input1.add(25);
        input1.add(125);
        input1.add(250);
        BinaryTreeNode root1 = BinaryTree.createBST(input1);

        List<Integer> input2 = new ArrayList<>();
        input2.add(1);
        input2.add(2);
        input2.add(10);
        input2.add(50);
        input2.add(180);
        input2.add(199);
        BinaryTreeNode root2 = BinaryTree.createBST(input2);

        List<Integer> input3 = new ArrayList<>();
        input3.add(100);
        input3.add(50);
        input3.add(200);
        input3.add(25);
        input3.add(125);
        input3.add(250);
        BinaryTreeNode root3 = BinaryTree.createBST(input3);


        BinaryTree.displayLevelOrder(root1);

        BinaryTree.displayLevelOrder(root2);

        if (isIdenticalTree(root1, root2)) {
            System.out.println("The trees are identical");
        } else {
            System.out.println("The trees are not identical");
        }
        if (isIdenticalTree(root1, root3)) {
            System.out.println("The trees 1 and 3 are identical");
        } else {
            System.out.println("The trees 1 and 3 are not identical");
        }
    }
}