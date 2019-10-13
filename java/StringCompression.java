class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        
        if (chars.length == 1) {
            return 1;
        }
        
        int result = 0;
        int slow = 0;
        int fast = 1;
        
        while (fast < chars.length) {
            if (chars[fast] == chars[slow]) {
                fast ++;
            } else {
                if (fast == slow + 1) {
                    chars[result] = chars[slow];
                    result++;
                } else {
                    int distance = fast - slow;
                    String distanceString = Integer.toString(distance);
                    
                    chars[result] = chars[slow];
                    result ++;
                    for (int i = 0; i < distanceString.length(); i++) {
                        chars[result] = distanceString.charAt(i);
                        result++;
                    }
                }
                
                slow = fast;
                fast ++;
            }
        }
        
        if (slow + 1 == fast) {
            chars[result] = chars[slow];
            result++;
        } else {
            int distance = fast - slow;
            String distanceString = Integer.toString(distance);
                    
            chars[result] = chars[slow];
            result ++;
            for (int i = 0; i < distanceString.length(); i++) {
                chars[result] = distanceString.charAt(i);
                result++;
            }
        }
        
        return result;
    }
}
