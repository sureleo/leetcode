// http://www.programcreek.com/2014/05/leetcode-zigzag-conversion-java/
// this solution is really clean
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        int steps = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j += steps) {
                    sb.append(s.charAt(j));
                }
            } else {
                int j = i;
                int step1 = 2 * (numRows - i - 1);
                int step2 = steps - step1;
                boolean flag = true;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    if (flag == true) {
                        j = j + step1;
                    } else {
                        j = j + step2;
                    }
                    
                    flag = !flag;
                }
            }
        }
        
        return sb.toString();
    }
}
