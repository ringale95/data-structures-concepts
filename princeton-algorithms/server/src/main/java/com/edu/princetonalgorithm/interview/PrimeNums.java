package com.edu.princetonalgorithm.interview;

import java.util.Iterator;

import edu.princeton.cs.algs4.Bag;

public class PrimeNums {

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0)
                return false;
        return true;
    }

    public static String printBagContents(Bag<Integer> bag) {
        String element = "";
        Iterator<Integer> itr = bag.iterator();
        while (itr.hasNext())
            element += "\n" + itr.next();
        return element;
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        int limit = 10;
        for (int i = 2; i <= limit; i++)
            if (PrimeNums.isPrime(i))
                bag.add(i);
        System.out.println("The prime numbers till " + limit + ":" + PrimeNums.printBagContents(bag));
    }
}
