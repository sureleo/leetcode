public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean result = true;
            int tempI = i;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(tempI) != needle.charAt(j)) {
                    result = false;
                    break;
                } else {
                    tempI += 1;
                }
            }

            if (result == true) {
                return i;
            }
        }

        return -1;
    }
}
