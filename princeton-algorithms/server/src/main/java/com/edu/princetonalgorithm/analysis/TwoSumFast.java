package com.edu.princetonalgorithm.analysis;

import java.util.Arrays;

import com.edu.princetonalgorithm.datastructures.search.BinarySearch;

//Time complexity is N(logN)
public class TwoSumFast {

    public static int twoSumPairs(int[] arr) {

        int count = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (BinarySearch.rank(-arr[i], arr) > i)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 4, -4, 3, 0, -3, 12 };
        int count = TwoSumFast.twoSumPairs(arr);
        System.out.println("Expected : " + 2);
        System.out.println("Actual : " + count);
    }

}
