
class Solution {
public:
    bool result;
    int rows;
    int cols;
    std::vector<std::vector<char> > board;
    
public:
    Solution () {
        this->result = false;
    }
    
    bool exist(std::vector<std::vector<char> > &board, std::string word) {
        this->rows = int(board.size());
        this->cols = int(board[0].size());
        this->board = board;
        for (int i = 0; i < this->rows; i ++) {
            for (int j = 0; j < this->cols; j ++) {
                if (board[i][j] == word.at(0)) {
                    this->dfs(i, j, word.substr(1, word.length()-1));
                }
            }
        }
        return this->result;
    }
    
    void dfs(int i, int j, std::string word) {
        if (this->result) {
            return;
        }
        if (word.length() == 0) {
            this->result = true;
            return;
        }
        if (!this->result) {
            int up = i - 1;
            int down = i + 1;
            int left = j - 1;
            int right = j + 1;
            char temp = this->board[i][j];
            this->board[i][j] = '.';
            if (up >= 0 && this->board[up][j] == word.at(0)) {
                this->dfs(up, j, word.substr(1, word.length()-1));
            }
            if (down <= this->rows - 1 && this->board[down][j] == word.at(0)) {
                this->dfs(down, j, word.substr(1, word.length()-1));
            }
            if (left >= 0 && this->board[i][left] == word.at(0)) {
                this->dfs(i, left, word.substr(1, word.length()-1));
            }
            if (right <= this->cols - 1 && this->board[i][right] == word.at(0)) {
                this->dfs(i, right, word.substr(1, word.length()-1));
            }
            this->board[i][j] = temp;
        }
    }
};
