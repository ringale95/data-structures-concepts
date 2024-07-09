package com.edu.princetonalgorithm.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        head = null;
        tail = null;
        count = 0;
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private void addFirst(T t) {

        if (t == null)
            throw new IllegalArgumentException("Cannot add null item to the deque");

        // Wrap data inside newNode
        Node<T> newNode = new Node<>();
        newNode.data = t;

        // Update pointers
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    private T removeFirst() {

        if (head == null)
            throw new NoSuchElementException("Element not found!");

        // unwrap data
        T data = head.data;
        // update pointers
        head = head.next;

        // after update check if the list is empty or not
        if (head == null)
            tail = null;
        else
            head.prev = null;

        count--;
        return data;
    }

    private int size() {
        return count;
    }

    private T removeLast() {
        if (tail == null)
            throw new NoSuchElementException("Not found!");

        // unwrap data and take backup
        T data = tail.data;
        tail = tail.prev;

        if (tail == null)
            head = null; // prevent loitering if empty
        else
            tail.next = null;
        count--;
        return data;
    }

    private void addLast(T t) {
        if (t == null)
            throw new IllegalArgumentException("Cannot add null item to the deque");

        // Create a new node
        Node<T> newLast = new Node<>();
        // wrap data
        newLast.data = t;

        // check if deque is empty if yes then both head and tail points to new node
        if (tail == null) {
            tail = newLast;
            head = newLast;
        } else {
            tail.next = newLast;
            newLast.prev = tail;
            tail = newLast;
        }
        count++;

    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(head);
    }

    private class LinkedListIterator<T> implements Iterator<T> {
        Node<T> current;

        public LinkedListIterator(Node head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException("No more elements found in the deque!");
            T data = current.data;
            current = current.next;
            return data;
        }
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

        deque = new Deque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        Iterator<Integer> itr = deque.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
    }

}
