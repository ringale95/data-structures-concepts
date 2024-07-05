package com.edu.princetonalgorithm.interview;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class StackReadFile {

    public static void readFile(String name) {
        In in = new In(name);
        Stack<Integer> stack = new Stack<>();
        while (!in.isEmpty())
            stack.push(in.readInt());

        for (int i : stack)
            StdOut.print(i + "\n");
    }

    public static void main(String[] args) {
        StackReadFile.readFile("inputText.txt");
    }
}
