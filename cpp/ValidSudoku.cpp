#include <vector>
#include <unordered_map>
#include <iostream>
class Solution {
public:
    bool isValidSudoku(std::vector<std::vector<char> > &board) {
        for (int i = 0; i < 9; i++) {
            std::unordered_map<char, bool> map;
            for(int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (map.find(board[i][j]) == map.end()) {
                    map[board[i][j]] = true;
                } else {
                    return false;
                }
            }
        }
        
        for (int j = 0; j < 9; j++) {
            std::unordered_map<char, bool> map;
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (map.find(board[i][j]) == map.end()) {
                    map[board[i][j]] = true;
                } else {
                    return false;
                }
            }
        }
        
        for (int m = 0; m <= 6; m+=3) {
            for (int n = 0; n <= 6; n+=3) {
                std::unordered_map<char, bool> map;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i+m][j+n] == '.') {
                            continue;
                        }
                        if (map.find(board[i+m][j+n]) == map.end()) {
                            map[board[i+m][j+n]] = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
};

int main () {
    char row0[9] = {'.', '.', '.', '.', '.', '.', '5', '.', '.'};
    char row1[9] = {'.', '4', '.', '.', '.', '.', '.', '.', '.'};
    char row2[9] = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
    char row3[9] = {'9', '3', '.', '.', '2', '4', '.', '.', '.'};
    char row4[9] = {'.', '.', '7', '.', '.', '.', '3', '.', '.'};
    char row5[9] = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
    char row6[9] = {'.', '.', '.', '3', '4', '.', '.', '.', '.'};
    char row7[9] = {'.', '.', '.', '.', '.', '3', '.', '.', '.'};
    char row8[9] = {'.', '.', '.', '.', '.', '5', '2', '.', '.'};

    std::vector<char> myVector0 (row0, row0 + 9);
    std::vector<char> myVector1 (row1, row1 + 9);
    std::vector<char> myVector2 (row2, row2 + 9);
    std::vector<char> myVector3 (row3, row3 + 9);
    std::vector<char> myVector4 (row4, row4 + 9);
    std::vector<char> myVector5 (row5, row5 + 9);
    std::vector<char> myVector6 (row6, row6 + 9);
    std::vector<char> myVector7 (row7, row7 + 9);
    std::vector<char> myVector8 (row8, row8 + 9);

    std::vector<std::vector<char> > matrix;
    matrix.push_back(myVector0);
    matrix.push_back(myVector1);
    matrix.push_back(myVector2);
    matrix.push_back(myVector3);
    matrix.push_back(myVector4);
    matrix.push_back(myVector5);
    matrix.push_back(myVector6);
    matrix.push_back(myVector7);
    matrix.push_back(myVector8);

    Solution *s = new Solution();
    s->isValidSudoku(matrix);
}
