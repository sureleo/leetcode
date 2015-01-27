class Solution {
public:
    vector<vector<int> > generateMatrix(int n) {
        std::vector<std::vector<int>> result (n, std::vector<int>(n, 0));
        int rows = n;
        int cols = n;
        int i = 0;
        int row = 0;
        int col = 0;
        int startCol = 0;
        int startRow = 0;
        int direction = 0;
        while (i < n * n) {
            i ++;
            result[row][col] = i;
            if (direction == 0) {
                if (col == cols - 1) {
                    row ++;
                    direction = 1;
                } else {
                    col ++;
                }
            } else if (direction == 1) {
                if (row == rows - 1) {
                    col --;
                    direction = 2;
                } else {
                    row ++;
                }
            } else if (direction == 2) {
                if (col == startCol) {
                    row --;
                    direction = 3;
                } else {
                    col --;
                }
            } else {
                if (row == startRow + 1) {
                    startRow ++;
                    startCol ++;
                    col ++;
                    direction = 0;
                    cols --;
                    rows --;
                } else {
                    row --;
                }
            }
        }
        return result;
    }
};
