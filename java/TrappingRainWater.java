public class Solution {
    public int trap(int[] A) {
        int result = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (i < A.length) {
            if (stack.empty() == true || A[i] <= A[stack.peek()]) {
                stack.push(i);
                i ++;
            } else {
                int top = stack.peek();
                stack.pop();
                if (stack.empty() == false) {
                    int height = Math.min(A[stack.peek()], A[i]) - A[top];
                    int width = i - stack.peek()-1;
                    result += height * width;
                }
            }
        }
        return result;
    }
}
