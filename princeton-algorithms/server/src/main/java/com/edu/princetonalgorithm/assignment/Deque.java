package com.edu.princetonalgorithm.assignment;

import java.util.Iterator;

public class Deque<T> implements Iterable<T> {

    private class Node<T> {
        private T data;
        private Node next;
        private Node prev;
    }

    private Node<T> head;
    private Node<T> tail;
    private int count;

    public Deque() {

    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    private boolean isEmpty() {
        return head == null;
    }

    private void addFirst(T t) {
        Node<T> oldHead = head;
        head = new Node<>();
        head.data = t;
        head.next = oldHead;

        // If dequeu is empty
        if (tail == null)
            tail = head;
        else
            oldHead.prev = head;
        count++;
    }

    private T removeFirst() {
        T data = head.data;
        head = head.next;

        if (head == null)
            tail = null; // to avoid loitering
        else
            head.prev = null;
        count--;
        return data;
    }

    private int size() {
        return count;
    }

    private T removeLast() {
        T data = tail.data;
        tail = tail.prev;
        if (tail != null)
            tail.next = null; // nextent loitering
        count--;
        return data;
    }

    private void addLast(T t) {
        Node<T> oldTail = tail;
        tail = new Node<>();
        tail.data = t;
        tail.prev = oldTail;

        if (head == null)
            head = tail;
        else if (oldTail != null)
            oldTail.next = tail;
        count++;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        // TC-1: Verify isEmpty()
        /*
         * Verify that a newly created deque is empty.
         * Add an item and assert that the deque is not empty.
         * Add and then remove items to ensure the deque emptiness status updates
         * correctly
         */

        System.out.println("Expected : true\nActual : " + deque.isEmpty());
        deque.addFirst(1);
        System.out.println("Expected : false\nActual : " + deque.isEmpty());
        deque.removeFirst();
        System.out.println("Expected : true\nActual : " + deque.isEmpty());

        // TC-2 : Verify size()
        /*
         * Assert that the size of a newly created deque is zero.
         * Add one item and check that the size increments to one.
         * Add multiple items and verify that the size reflects the total number of
         * items.
         * Remove items and confirm that the size decreases accordingly.
         */
        deque = new Deque<>();
        System.out.println("Expected : 0\nActual : " + deque.size());
        deque.addFirst(1);
        System.out.println("Expected : 1\nActual : " + deque.size());
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println("Expected : 3\nActual : " + deque.size());
        deque.removeFirst();
        System.out.println("Expected : 2\nActual : " + deque.size());

        // TC-3: Verify addFirst(item)
        /*
         * Add an item to the front of the deque and verify it was added correctly.
         * Add multiple items to the front and ensure they are added in the correct
         * order.
         */
        deque = new Deque<>();
        deque.addFirst(1);
        System.out.println("Expected : 1\nActual : " + deque.removeFirst());
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println("Expected : 2\nActual : " + deque.removeLast());
        System.out.println("Expected : 3\nActual : " + deque.removeLast());

        // TC-4: Verify addLast();
        /*
         * Add an item to the back of the deque and confirm it was added correctly.
         * Add multiple items to the back and ensure they are added in the correct
         * order.
         */
        deque = new Deque<>();
        deque.addLast(1);
        System.out.println("Expected : 1\nActual : " + deque.removeLast());
        deque.addLast(2);
        deque.addLast(3);
        System.out.println("Expected : 3\nActual : " + deque.removeLast());
        System.out.println("Expected : 2\nActual : " + deque.removeLast());
    }

}
