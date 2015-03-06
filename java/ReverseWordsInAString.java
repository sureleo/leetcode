public class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int end = s.length() - 1;
        int start = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (end != start) {
                    result.append(s.substring(start+1, end+1));
                    end = start;
                }
                end --;
                start --;
            } else {
                if (result.length() != 0 && end == start) {
                    result.append(' ');
                }
                start --;
            }
        }
        if (end != start || (start > 0 && s.substring(start, end+1) != " ")) {
            result.append(s.substring(start+1, end+1));
        }
        return result.toString();
    }
}
