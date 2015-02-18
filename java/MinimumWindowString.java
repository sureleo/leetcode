import java.util.*;
public class Solution {
    public String minWindow(String S, String T) {
        String result = new String();
        int min_length = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int count = T.length();
        int start = 0;
        for (int i = 0; i < T.length(); i++) {
            Character curr = T.charAt(i);
            if (map.containsKey(curr) == true) {
                map.put(curr, map.get(curr)+1);
            } else {
                map.put(curr, 1);
            }
        }

        for (int i = 0; i < S.length(); i++) {
            Character curr = S.charAt(i);
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr)-1);
                if (map.get(curr) >= 0) {
                    count -= 1;
                }
                if (count == 0) {
                    while (true) {
                        Character curr_start = S.charAt(start);
                        if (map.containsKey(curr_start)) {
                            if (map.get(curr_start) >= 0) {
                                break;
                            }
                            map.put(curr_start, map.get(curr_start) + 1);
                        } 
                        start += 1;
                    }
                    if ((i-start+1) < min_length) {
                        result = S.substring(start, i+1);
                        min_length = i - start + 1;
                    }
                }
            }
        }
        return result;
    }

    public static void main (String[] args) {
        String S = "cabwefgewcwaefgcf";
        String T = "cae";
        Solution sol = new Solution();
        System.out.println(sol.minWindow(S, T));
    }
}
