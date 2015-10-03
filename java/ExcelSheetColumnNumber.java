public class Solution {
    public int titleToNumber(String s) {
        int base = (int)'A' - 1;
        int result = 0;
        int base26 = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            result = ((int)s.charAt(i) - base) * base26 + result;
            base26 = base26 * 26;
        }
        
        return result;
    }
}
