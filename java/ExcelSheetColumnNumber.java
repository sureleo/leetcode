public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        int power26 = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = s.charAt(i) - 'A' + 1;
            result += digit * power26;
            power26 = power26 * 26;
        }
        
        return result;
    }
}
