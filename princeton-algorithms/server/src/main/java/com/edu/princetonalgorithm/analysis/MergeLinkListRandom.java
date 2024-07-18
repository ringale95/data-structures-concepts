package com.edu.princetonalgorithm.analysis;

import java.util.Random;
import edu.princeton.cs.algs4.StdRandom;

public class MergeLinkListRandom {

    // Node class
    public static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node shuffle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        int size = getSize(head);
        return mergeSort(head, size);
    }

    private Node mergeSort(Node head, int size) {
        if (size <= 1) {
            return head;
        }

        int mid = size / 2;
        Node left = head;
        Node right = head;
        Node prev = null;

        // Find mid
        for (int i = 0; i < mid; i++) {
            prev = right;
            right = right.next;
        }

        // Split the list from mid
        if (prev != null) {
            prev.next = null;
        }

        // Sort both sides
        left = mergeSort(left, mid);
        right = mergeSort(right, size - mid);

        // Merge both sides
        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node curr = dummy;
        Random rand = new Random();

        while (left != null && right != null) {
            if (rand.nextBoolean()) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        if (left != null) {
            curr.next = left;
        }
        if (right != null) {
            curr.next = right;
        }

        return dummy.next;
    }

    private int getSize(Node head) {
        Node curr = head;
        int size = 0;

        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    private String printList(Node head) {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.val).append(" ");
            curr = curr.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        MergeLinkListRandom mg = new MergeLinkListRandom();
        Node shuffled = mg.shuffle(head);
        System.out.println(mg.printList(shuffled));
    }
}
