package com.edu.princetonalgorithm.datastructures.search;

public class BinarySearch {

    public static int rank(int key, int[] arr) {

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low < high) {
            mid = (low + (high - low) / 2);

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

}
