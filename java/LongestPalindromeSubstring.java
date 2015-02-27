public class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String curr = this.expand(s, i, i);
            if (curr.length() > result.length()) {
                result = curr;
            }
        }
        for (int i = 0; i < s.length()-1; i++) {
            String curr = this.expand(s, i, i+1);
            if (curr.length() > result.length()) {
                result = curr;
            }
        }
        return result;
    }
    
    public String expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i -= 1;
            j += 1;
        }
        return s.substring(i+1, j);
    }
}
