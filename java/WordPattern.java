public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        Map<Character, String> charToStr = new HashMap<Character, String>();
        Map<String, Character> strToChar = new HashMap<String, Character>();
        if (pattern.length() != strs.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (charToStr.containsKey(pattern.charAt(i)) == false) {
                charToStr.put(pattern.charAt(i), strs[i]);
            } else {
                if (charToStr.get(pattern.charAt(i)).equals(strs[i]) == false) {
                    return false;
                }
            }

            if (strToChar.containsKey(strs[i]) == false) {
                strToChar.put(strs[i], pattern.charAt(i));
            } else {
                if (strToChar.get(strs[i]) != pattern.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
