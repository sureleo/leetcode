public class Solution {
    public int row = 0;
    public int col = 0;
    
    public void setZeroes(int[][] matrix) {
        boolean firstRowIsZero = false;
        boolean firstColIsZero = false;
        row = matrix.length;
        col = matrix[0].length;
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                firstRowIsZero = true;
                break;
            }
        }
        
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstColIsZero = true;
                break;
            }
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == 0) {
                setColZero(matrix, i, 1);
            }
        }
        
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                setRowZero(matrix, i, 1);
            }
        }
        
        if (firstRowIsZero == true) {
            setRowZero(matrix, 0, 0);
        }
        
        if (firstColIsZero == true) {
            setColZero(matrix, 0, 0);
        }
    }
    
    public void setRowZero(int[][] matrix, int r, int start) {
        for (int i = start; i < this.col; i++) {
            matrix[r][i] = 0;
        }
    }
    
    public void setColZero(int[][] matrix, int c, int start) {
        for (int i = start; i < this.row; i++) {
            matrix[i][c] = 0;
        }
    }
}
