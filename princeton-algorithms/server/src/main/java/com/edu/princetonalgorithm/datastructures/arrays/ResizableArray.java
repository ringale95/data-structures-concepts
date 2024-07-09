package com.edu.princetonalgorithm.datastructures.arrays;

public class ResizableArray<T> {

    private static final int CAPACITY = 4;

    public T[] arr;
    private int count;

    public ResizableArray() {
        arr = (T[]) new Object[CAPACITY];
        count = 0;
    }

    public int size() {
        return count;
    }

    private void add(T i) {
        // to add first check if the count < arr.length else resize to arr.length * 2
        if (count == arr.length)
            resize(arr.length * 2);
        arr[count++] = i;

    }

    private void resize(int n) {
        T[] copyArr = (T[]) new Object[n];
        for (int i = 0; i < count; i++)
            copyArr[i] = arr[i];
        arr = copyArr;
    }

    private T remove() {
        // check if after removing the size is 1/4 of the arr.length else increase to
        // half
        T element = arr[--count];
        arr[count] = null; // avoid loitering
        if (count > 0 && count == arr.length / 4)
            resize(arr.length / 2);
        return element;
    }

    public static void main(String[] args) {
        ResizableArray<Integer> resizeArr = new ResizableArray<>();

        resizeArr.add(5);
        resizeArr.add(6);
        resizeArr.add(7);
        resizeArr.add(8);

        System.out.println("Size of an array before resizing is: " + resizeArr.size());

        System.out.println("Removed element: " + resizeArr.remove());
        System.out.println("Size of an array after removing an element: " + resizeArr.size());
        resizeArr.add(9);
        resizeArr.add(10);
        resizeArr.add(11);
        System.out.println("Size of an array after adding more elements: " + resizeArr.size());
    }

}
