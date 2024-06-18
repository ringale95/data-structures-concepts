package com.edu.allaboutlinklist.others;

public class Generics {

    public class Person {
        public String name;
        public String email;

        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', email='" + email + "'}";
        }
    }

    // Generic method:
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Generics g = new Generics();
        Generics.Person[] p = { g.new Person("Raveena", "ingale.r@example.com") };
        printArray(p);
    }
}
