public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int result = 0;
        if (rows == 0) {
            return result;
        }

        int cols = matrix[0].length;
        int opt[][] = new int[rows][cols];
        opt[0][0] = Character.getNumericValue(matrix[0][0]);
        result = opt[0][0];

        for (int i = 1; i < rows; i++) {
            if (result == 0 && matrix[i][0] == '1') {
                result = 1;
            }

            opt[i][0] = Character.getNumericValue(matrix[i][0]);
        }

        for (int i = 1; i < cols; i++) {
            if (result == 0 && matrix[0][i] == '1') {
                result = 1;
            }

            opt[0][i] = Character.getNumericValue(matrix[0][i]);
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (result == 0 && matrix[i][j] == '1') {
                    result = 1;
                }

                if (matrix[i][j] == '0') {
                    opt[i][j] = 0;
                }

                if (matrix[i][j] == '1') {
                    opt[i][j] = Math.min(Math.min(opt[i][j-1], opt[i-1][j]), opt[i-1][j-1]) + 1;
                    result = Math.max(result, opt[i][j]);
                }
            }
        }

        return result * result;
    }
}
