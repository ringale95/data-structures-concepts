package com.edu.allaboutlinklist.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

import stacks.Stack;

public class BagIterator<T> implements Iterator<T> {
    private Node<T> current;

    public BagIterator(Node<T> first) {
        current = first;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException("Bag is empty");// Meaning hasNext returns false means
        T item = current.data;
        current = current.next;
        return item;
    }
}
