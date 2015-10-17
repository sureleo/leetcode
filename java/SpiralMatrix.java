public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int row = matrix.length;
        if (row == 0) {
            return result;
        }
        
        int col = matrix[0].length;
        int rStart = 0;
        int cStart = 0;
        int i = 0;
        char direction = 'R';
        int r = 0;
        int c = 0;
        int total = row * col;
        while (i < total) {
            result.add(matrix[r][c]);
            if (direction == 'R') {
                if (c == col - 1) {
                    direction = 'D';
                    r += 1;
                } else {
                    c += 1;
                }
            } else if (direction == 'D') {
                if (r == row - 1) {
                    direction = 'L';
                    c -= 1;
                } else {
                    r += 1;
                }
            } else if (direction == 'L') {
                if (c == cStart) {
                    direction = 'U';
                    r -= 1;
                } else {
                    c -= 1;
                }
            } else {
                if (r == rStart + 1) {
                    rStart += 1;
                    cStart += 1;
                    r = rStart;
                    c = cStart;
                    row -= 1;
                    col -= 1;
                    direction = 'R';
                } else {
                    r -= 1;
                }
            }
            
            i += 1;
        }
        
        return result;
    } 
}
