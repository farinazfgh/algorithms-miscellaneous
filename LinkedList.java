public class LinkedList {
    static class Node {
        final int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;

    void insertAtTail(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = newNode;
        }
    }

    void insertAtHead(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void delete(int data) {

        if (head == null) return;
        Node previous, current;
        previous = current = head;
        while (current.next != null) {
            if (data == current.data) {
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }
    }


    Node search(int data) {
        if (head == null) return null;
        Node pointer = head;
        while (pointer.next != null && pointer.data != data) {
            pointer = pointer.next;
        }
        if (pointer.data == data) return pointer;
        else return null;
    }

    void print() {
        if (head == null) return;
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + " , ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    int size() {
        int count = 0;
        if (head == null) return 0;
        Node pointer = head;
        while (pointer != null) {
            count++;
            pointer = pointer.next;
        }
        return count;
    }
}
