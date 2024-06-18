package stacks;

import java.util.Iterator;

import com.edu.allaboutlinklist.list.BagIterator;
import com.edu.allaboutlinklist.list.Node;

public class Stack<T> implements Iterable<T> {

    private Node<T> first = null;
    private int n;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T data) {

        Node<T> oldFirst = first; // Backup
        first = new Node<T>();
        first.data = data;
        first.next = oldFirst;
        n++;
    }

    public T pop() {
        T data = first.data;
        first = first.next;
        n--;
        return data;

    }

    public T peek() {
        return first.data;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator(first);
    }

    public String toString() {
        Iterator<T> itr = iterator();
        String data = "";
        while (itr.hasNext()) {
            data += "---" + "\n" + "|" + itr.next() + "|" + "\n";
        }

        return data + "---";
    }
}
