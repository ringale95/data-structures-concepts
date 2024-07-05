package com.edu.princetonalgorithm.interview;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackExpression {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        char c = 'a';
        Character.isDigit(c);
        String[] str = StdIn.readAllStrings();
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("(")) {
            } else if (str[i].equals("+"))
                ops.push(str[i]);
            else if (str[i].equals("-"))
                ops.push(str[i]);
            else if (str[i].equals("*"))
                ops.push(str[i]);
            else if (str[i].equals("/"))
                ops.push(str[i]);
            else if (str[i].equals("sqrt"))
                ops.push(str[i]);
            else if (str[i].equals(")")) {
                String op = ops.pop();
                Double v = vals.pop();

                if (op.equals("+"))
                    v = vals.pop() + v;
                else if (op.equals("-"))
                    v = vals.pop() - v;
                else if (op.equals("*"))
                    v = vals.pop() * v;
                else if (op.equals("/"))
                    v = vals.pop() / v;
                else if (op.equals("sqrt"))
                    v = Math.sqrt(v);
                vals.push(v);
            } else
                vals.push(Double.parseDouble(str[i]));
        }
        StdOut.println(vals.pop());
    }
}