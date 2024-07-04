package com.edu.princetonalgorithm.analysis;

//Time complexity is N2
public class TwoSumBruteForce {

    public static int twoSumBrute(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] + arr[j] == 0)
                    count++;
        return count;
    }

    public static void main(String[] args) {

        int[] arr = { 0, 4, -4, 3, -3, 12 };
        System.out.println(TwoSumBruteForce.twoSumBrute(arr));
    }

}
