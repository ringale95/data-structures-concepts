package com.edu.allaboutlinklist.queues;

import java.io.EOFException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

import com.edu.allaboutlinklist.list.Node;

public class PQueue<T> implements Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int count;

    @Override
    public String toString() {
        Iterator<T> itr = iterator();
        String data = "first ";
        while (itr.hasNext()) {
            data += "<- " + itr.next().toString() + " ";
        }
        return data + "<- last";
    }

    @Override
    public boolean add(T e) {
        // TODO Auto-generated method stub
        return offer(e);
    }

    @Override
    public T element() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean offer(T e) {
        Node<T> oldLast = last;
        last = new Node();
        last.data = e;

        // Empty
        if (first == null)
            first = last;

        // Atleast One Element
        else if (oldLast != null)
            oldLast.next = last;
        count++;
        return true;
    }

    @Override
    public T peek() {
        return first.data;
    }

    @Override
    public T poll() {
        T item = first.data;
        first = first.next;
        count--;
        return item;
    }

    @Override
    public T remove() {
        // TODO Auto-generated method stub
        return poll();
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        count = 0;
    }

    @Override
    public boolean contains(Object o) {
        Iterator<T> itr = iterator();
        while (itr.hasNext()) {
            T data = itr.next();
            if (data.equals(o))
                return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator<>(first);
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PQueue<>();

        try {
            // Test 1 - Ability to add items
            boolean status = queue.offer(1);
            if (!status)
                throw new Exception("Failure: Test 1 - Ability to add items");

            // Test 2 - Ability to remove items
            int val = queue.poll();
            if (val != 1)
                throw new Exception("Failure: Test 2 - Ability to remove items");

            // Test 3 - Visualization of queue
            queue.offer(2);
            queue.offer(3);
            String str = queue.toString();
            if (!str.equals("first <- 2 <- 3 <- last"))
                throw new Exception("Failure: Test 3 - Visualization of queue");

            // Test 4 - Add an item
            queue.add(5);

            // Test 5 - Remove an item
            queue.remove();

            // Test 6 - Peek an item
            val = queue.peek();
            if (val != 3)
                throw new Exception("Failure: Test 6 - Peek an item");

            // Test 7 - Clear queue
            queue.clear();
            if (!queue.isEmpty())
                throw new Exception("Failure: Test 7 - Clear queue");

            // Test 8 - Queue contains
            queue.offer(1);
            queue.offer(2);
            queue.offer(3);
            if (!queue.contains(3))
                throw new Exception("Failure: Test 8 - Queue contains");

            // Test 9 - Size of Queue
            val = queue.size();
            if (val != 3)
                throw new Exception("Failure: Test 9 - Size of Queue");

            System.out.println("All Test Cases passed!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

}
