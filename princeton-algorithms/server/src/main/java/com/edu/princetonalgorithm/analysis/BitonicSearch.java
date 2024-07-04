package com.edu.princetonalgorithm.analysis;

public class BitonicSearch {

    public static boolean searchTarget(int[] arr, int target) throws Exception {

        // Find pivot point using BS
        int pivot = BinarySearch.getPivotForBitonic(arr);
        if (pivot < 0)
            throw new Exception("Not a Bitonic Array");

        // Give the pivot point perform BS from 0 - pivot
        int found = BinarySearch.binarySearch(0, pivot, arr, target);
        if (found >= 0)
            return true;

        // If not found then perform BS from pivot+1 - N-1
        return BinarySearch.binarySearch(pivot + 1, arr.length - 1, arr, target) >= 0 ? true : false;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = { 1, 2, 3, 8, 7, 6, 5 };
        int target = 6;
        System.out.println("Is target present in array? " + BitonicSearch.searchTarget(arr, target));
    }

}
