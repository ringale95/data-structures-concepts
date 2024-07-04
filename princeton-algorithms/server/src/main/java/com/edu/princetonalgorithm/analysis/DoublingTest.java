package com.edu.princetonalgorithm.analysis;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class DoublingTest {

    public static double timeTrial(int N) {
        int Max = 100000;
        int[] a = new int[N];
        // Generate Random numbers between -max to max and put it in array[] a
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniformInt(-Max, Max);
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();

    }

    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.println(N + " " + time);
        }

    }

}
