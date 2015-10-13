// https://siddontang.gitbooks.io/leetcode-solution/content/string/basic_calculator_2.html  
// Math problem is always hard. Basically following idea of previous solution.
// +- do it right now. */ put it into temp and sum it later.
public class Solution {
    public int calculate(String s) {
        int result = 0;
        int temp = 0;
        int i = 0;
        char op = '+';
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i += 1;
                continue;
            }
            
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (int)s.charAt(i) - (int)'0';
                    i += 1;
                }
                
                if (op == '+') {
                    temp += num;
                } else if (op == '-') {
                    temp -= num;
                } else if (op == '*') {
                    temp *= num;
                } else {
                    temp /= num;
                }
            } else {
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    result += temp;
                    temp = 0;
                }
                
                op = s.charAt(i);
                i += 1;
            }
        }
        
        return result + temp;
    }
}
