public class Solution {
    public int numDistinct(String s, String t) {
        int rows = s.length() + 1;
        int cols = t.length() + 1;
        int[][] opt = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            opt[0][i] = 0;
        }
        
        for (int i = 0; i < rows; i++) {
            opt[i][0] = 1;
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (j > i) {
                    opt[i][j] = 0;
                } else if (s.charAt(i-1) == t.charAt(j-1)) {
                    opt[i][j] = opt[i-1][j] + opt[i-1][j-1];
                } else {
                    opt[i][j] = opt[i-1][j];
                }
            }
        }
        
        return opt[rows-1][cols-1];
    }
}
