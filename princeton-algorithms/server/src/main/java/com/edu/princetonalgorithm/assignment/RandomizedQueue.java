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
     * Internal Array w hich holds elements of
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

    public RandomizedQueue() {
        elementDataItems = (Item[]) new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null");
        if (count == elementDataItems.length)
            resize(2 * elementDataItems.length);
        elementDataItems[count++] = item;
    }

    private void resize(int capacity) {
        Item[] newArr = (Item[]) new Object[capacity];
        System.arraycopy(elementDataItems, 0, newArr, 0, count);
        elementDataItems = newArr;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Randomized Queue is empty!");
        int randomIndex = StdRandom.uniformInt(count);
        Item item = elementDataItems[randomIndex];
        elementDataItems[randomIndex] = elementDataItems[--count];
        elementDataItems[count] = null;

        if (count > 0 && count == elementDataItems.length / 4)
            resize(elementDataItems.length / 2);
        return item;
    }

    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException("Randomized Queue is empty!");
        return elementDataItems[StdRandom.uniformInt(count)];
    }

    public Iterator<Item> iterator() {
        return new RandomizedIterator(elementDataItems, count);
    }

    private class RandomizedIterator implements Iterator<Item> {
        private Item[] copy;
        private int current;

        public RandomizedIterator(Item[] data, int size) {
            copy = (Item[]) new Object[size];
            System.arraycopy(data, 0, copy, 0, size);
            StdRandom.shuffle(copy);
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < copy.length;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return copy[current++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

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
