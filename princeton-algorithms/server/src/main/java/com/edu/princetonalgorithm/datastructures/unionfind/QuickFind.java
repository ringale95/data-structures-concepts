package com.edu.princetonalgorithm.datastructures.unionfind;

public class QuickFind {

    private int count;
    private int[] id;

    public QuickFind(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId)
            return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == qId)
                id[i] = pId;

        count--;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] connections = { { 0, 1 }, { 2, 3 }, { 0, 4 }, { 1, 4 } };
        QuickFind uf = new QuickFind(N);
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
