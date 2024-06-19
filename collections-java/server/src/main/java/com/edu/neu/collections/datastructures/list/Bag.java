package com.edu.neu.collections.datastructures.list;

import java.util.Iterator;

import com.edu.neu.collections.datastructures.commons.Node;

public class Bag<T> implements Iterable<T> {

    private Node<T> first; // beginning of bag

    private int n;// number of elements in bag

    public void Bag() {
        first = null;
        n = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator(first);
    }

    private boolean isEmpty() {
        return first == null; // returns true if bag is empty else false
    }

    private int size() {
        return n; // returns number of items in bag
    }

    public void add(T t) {
        // Adding at the start
        Node<T> oldFirst = first;
        first = new Node<>();
        first.data = t;
        first.next = oldFirst;
        n++;
    }

}
