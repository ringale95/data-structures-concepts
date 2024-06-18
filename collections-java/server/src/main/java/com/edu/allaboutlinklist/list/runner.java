package com.edu.allaboutlinklist.list;

public class runner {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.toAdd(10, 0);
        list.toAdd(2, 1);
        list.toAdd(3, 2);
        list.toAdd(5, 3);
        list.toAdd(6, 4);

        list.addLast(5, 7);
        list.printList();
        list.delete(2);
        list.printList();
    }
}
