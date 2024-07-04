package com.edu.princetonalgorithm.analysis;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        // Integer[] array = { 2, 4, 6, 8, 10, 12, 14, 16 };
        // int target = 7;

        // int index = Arrays.binarySearch(array, target);
        // // -(( -(insertionPoint) - 1) + 1)

        // System.out.println("Index returned by binarySearch: " + index);

        // // Calculating insertion point
        // int insertionPoint = -(index + 1);
        // System.out.println("Insertion point: " + insertionPoint);

        // Test for Bitonic
        // int[] arr = { 1, 2, 3, 8, 9, 10, 5 };
        // System.out.println("Pivot Point: " + BinarySearch.getPivotForBitonic(arr));

        // Test for Recursive BS
        int[] arr = { 1, 2, 3, 8, 9 };
        System.out.println("Target Found for Recursive: " + BinarySearch.binarySearch(0, arr.length - 1, arr, 8));
    }

    public static int binarySearch(int low, int high, int[] arr, int target) {
        if (low > high) {
            return -1; // Base case: element not found
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid; // Element found at mid index
        }

        if (arr[mid] < target) {
            // Recursively search in the right half
            return binarySearch(mid + 1, high, arr, target);
        } else {
            // Recursively search in the left half
            return binarySearch(low, mid - 1, arr, target);
        }
    }

    public static int getPivotForBitonic(int[] arr) {

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low < high) {
            mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                return mid;
            else if (arr[mid] < arr[mid + 1])
                low = mid + 1;
            else if (arr[mid] < arr[mid - 1])
                high = mid;
        }
        return -1;
    }

}
