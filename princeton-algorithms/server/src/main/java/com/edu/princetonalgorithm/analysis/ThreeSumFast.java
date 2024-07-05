package com.edu.princetonalgorithm.analysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSumFast {

    public static int threeSumFastest(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;

        // Fill the map with element and its index
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        // Check for each pair if the complement exists in the map
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j < arr.length; j++) {
                int complement = -arr[i] - arr[j];
                if (map.containsKey(complement) && map.get(complement) > j)
                    count++;
            }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { -3, 3, 0, 1 };
        System.out.println("Number of triplets found : " + ThreeSumFast.threeSumFastest(arr));

    }
}
