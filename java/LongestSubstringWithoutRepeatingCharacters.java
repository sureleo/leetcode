public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int slow = 0;
        int fast = 0;
        int result = 0;
        while (fast < s.length()) {
            if (map.containsKey(s.charAt(fast)) == true) {
                result = Math.max(fast-slow, result);
                int temp = map.get(s.charAt(fast));
                while (slow <= temp) {
                    map.remove(s.charAt(slow));
                    slow += 1;
                }
            }
            map.put(s.charAt(fast), fast);
            fast += 1;
        }
        result = Math.max(fast-slow, result);
        return result;
    }
}
