package com.edu.allaboutlinklist.queues;

import java.util.Iterator;

import com.edu.allaboutlinklist.list.Node;

public class QueueIterator<T> implements Iterator<T> {
    private Node<T> curr;

    public QueueIterator(Node<T> head) {
        curr = head;
    }

    @Override
    public boolean hasNext() {
        return curr != null;
    }

    @Override
    public T next() {
        T data = curr.data;
        curr = curr.next;
        return data;
    }

}
