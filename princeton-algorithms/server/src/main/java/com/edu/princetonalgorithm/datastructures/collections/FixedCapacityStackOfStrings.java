package com.edu.princetonalgorithm.datastructures.collections;

public class FixedCapacityStackOfStrings {

    // implementation:
    private String[] arr;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        arr = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        arr[N++] = item;
    }

    public String pop() {
        return arr[--N];
    }
}
