public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean opt[] = new boolean[s.length()+1];
        opt[0] = true;

        for (int i = 0; i < opt.length; i++) {
            for (int j = i + 1; j < opt.length; j++) {
                opt[j] = (wordDict.contains(s.substring(i, j)) && opt[i]) || opt[j];
            }
        }

        return opt[s.length()];
    }
}
