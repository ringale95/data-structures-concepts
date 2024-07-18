package com.edu.princetonalgorithm.analysis;

public class BottomUp {

    private static Comparable[] aux;

    private static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz <= N - sz; sz = sz + sz)
            for (int lo = 0; lo < N - sz; lo += sz + sz)

                // merge(arr, low, mid, high)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        aux = new Comparable[a.length];
        int i = lo;
        int j = mid + 1;
        hi = a.length;
        for (int k = lo; k < hi; k++)
            aux[k] = a[k];
        for (int k = lo; k < hi; k++)
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {

        String[] arr = { "E", "E", "G", "M", "R", "A", "C", "E", "R", "T" };
        BottomUp.sort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + ",");

    }

}
