public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        
        int opt[][] = new int[m][n];
        opt[0][0] = 1;
        
        for (int i = 1; i < m; i++) {
            opt[i][0] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            opt[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                opt[i][j] = opt[i-1][j] + opt[i][j-1];
            }
        }
        
        return opt[m-1][n-1];
    }
}
