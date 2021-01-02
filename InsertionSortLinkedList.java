public class InsertionSortLinkedList {
    static class Node {
        final int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node sort(Node head) {
        if (head == null || head.next == null) return head;

        return null;
    }

    static Node sortedInsert(Node head, Node node) {
        if (node == null) {

            return head;
        }

        if (head == null || node.data <= head.data) {
            node.next = head;
            return node;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data < node.data) current = current.next;
        }
        node.next = current.next;
        current.next = node;
        return head;
    }

    public static Node insertionSort(Node head) {

        Node sorted = null;
        Node curr = head;

        while (curr != null) {

            Node temp = curr.next;

            sorted = sortedInsert(sorted, curr);

            curr = temp;
        }

        return sorted;
    }
}
