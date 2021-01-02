import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllSequences {

    static class TreeNode {
        public int data;

        public TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * start with a root of the tree (the only valid choice)
     * for each of the current valid choices:
     * - remove one of the roots (valid choices), add its children to the set of choices
     * - recursively find all possible solutions for the new set of choices
     * - append the root to the head of each of those solutions
     */
    static List<LinkedList<Integer>> allSequences(TreeNode node) {
        List<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null) {
            List<Integer> linkedList = new LinkedList<>();
            result.add((LinkedList<Integer>) linkedList);
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);
        new LinkedList<Integer>();
        /* Recurse on left and right subtrees. */
        List<LinkedList<Integer>> leftSeq = allSequences(node.left);
        List<LinkedList<Integer>> rightSeq = allSequences(node.right);

        /* Weave together each list from the left and right sides. */
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                List<LinkedList<Integer>> weaved = new LinkedList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);

            }

        }
        return result;
    }
    /* Weave lists together in all possible ways. This algorithm works by removing the
     * head from one list, recursing, and then doing the same thing with the other
     * list. */

    static void weaveLists(
            LinkedList<Integer> first,
            LinkedList<Integer> second,

            List<LinkedList<Integer>> results
            , LinkedList<Integer> prefix) {

        /*One list is empty.Add remainder to[a cloned]prefix and store result. */

        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }
        /* Recurse with head of first added to the prefix. Removing the head will damage
         * first, so we'll need to put it back where we found it afterwards. */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);


        /* Do the same thing with second, damaging and then restoring the list.*/
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);

        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }


    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(1);
        node2.right = new TreeNode(3);

        List<LinkedList<Integer>> answer = allSequences(node2);
        System.out.println(answer);

    }
}