package com.edu.princetonalgorithm.analysis;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SelectionSort {

    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (less(a[j], a[min]))
                    min = j;
            exch(a, i, min);
        }
    }

    private void exch(Comparable[] a, int i, int min) {
        Comparable t = a[i];
        a[i] = a[min];
        a[min] = t;
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        SelectionSort sorting = new SelectionSort();
        Integer[] arr = { 8, 4, 22, 7, 1, 6 };

        sorting.sort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
        System.out.println("Time Taken : " + timer.elapsedTime());
    }
}
