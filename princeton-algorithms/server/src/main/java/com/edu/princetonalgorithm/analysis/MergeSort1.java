package com.edu.princetonalgorithm.analysis;

import edu.princeton.cs.algs4.Merge;

public class MergeSort1 {

    public static void merge(Comparable[] a, int low, int mid, int hi) {
        int i = low;
        int j = mid + 1;
        Comparable[] aux = new Comparable[a.length];
        for (int k = low; k <= hi; k++)
            aux[k] = a[k];
        for (int k = low; k <= hi; k++) {

            // means left half is exhausted then:
            if (i > mid)
                a[k] = aux[j++];
            // means right half is exhausted then:
            else if (j > hi)
                a[k] = aux[i++];
            // if left half element is smaller than right half element then increment left
            // half
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        String[] arr = { "E", "E", "G", "M", "R", "A", "C", "E", "R", "T" };
        MergeSort1.merge(arr, 0, 4, 9);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + ",");
    }
}
