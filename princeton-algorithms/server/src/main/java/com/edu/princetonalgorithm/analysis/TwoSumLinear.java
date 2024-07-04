package com.edu.princetonalgorithm.analysis;

import java.util.HashMap;

public class TwoSumLinear {

    public static int twoSumPairs(int[] arr) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
            if (map.get(-arr[i]) != null && map.get(-arr[i]) != i)
                count++;
        }
        return count;

    }

    public static void main(String[] args) {
        int[] arr = { 0, 4, -4, 4, 3, -3, 12 };
        System.out.println(TwoSumLinear.twoSumPairs(arr));
    }

}
