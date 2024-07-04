package com.edu.princetonalgorithm.analysis;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StatsBagClient {

    public static void main(String[] args) {
        // Initialize the bag
        Bag<Double> bag = new Bag<>();

        // Read inputs into the bag until the input is empty
        while (!StdIn.isEmpty()) {
            bag.add(StdIn.readDouble());
        }

        int N = bag.size();

        if (N == 0) {
            StdOut.println("No numbers were input.");
            return;
        }

        // Calculate mean
        double sum = 0.0;
        for (double x : bag) {
            sum += x;
        }
        double mean = sum / N;

        // Calculate standard deviation
        double sumSquaredDifferences = 0.0;
        for (double x : bag) {
            sumSquaredDifferences += (x - mean) * (x - mean);
        }
        double std = (N > 1) ? Math.sqrt(sumSquaredDifferences / (N - 1)) : 0.0;

        // Output results
        StdOut.printf("Mean is: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
