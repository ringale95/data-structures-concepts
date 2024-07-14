package com.edu.princetonalgorithm.analysis;

import edu.princeton.cs.algs4.Stopwatch;

public class InsertionSort {

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            int N = a.length;
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        InsertionSort insertion = new InsertionSort();
        Integer[] arr = { 9, 8, 5, 10, 4 };
        insertion.sort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
        System.out.println("Time taken : " + timer.elapsedTime());
    }

}
