package com.edu.princetonalgorithm.datastructures.unionfind;

public class WeightedQuickUnion {

    private int[] id; // parent link
    private int[] sz; // size of components of roots
    private int count;

    public WeightedQuickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++)
            sz[i] = 1;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j)
            return;

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] = sz[j] + sz[i];
        } else {
            id[j] = i;
            sz[i] = sz[i] + sz[j];
        }

        count--;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] connections = { { 0, 1 }, { 2, 3 }, { 0, 4 }, { 1, 4 } }; // pair 1-4 will be ignored
        WeightedQuickUnion uf = new WeightedQuickUnion(N);
        for (int[] connect : connections) {
            int p = connect[0];
            int q = connect[1];
            if (uf.find(p) != uf.find(q)) {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
