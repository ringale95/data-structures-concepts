package com.edu.princetonalgorithm.assignment;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    /*
     * Defines the initial capacity of the internal
     * resizable array.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /*
     * Internal Array which holds elements of
     * Randomized Queue. This would resized as
     * per the state of the elements within the
     * Randomized Queue.
     */
    private Item[] elementDataItems;

    /*
     * Holds the number of elements within
     * Randomized Queue.
     */
    private int count;

    // construct an empty randomized queue
    public RandomizedQueue() {
        elementDataItems = (Item[]) new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return count == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return count;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null");
        if (count == elementDataItems.length)
            resize(2 * elementDataItems.length);
        elementDataItems[count++] = item;
    }

    private void resize(int capacity) {
        Item[] newArr = (Item[]) new Object[capacity];
        for (int i = 0; i < elementDataItems.length; i++)
            newArr[i] = elementDataItems[i];
        elementDataItems = newArr;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Randomized Queue is empty!");
        int randomIndex = StdRandom.uniformInt(count); // returns a random integer from 0 to count
        Item item = elementDataItems[randomIndex]; // take the backup of randomIndex value
        elementDataItems[randomIndex] = elementDataItems[--count]; // make the value of randomIndex the last value
        elementDataItems[count] = null; // free the last index

        if (count > 0 && count == elementDataItems.length / 4)
            resize(elementDataItems.length / 2);
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException("Randomized Queue is empty!");
        // just return the value without removing
        return elementDataItems[StdRandom.uniformInt(count)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedIterator<Item>(elementDataItems);
    }

    private class RandomizedIterator<T> implements Iterator<T> {
        private T[] copy;
        private int current;

        public RandomizedIterator(T[] data) {
            // Clone RQ array & shuffle
            copy = (T[]) new Object[data.length];
            for (int i = 0; i < data.length; i++)
                copy[i] = data[i];
            StdRandom.shuffle(copy);

            // Initially current point at last index
            current = copy.length - 1;
        }

        @Override
        public boolean hasNext() {
            return current >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return copy[current--];
        }

    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);

        System.out.println("Sample value for random index : " + rq.sample());
        System.out.println("Size of elements after adding 4 items is : " + rq.size());

        System.out.println(rq.dequeue());
        System.out.println("Size after dequeue one element : " + rq.size());
    }

}
