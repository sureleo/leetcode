#include <vector>
#include <iostream>

class Solution {
public:
    int maximalRectangle(std::vector<std::vector<char> > &matrix) {
        int rows = int(matrix.size());
        if (rows == 0) {
            return 0;
        }
        int cols = int(matrix[0].size());
        
        std::vector<int> auxRows (cols, 0);
        std::vector<std::vector<int> > auxMatrix;

        for (int i = 0; i < rows; i ++) {
            auxMatrix.push_back(auxRows);
        }
        
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (matrix[i][j] == '0') {
                    auxMatrix[i][j] = 0;
                } else {
                    if (j == 0) {
                        auxMatrix[i][j] = 1;
                    } else {
                        auxMatrix[i][j] = auxMatrix[i][j-1] + 1;
                    }
                }
            }
        }


        int maxRect = 0;
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                int height = 1;
                int width = auxMatrix[i][j];
                for (int k = i - 1; k >= 0; k --) {
                    if (auxMatrix[k][j] >= auxMatrix[i][j]) {
                        height += 1;
                    } else {
                        break;
                    }
                }
                for (int k = i + 1; k < rows; k ++) {
                    if (auxMatrix[k][j] >= auxMatrix[i][j]) {
                        height += 1;
                    } else {
                        break;
                    }
                }
                maxRect = std::max(maxRect, height*width);
            }
        }
        return maxRect;
    }
};

int main () {
    char row0[4] = {'1', '1', '0', '1'};
    char row1[4] = {'1', '1', '0', '1'};
    char row2[4] = {'1', '1', '1', '1'};
    std::vector<char> vector_row0 (row0, row0+4);
    std::vector<char> vector_row1 (row1, row1+4);
    std::vector<char> vector_row2 (row2, row2+4);

    std::vector<std::vector<char> > matrix;
    matrix.push_back(vector_row0);
    matrix.push_back(vector_row1);
    matrix.push_back(vector_row2);

    Solution *s = new Solution();
    std::cout<<s->maximalRectangle(matrix)<<std::endl;
    delete s;
}


