package com.edu.princetonalgorithm.interview;

import com.edu.princetonalgorithm.datastructures.collections.FixedCapacityStackOfStrings;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedStack {

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!item.isEmpty()) {
                StdOut.print(s.pop());
            }
            System.out.println(s.size());
        }
    }

}
