package com.edu.princetonalgorithm.datastructures.unionfind;

public class QuickUnion {
    private int[] parent;
    int count;

    public QuickUnion(int N) {
        parent = new int[N];
        count = N;
        for (int i = 0; i < N; i++)
            parent[i] = i;
    }

    // Finding the root of site
    private int root(int i) { // this is private because its going to be used by another method
        while (parent[i] != i)
            i = parent[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        parent[pRoot] = qRoot;
        count--;
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] connections = { { 0, 1 }, { 2, 3 }, { 0, 4 }, { 1, 4 } }; // pair 1-4 will be ignored
        QuickUnion uf = new QuickUnion(N);
        for (int[] connect : connections) {
            int p = connect[0];
            int q = connect[1];
            if (uf.root(p) != uf.root(q)) {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
