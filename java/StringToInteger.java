public class Solution {
    public int atoi(String str) {
        int i = 0;
        int negative = 1;
        int result = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        
        if (i == str.length()) {
            return result;
        }
        
        if (str.charAt(i) == '+') {
            i ++;
        } else if (str.charAt(i) == '-') {
            i ++;
            negative = -1;
        }
        
        while (i < str.length() && Character.isDigit(str.charAt(i)) == true) {
            if (Integer.MAX_VALUE / 10 >= result) {
                result = result * 10;
            } else {
                if (negative == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            
            int digit = str.charAt(i) - '0';
            if (Integer.MAX_VALUE - digit >= result) {
                result = result + digit;
            } else {
                if (negative == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            
            i += 1;
        }
        return negative * result;
    }
}
