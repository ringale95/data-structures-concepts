package com.edu.princetonalgorithm.interview;

import java.util.Iterator;

public class ResizingArrayImplementation<Item> implements Iterable<Item> {

    private Item[] arr = (Item[]) new Object[1]; // stack items
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = arr[i];
        }
        arr = temp; // arr now points to new temp array
    }

    public void push(Item item) {

        // check if it is full or not
        if (N == arr.length)
            resize(2 * arr.length);
        arr[N++] = item;
    }

    public Item pop() {
        Item item = arr[--N];
        arr[N] = null; // avoid loitering
        if (N > 0 && N == arr.length / 4)
            resize(arr.length / 2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return arr[--i];
        }
    }

    public static void main(String[] args) {

    }

}
