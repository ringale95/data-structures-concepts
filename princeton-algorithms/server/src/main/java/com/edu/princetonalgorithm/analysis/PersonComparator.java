package com.edu.princetonalgorithm.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonComparator {

    private String name;
    private int age;

    public PersonComparator(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Raveena", 100));
        persons.add(new Person("Bob", 87));
        persons.add(new Person("Alice", 99));

        // Collections.sort(persons); // sorts by natural
        // System.out.println("Sorted person:" + persons);

        // Sort using comparator
        Collections.sort(persons, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());

            }
        });
        System.out.println(persons);

    }

}
