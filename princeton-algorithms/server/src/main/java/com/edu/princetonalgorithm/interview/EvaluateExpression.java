package com.edu.princetonalgorithm.interview;

import edu.princeton.cs.algs4.Stack;

public class EvaluateExpression {

    public static double evaluate(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        for (char c : s.toCharArray()) {
            if (isOperand(c))
                ops.push(c);
            else if (isDigit(c))
                vals.push(Double.parseDouble(c + ""));
            else if (c == ')') {
                char op = ops.pop();
                double val1 = vals.pop();
                double val2 = vals.pop();

                switch (op) {
                    case '+':
                        vals.push(val1 + val2);
                        break;
                    case '-':
                        vals.push(val1 - val2);
                        break;
                    case '*':
                        vals.push(val1 * val2);
                        break;
                    case '/':
                        vals.push(val2 / val1);
                        break;

                }
            }
        }
        return vals.pop();
    }

    private static boolean isDigit(char c) {
        if (c >= 48 && c <= 57)
            return true;
        return false;
    }

    private static boolean isOperand(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(EvaluateExpression.evaluate("(1+((2+3)*(4*5)))"));
    }
}
