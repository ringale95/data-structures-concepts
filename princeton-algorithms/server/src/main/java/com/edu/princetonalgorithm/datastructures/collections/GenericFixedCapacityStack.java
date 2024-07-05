package com.edu.princetonalgorithm.datastructures.collections;

public class GenericFixedCapacityStack<T> {

    private T[] a;
    private int N;

    public GenericFixedCapacityStack(int cap) {
        a = (T[]) new Object[cap];

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T t) {
        a[N++] = t;
    }

    public T pop() {
        return a[--N];
    }
}
