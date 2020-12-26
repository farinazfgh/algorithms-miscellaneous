

class ReverseLinkedList {
    static class Node {
        int value = 0;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);

        Node result = ReverseLinkedList.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    private static Node reverse(Node head) {
        if (head == null) return head;
        Node prev, next;
        prev = null;
        next = null;
        Node curent = head;
        while (curent != null) {
            next = curent.next;
            curent.next = prev;
            prev = curent;
            curent = next;
        }
        return prev;

    }
}