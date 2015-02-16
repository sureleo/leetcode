public class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length() + 1;
        int length2 = word2.length() + 1;
        int[][] opt = new int[length1][length2];
        //base
        for (int i = 0; i < length1; i++) {
            opt[i][0] = i;
        }
        for (int i = 0; i < length2; i++) {
            opt[0][i] = i;
        }
        
        //fill in recursion
        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    opt[i][j] = opt[i-1][j-1];
                } else {
                    opt[i][j] = Math.min(Math.min(opt[i-1][j]+1, opt[i-1][j-1]+1), opt[i][j-1]+1);
                }
            }
        }
        return opt[length1-1][length2-1];
    }
}
