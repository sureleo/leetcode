//http://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
//public class Solution {
//    public int evalRPN(String[] tokens) {
//        Stack<Integer> stack = new Stack<Integer>();
//        for (int i = 0; i < tokens.length; i++) {
//            try {
//                stack.push(Integer.parseInt(tokens[i]));
//            } catch(Exception e) {
//                int op2 = stack.pop();
//                int op1 = stack.pop();
//                int result = 0;
//                if (tokens[i] == "+") {
//                    result = op1 + op2;
//                } else if (tokens[i] == "-") {
//                    result = op1 - op2;
//                } else if (tokens[i] == "*") {
//                    result = op1 * op2;
//                } else {
//                    result = op1 / op2;
//                }
//                stack.push(result);
//            }
//        }
//        return stack.peek();
//    }
//
//    public static void main (String[] args) {
//        String[] tokens = {"4","-2","/","2","-3","-","-"};
//        Solution sol = new Solution();
//        System.out.println(sol.evalRPN(tokens));
//    }
//}
//It is so weird that my solution generate an error about divisor is 0
import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
        int returnValue = 0;
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();
        for(String t : tokens){
            if(!operators.contains(t)){
                stack.push(t);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch(index){
                    case 0:
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b-a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }
        returnValue = Integer.valueOf(stack.pop());
        return returnValue;
    }
}
