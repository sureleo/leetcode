public class Solution {
    public int result = 0;
    public int rows = 0;
    public int cols = 0;
    
    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    result += 1;
                    this.dfs(grid, i, j);
                }
            }
        }
        
        return result;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > rows - 1 || j > cols - 1) {
            return;
        }
        
        if (grid[i][j] != '1') {
            return;
        }
        
        grid[i][j] = 'X';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
