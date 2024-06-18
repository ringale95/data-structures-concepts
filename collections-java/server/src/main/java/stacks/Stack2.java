package stacks;

public class Stack2 {
    public static int parenthesis(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for (char c : arr) {
            if (c == '(')
                stack.push(c);
            else if (c == ')') {
                max = Math.max(max, stack.size());
                stack.pop();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int val = Stack2.parenthesis("(1+(2*3)+((8)/4))+1");
        System.out.println(val);
    }

}
