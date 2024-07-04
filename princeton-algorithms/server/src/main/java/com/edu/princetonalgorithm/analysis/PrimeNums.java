package com.edu.princetonalgorithm.analysis;

import java.util.List;

import java.util.LinkedList;

public class PrimeNums {

    public static boolean isPrime(int number) {

        if (number <= 1)
            return false;

        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int limit = 100;
        List<Integer> list = new LinkedList<>();

        for (int i = 2; i <= limit; i++) {
            if (isPrime(i))
                list.add(i);
        }

        System.out.println("All prime numbers upto " + limit + "are" + list);
    }

}
