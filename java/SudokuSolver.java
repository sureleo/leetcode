public class Solution {
    public String digits = "123456789";
    public void solveSudoku(char[][] board) {
        this.dfs(0, 0, board);
    }
    
    public boolean dfs(int i, int j, char[][] board) {
        if (j == 9) {
            if (i == 8) {
                return true;
            } else {
                return this.dfs(i+1, 0, board);
            }
        }
        if (board[i][j] != '.') {
            return this.dfs(i, j+1, board);
        } else {
            for (int k = 0; k < 9; k++) {
                board[i][j] = this.digits.charAt(k);
                if (this.check(i, j, board) == false) {
                    board[i][j] = '.';
                } else {
                    if (this.dfs(i, j+1, board) == true) {
                        return true;
                    } else {
                        board[i][j] = '.';
                    }
                }
            }
        }
        return false;
    }
    
    public boolean check(int i, int j, char[][] board) {
        for (int m = 0; m < 9; m++) {
            if (m != i && board[m][j] == board[i][j]) {
                return false;
            }
        }
        for (int m = 0; m < 9; m++) {
            if (m != j && board[i][m] == board[i][j]) {
                return false;
            }
        }
        int tempm = i / 3 * 3;
        int tempn = j / 3 * 3;
        for (int m = tempm; m < tempm + 3; m++) {
            for (int n = tempn; n < tempn + 3; n++) {
                if (i != m && j != n && board[m][n] == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main (String args[]) {
        Solution sol = new Solution();
        String[] boards = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = boards[i].charAt(j);
            }
        }
        sol.solveSudoku(board);
        System.out.println(board[0][0]);
    }
}
