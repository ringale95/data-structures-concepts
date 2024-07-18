package com.edu.princetonalgorithm.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonNameComparator implements Comparator<Person> {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Raveena", 100));
        persons.add(new Person("Bob", 87));
        persons.add(new Person("Alice", 99));
        Integer

        // Collections.sort(persons); // sorts by natural
        // System.out.println("Sorted person:" + persons);

        // Sort using comparator
        Collections.sort(persons, new PersonNameComparator());
        System.out.println(persons);

    }

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
