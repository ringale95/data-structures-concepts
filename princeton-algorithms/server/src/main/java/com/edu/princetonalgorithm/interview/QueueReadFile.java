package com.edu.princetonalgorithm.interview;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class QueueReadFile {

    public static int[] readFile(String name) {
        In in = new In(name); // read the file
        Queue<Integer> queue = new Queue<>();
        while (!in.isEmpty())
            queue.enqueue(in.readInt());

        int N = queue.size();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = queue.dequeue();

        return arr;
    }

    public static void main(String[] args) {
        int[] result = QueueReadFile.readFile("inputText.txt");

        for (int i : result)
            System.out.println(i);
    }
}
