import java.util.*;
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] opt = new boolean[s.length()+1];
        opt[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if (opt[i] && dict.contains(s.substring(i, j))) {
                    opt[j] = true;
                }
            }
        }
        return opt[s.length()];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Set<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("abc");
        dict.add("b");
        dict.add("cd");
        System.out.println(sol.wordBreak("abcd", dict));
    }
}
