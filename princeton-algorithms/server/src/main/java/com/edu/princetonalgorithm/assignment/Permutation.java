package com.edu.princetonalgorithm.assignment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            if (input != null && !input.isEmpty()) {
                rq.enqueue(input);
            }
        }
        int k = Integer.parseInt(args[0]);
        Iterator<String> itr = rq.iterator();
        while (itr.hasNext() && k > 0) {
            StdOut.println(itr.next());
            k--;
        }
    }
}
