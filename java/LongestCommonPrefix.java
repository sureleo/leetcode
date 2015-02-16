public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        Boolean shortest = false;
        if (strs.length == 0) {
            return result.toString();
        }
        
        while (true == true) {
            for (int j = 0; j < strs.length; j ++) {
                if (i >= strs[j].length()) {
                    shortest = true;
                    break;
                }
            }
            if (shortest == true) {
                return result.toString();
            }
            char firstChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (strs[j].charAt(i) != firstChar) {
                    return result.toString();
                }
            }
            result.append(firstChar);
            i += 1;
        }
    }
}
