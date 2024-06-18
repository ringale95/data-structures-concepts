package com.edu.allaboutlinklist.list;

public class LinkedList {

    // first node or head node;
    public Node head;

    public LinkedList() {
        this.head = null;
    }

    // traverse through link list:
    public void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public void toAdd(int data, int pos) {

        Node prev = head;

        if (head == null) {
            System.out.println("List is empty");
        }
        Node toAdd = new Node();

        // To add at the start
        if (pos == 0) {
            toAdd.next = head;
            head = toAdd;
        } else {
            // to add in mid
            for (int i = 0; i < pos - 1; i++)
                prev = prev.next;

            toAdd.next = prev.next;
            prev.next = toAdd;
        }

    }

    // Add last
    public <T> void addLast(int data, int pos) {

        Node<T> lastNode = new Node<T>();
        if (head == null) {
            head = lastNode;
            return;
        }
        // Traverse
        Node currNode = head;
        while (currNode != null) {
            currNode = currNode.next;
        }
        currNode.next = lastNode;
    }

    // Print
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println();
    }

    public void delete(int pos) {
        Node prev = head;

        // delete first node
        if (pos == 0) {
            head = head.next;
            return;
        } else {
            // delete mid
            for (int i = 0; i < pos - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }
    }
}
