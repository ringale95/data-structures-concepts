package com.edu.princetonalgorithm.interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

import edu.princeton.cs.algs4.Stack;

public class TwoStackQueues<T> implements Queue<T> {

    private int count;

    T[] array = (T[]) new Object[100];
    private Stack<T> stack1;
    private Stack<T> stack2;

    public TwoStackQueues() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
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
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
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

    @Override
    public void clear() {
        TwoStackQueues();
    }

    @Override
    public boolean add(T item) {
        stack1.push(item);
        if (stack1.peek().equals(item)) {
            count++;
            return true;
        } else {
            throw new IllegalStateException("Failed to add item to the queue.");
        }
    }

    @Override
    public boolean offer(T item) {
        try {
            stack1.push(item);
            count++;
            return stack1.peek().equals(item);
        } catch (NoSuchElementException e) {
            count--;
            return false;
        }
    }

    @Override
    public T remove() {
        throw new UnsupportedOperationException("Unimplemented method 'poll'");

    }

    @Override
    public T poll() {
        if (!stack1.isEmpty())
            stack2.push(stack1.pop());
        return stack2.pop();
    }

    @Override
    public T element() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'element'");
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    public static void main(String[] args) {
        TwoStackQueues<Integer> queue = new TwoStackQueues<>();
        System.out.println(queue.offer(6));
        System.out.println(queue.add(7));
    }

}
