public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int lastOp = 1;
        stack.push(lastOp);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (s.charAt(i) == '+') {
                lastOp = 1;
            } else if (s.charAt(i) == '-') {
                lastOp = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(lastOp * stack.peek());
                lastOp = 1;
            } else if (s.charAt(i) == ')') {
                stack.pop();
            } else {
                int k = i;
                int currNumber = 0;
                while (k < s.length() && Character.isDigit(s.charAt(k))) {
                    currNumber = currNumber * 10 + (int)s.charAt(k) - (int)'0';
                    k += 1;
                }

                i = k - 1;
                result += currNumber * stack.peek() * lastOp;
            }
        }

        return result;
    }
}
