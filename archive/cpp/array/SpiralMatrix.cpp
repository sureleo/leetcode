#include <vector>

class Solution {
public:
    std::vector<int> spiralOrder(std::vector<std::vector<int> > &matrix) {
        std::vector<int> result;
        int rows = int(matrix.size());
        if (rows == 0) {
            return result;
        }

        int cols = int(matrix[0].size());
        int total = rows * cols;
        int i = 0;
        int startRow = 0;
        int startCol = 0;
        int direction = 0;
        int row = 0;
        int col = 0;
        while (i < total) {
            i ++;
            result.push_back(matrix[row][col]);
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
                if (row == startRow - 1) {
                    col ++;
                    startRow ++;
                    startCol ++;
                    cols --;
                    rows --;
                    direction = 1;
                } else {
                    row --;
                }
            }
        }
        return result;
    }
};
