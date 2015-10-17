public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int total = n * n;
        char direction = 'R';
        int start = 0;
        int end = n;
        int r = 0;
        int c = 0;
        int i = 1;
        
        while (i <= total) {
            result[r][c] = i;
            i += 1;
            if (direction == 'R') {
                if (c == end - 1) {
                    direction = 'D';
                    r += 1;
                } else {
                    c += 1;
                }
            } else if (direction == 'D') {
                if (r == end - 1) {
                    direction = 'L';
                    c -= 1;
                } else {
                    r += 1;
                }
            } else if (direction == 'L') {
                if (c == start) {
                    direction = 'U';
                    r -= 1;
                } else {
                    c -= 1;
                }
            } else {
                if (r == start + 1) {
                    c += 1;
                    start += 1;
                    end -= 1;
                    direction = 'R';
                } else {
                    r -= 1;
                }
            }
        }
        
        return result;
    }
}
