package com.edu.allaboutlinklist.list;

public class Doublylinklist {

    public Node head; // refers to first node
    public Node tail; // refers to last node

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // empty link list
            head = newNode;
            tail = newNode;
        } else {
            // not empty linklist
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

    }

    public void traverseFront() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println();
    }

    public void traverseReverse() {

        Node curr = tail;
        while (tail != null) {
            System.out.print(curr.data + "<-");
            curr = curr.prev;
        }
        System.out.println();
    }

    private static class Node {
        public int data;
        public Node prev;
        public Node next;

        public Node(int data) {
            this.data = data; // refer instance var if name is same by this
        }
    }

    public static void main(String[] args) {
        // NodeLL temp = new NodeLL(5);
        // System.out.println(temp.prev);
        // System.out.println(temp.next);

        Doublylinklist dll = new Doublylinklist();
        dll.add(5);
        dll.add(15);
        dll.add(20);
        dll.add(10);
        System.out.println(dll.head.data);
        System.out.println(dll.tail.data);
        dll.traverseFront();
        dll.traverseReverse();
    }

}
