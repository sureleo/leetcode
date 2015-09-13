public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row == 0) {
            return 0;
        }
        
        int col = obstacleGrid[0].length;
        int opt[][] = new int[row][col];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        opt[0][0] = 1;
        
        boolean hasObstacle = false;
        for (int i = 1; i < row; i++) {
            if (hasObstacle == false) {
                if (obstacleGrid[i][0] == 0) {
                    opt[i][0] = 1;
                } else {
                    hasObstacle = true;
                    opt[i][0] = 0;
                }
            } else {
                opt[i][0] = 0;
            }
        }
        
        hasObstacle = false;
        for (int i = 1; i < col; i++) {
            if (hasObstacle == false) {
                if (obstacleGrid[0][i] == 0) {
                    opt[0][i] = 1;
                } else {
                    hasObstacle = true;
                    opt[0][i] = 0;
                }
            } else {
                opt[0][i] = 0;
            }
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    opt[i][j] = 0;
                } else {
                    opt[i][j] = opt[i-1][j] + opt[i][j-1];
                }
            }
        }
        
        return opt[row-1][col-1];
    }
}
