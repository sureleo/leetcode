public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            while (Character.isLetterOrDigit(s.charAt(low)) == false && low < high) {
                low += 1;
            }
            while (Character.isLetterOrDigit(s.charAt(high)) == false && low < high) {
                high -= 1;
            }
            if (low >= high) {
                return true;
            }
            if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))) {
                return false;
            } else {
                low += 1;
                high -= 1;
            }
        }
        return true;
    }
}
