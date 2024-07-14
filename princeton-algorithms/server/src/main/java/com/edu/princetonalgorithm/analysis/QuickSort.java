package com.edu.princetonalgorithm.analysis;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    public static void main(String[] args) {
        Double[] a = new Double[5];

        for (int i = 0; i < a.length; i++)
            a[i] = StdRandom.uniform();
        Quick.sort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + ",");
    }
}
