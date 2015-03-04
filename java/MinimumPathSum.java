public class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        
        int[][] opt = new int[rows][cols];
        opt[0][0] = grid[0][0];
        
        for (int i = 1; i < cols; i++) {
            opt[0][i] = opt[0][i-1] + grid[0][i];
        }
        
        for (int i = 1; i < rows; i++) {
            opt[i][0] = opt[i-1][0] + grid[i][0];
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                opt[i][j] = Math.min(opt[i][j-1], opt[i-1][j])  + grid[i][j];
            }
        }
        return opt[rows-1][cols-1];
    }
}
